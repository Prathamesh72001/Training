package com.example.training

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class ActivityC : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_c)

        //hooks
        val a = findViewById<Button>(R.id.A)
        val e = findViewById<Button>(R.id.E)


        //listeners
        a.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }


        e.setOnClickListener {


            val intent = Intent(this, ActivityE::class.java)
            intent.putExtra("From", "C")
            startActivity(intent)


        }
    }
}