package com.example.training

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class ActivityD : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_d)


        //hooks
        val e = findViewById<Button>(R.id.E)


        //listeners
        e.setOnClickListener {

            val intent = Intent(this, ActivityE::class.java)
            intent.putExtra("From", "D")
            startActivity(intent)


        }
    }
}