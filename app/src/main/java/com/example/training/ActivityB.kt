package com.example.training

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class ActivityB : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_b)
        //hooks
        val d=findViewById<Button>(R.id.D)
        val e=findViewById<Button>(R.id.E)
        //listeners
        d.setOnClickListener {
            val intent= Intent(this,ActivityD::class.java)
            startActivity(intent)
        }

        e.setOnClickListener {
            val intent= Intent(this,ActivityE::class.java)
            startActivity(intent)
        }
    }


}