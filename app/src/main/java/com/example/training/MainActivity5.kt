package com.example.training

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity5 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main5)


        val recyclerview = findViewById<RecyclerView>(R.id.recycler)
        recyclerview.layoutManager = LinearLayoutManager(this)

        val data = ArrayList<HelperClass>()


        data.add(HelperClass(R.drawable.square, "A"))
        data.add(HelperClass(R.drawable.square, "B"))
        data.add(HelperClass(R.drawable.square, "C"))
        data.add(HelperClass(R.drawable.square, "D"))
        data.add(HelperClass(R.drawable.square, "E"))
        data.add(HelperClass(R.drawable.square, "F"))
        data.add(HelperClass(R.drawable.square, "G"))
        data.add(HelperClass(R.drawable.square, "H"))
        data.add(HelperClass(R.drawable.square, "I"))

        val adapter = Adapter3(data)

        recyclerview.adapter = adapter

    }
}