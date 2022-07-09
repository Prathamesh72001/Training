package com.example.training

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.Button

class Adapter2(val context: Context, val buttons:Array<String>, val obj:MainActivity3):BaseAdapter() {
    var layoutInflater:LayoutInflater?=null
    lateinit var button: Button
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
            cView=layoutInflater!!.inflate(R.layout.button_layout2,null)
        }
        button=cView!!.findViewById(R.id.button)
        button.text=buttons[position]
        return cView
    }
}