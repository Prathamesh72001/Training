package com.example.training

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class Books_Adapter2(val bookList:ArrayList<BookHelperClass>):RecyclerView.Adapter<Books_Adapter2.customViewHolder>()  {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Books_Adapter2.customViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.books_detail_layout2, parent, false)

        return customViewHolder(view)
    }

    override fun onBindViewHolder(holder: Books_Adapter2.customViewHolder, position: Int) {
        val obj=bookList[position]

        holder.imageView.setImageResource(obj.bookImage)
        holder.bookName.text=obj.bookName
        holder.bookAuthor.text=obj.authorName
    }

    override fun getItemCount(): Int {
        return bookList.size
    }

    inner class customViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.bookImage)
        val bookName: TextView = itemView.findViewById(R.id.bookName)
        val bookAuthor: TextView = itemView.findViewById(R.id.bookAuthor)
    }
}