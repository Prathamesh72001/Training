package com.example.training

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView

class Books_Adapter(): RecyclerView.Adapter<Books_Adapter.customViewHolder>() {
    var bookList=ArrayList<BookHelperClass>()

    constructor(bookList:ArrayList<BookHelperClass>) : this(){
        this.bookList=bookList
    }

    inner class customViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.bookImage)
        val bookName: TextView = itemView.findViewById(R.id.bookName)
        val bookAuthor: TextView = itemView.findViewById(R.id.bookAuthor)
        val favourite: ImageView = itemView.findViewById(R.id.favourite)
        val unfavourite: ImageView = itemView.findViewById(R.id.unfavourite)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): customViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.book_details_layout, parent, false)

        return customViewHolder(view)
    }

    override fun onBindViewHolder(holder: customViewHolder, position: Int) {
        val obj=bookList[position]

        holder.imageView.setImageResource(obj.bookImage)
        holder.bookName.text=obj.bookName
        holder.bookAuthor.text=obj.authorName

        holder.favourite.setOnClickListener {
            obj.isFav=false
            holder.unfavourite.visibility=View.VISIBLE
            holder.favourite.visibility=View.GONE
            Fragment_Favourites().refresh(obj)
            Fragment_Unfavourites().refresh(obj)
        }

        holder.unfavourite.setOnClickListener {
            obj.isFav=true
            holder.unfavourite.visibility=View.GONE
            holder.favourite.visibility=View.VISIBLE
            Fragment_Favourites().refresh(obj)
            Fragment_Unfavourites().refresh(obj)
        }

        Fragment_Favourites().refresh(obj)
        Fragment_Unfavourites().refresh(obj)

    }


    override fun getItemCount(): Int {
        return bookList.size
    }



}