package com.example.training

import android.content.Context
import android.content.res.ColorStateList
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

internal class Adapter(val context: Context,val buttons:Array<String>) : BaseAdapter(){
    var layoutInflater:LayoutInflater?=null
    lateinit var button:ImageView
    lateinit var text:TextView
    override fun getCount(): Int {
        return buttons.size
    }

    override fun getItem(position: Int): Any? {
        return null
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var cView=convertView
        if(layoutInflater==null){
            layoutInflater=context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        }
        if(cView==null){
            cView=layoutInflater!!.inflate(R.layout.button_layout,null)
        }
        button=cView!!.findViewById(R.id.button)
        text=cView!!.findViewById(R.id.text)
        text.text=buttons[position]
        return cView
    }
}