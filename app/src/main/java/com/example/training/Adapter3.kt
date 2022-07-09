package com.example.training

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class Adapter3(private val mList: List<HelperClass>) : RecyclerView.Adapter<viewHolderClass>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolderClass{
        // inflates the card_view_design view
        // that is used to hold list item
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.recycler_layout, parent, false)

        return viewHolderClass(view)
    }

    // binds the list items to a view
    override fun onBindViewHolder(holder: viewHolderClass, position: Int) {

        val ItemsViewModel = mList[position]

        // sets the image to the imageview from our itemHolder class
        holder.imageView.setImageResource(ItemsViewModel.image)

        // sets the text to the textview from our itemHolder class
        holder.textView.text = ItemsViewModel.text

    }

    // return the number of the items in the list
    override fun getItemCount(): Int {
        return mList.size
    }
}