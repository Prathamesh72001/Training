package com.example.training

import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room

class NotesAdapter(val noteList:MutableList<Notes>,val context: Context): RecyclerView.Adapter<NotesAdapter.customViewHolder>() {
    inner class customViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
        val note: TextView = itemView.findViewById(R.id.note)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotesAdapter.customViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.notes_layout, parent, false)

        return customViewHolder(view)
    }

    override fun onBindViewHolder(holder: NotesAdapter.customViewHolder, position: Int) {
        val o=noteList[position]

        holder.note.text=o.note

        holder.itemView.setOnLongClickListener(object :View.OnLongClickListener{
            override fun onLongClick(v: View?): Boolean {
                AlertDialog.Builder(context).setTitle("Delete Note").setMessage("Do you want to delete this note ?")
                    .setPositiveButton("Yes", DialogInterface.OnClickListener { dialog, which ->

                        deleteThread(o).start()
                        noteList.remove(o)
                        notifyDataSetChanged()

                        Toast.makeText(context,"Note Removed Successfully",Toast.LENGTH_LONG).show()
                    }).setNegativeButton("No",null).show()
                return true
            }

        })

        holder.itemView.setOnClickListener {
            val intent=Intent(context,NotesCreateActivity2::class.java)
            intent.putExtra("dataid",o.id)
            intent.putExtra("datanote",o.note)
            context.startActivity(intent)
        }
    }

    inner class deleteThread(val o: Notes):Thread(){
        override fun run(){
            val obj=NoteDatabaseClass.getInstance(context)
            obj.noteDao().delete(o)
        }
    }

    override fun getItemCount(): Int {
        return noteList.size
    }
}