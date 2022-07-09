package com.example.training

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class ActivityE : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_e)

        //hooks
        val b = findViewById<Button>(R.id.B)
        val c = findViewById<Button>(R.id.C)
        val d = findViewById<Button>(R.id.D)
        val a = findViewById<Button>(R.id.A)

        //listeners
        b.setOnClickListener {

            val intent = Intent(this, ActivityB::class.java)
            startActivity(intent)
            finishAffinity()

        }

        c.setOnClickListener {

            val intent = Intent(this, ActivityC::class.java)
            startActivity(intent)
            finishAffinity()

        }

        d.setOnClickListener {

            val intent = Intent(this, ActivityD::class.java)
            startActivity(intent)
            finishAffinity()

        }

        a.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finishAffinity()
        }
    }
}