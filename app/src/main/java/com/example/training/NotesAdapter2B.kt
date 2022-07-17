package com.example.training

import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.PopupMenu
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.RecyclerView

class NotesAdapter2B(val noteList: MutableList<Notes2>?, val context: Context) :
    RecyclerView.Adapter<NotesAdapter2B.customViewHolder>() {

    inner class customViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val note: TextView = itemView.findViewById(R.id.note)
        val time: TextView = itemView.findViewById(R.id.time)
        val menu: ImageView = itemView.findViewById(R.id.popupmenu)
        val favourites: ImageView = itemView.findViewById(R.id.favourite)
        val unfavourites: ImageView = itemView.findViewById(R.id.unfavourite)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): customViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.notes_layout2, parent, false)

        return customViewHolder(view)
    }

    override fun onBindViewHolder(holder: customViewHolder, position: Int) {
        val o = noteList!![position]

        holder.note.text = o.note
        holder.time.text = o.time


        holder.favourites.visibility = View.VISIBLE



        holder.menu.setOnClickListener {
            val popupmenu = PopupMenu(context, holder.menu)
            popupmenu.menuInflater.inflate(R.menu.popup_menu, popupmenu.menu)
            popupmenu.setOnMenuItemClickListener(object : PopupMenu.OnMenuItemClickListener {
                override fun onMenuItemClick(item: MenuItem?): Boolean {
                    when (item!!.itemId) {
                        R.id.nav_delete -> {
                            AlertDialog.Builder(context).setTitle("Delete Note")
                                .setMessage("Do you want to delete this note ?")
                                .setPositiveButton(
                                    "Yes",
                                    DialogInterface.OnClickListener { dialog, which ->

                                        deleteThread(o).start()
                                        try {
                                            /*noteList.remove(o)
                                            notifyDataSetChanged()
                                            FavouriteFrag().emptyTV_visibility()

                                            NotesFrag.notes?.remove(o)
                                            NotesFrag.listadapter!!.notifyDataSetChanged()*/
                                            NotesFrag().emptyTV_visibility()

                                        } catch (e: Exception) {

                                        }

                                        Toast.makeText(
                                            context,
                                            "Note Removed Successfully",
                                            Toast.LENGTH_LONG
                                        ).show()
                                    }).setNegativeButton("No", null).show()
                        }

                    }
                    return true
                }

            })
            popupmenu.show()
        }

        holder.itemView.setOnClickListener {
            val intent = Intent(context, NotesCreateActivity3::class.java)
            intent.putExtra("dataid", o.id)
            intent.putExtra("datanote", o.note)
            context.startActivity(intent)
        }

        holder.favourites.setOnClickListener {
            holder.unfavourites.visibility = View.VISIBLE
            holder.favourites.visibility = View.GONE
            setUnfavThread(o.id!!).start()
            try {
                /*noteList.remove(o)
                notifyDataSetChanged()*/
                FavouriteFrag().emptyTV_visibility()
                //NotesFrag().update(o)
            } catch (e: Exception) {

            }
        }

    }


    inner class setUnfavThread(val id: Int) : Thread() {
        override fun run() {
            val obj = Notes2DatabaseClass.getInstance(context)
            obj.noteDao().setUnfav(id)
        }
    }

    inner class deleteThread(val o: Notes2) : Thread() {
        override fun run() {
            val obj = Notes2DatabaseClass.getInstance(context)
            obj.noteDao().delete(o)
        }
    }

    override fun getItemCount(): Int {
        return noteList!!.size
    }
}