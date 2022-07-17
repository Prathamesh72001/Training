package com.example.training

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class StudentAdapter(val list:ArrayList<StudentHelperClass>):RecyclerView.Adapter<StudentAdapter.viewHolder>() {

    inner class viewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        val id:TextView=itemView.findViewById(R.id.id)
        val name:TextView=itemView.findViewById(R.id.name)
        val age:TextView=itemView.findViewById(R.id.age)
        val marks:TextView=itemView.findViewById(R.id.marks)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.students_layout, parent, false)

        return viewHolder(view)
    }

    override fun onBindViewHolder(holder: viewHolder, position: Int) {
        val o=list[position]

        holder.id.text = "ID : "+ o.id
        holder.name.text = "Name : "+o.name
        holder.age.text = "Age : "+o.age
        var s:String=""
        for(i in 0 until o.marks.length()){
            val mark=o.marks.get(i)
            s+= "$mark  "
        }
        holder.marks.text = "Marks : "+s
    }

    override fun getItemCount(): Int {
        return list.size
    }
}