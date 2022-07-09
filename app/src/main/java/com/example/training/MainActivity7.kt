package com.example.training

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.FrameLayout

class MainActivity7 : AppCompatActivity() {
    @SuppressLint("CommitTransaction")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main7)

        val container=findViewById<FrameLayout>(R.id.container)
        if(savedInstanceState==null){
            supportFragmentManager
                .beginTransaction()
                .add(container.id, Fragment3())
                .disallowAddToBackStack()
                .commit();
        }
    }
}