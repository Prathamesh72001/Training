package com.example.training

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.LinearLayout
import android.widget.TextView

class UserData : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_data)

        val id=intent.getStringExtra("ID")
        val username=intent.getStringExtra("Username")
        val gender=intent.getStringExtra("Gender")
        val qualification=intent.getStringExtra("Qualification")
        val hobbies=intent.getStringExtra("Hobbies")
        val ratings=intent.getStringExtra("Ratings")

        val linearLayout = findViewById<LinearLayout>(R.id.linear)

        val idTV=TextView(this)
        idTV.text="ID : "+id
        idTV.textSize=20f
        linearLayout.addView(idTV)

        val usernameTV=TextView(this)
        usernameTV.text="Username : "+username
        usernameTV.textSize=20f
        linearLayout.addView(usernameTV)

        val genTV=TextView(this)
        genTV.text="Gender : "+gender
        genTV.textSize=20f
        linearLayout.addView(genTV)

        val qualTV=TextView(this)
        qualTV.text="Qualification : "+qualification
        qualTV.textSize=20f
        linearLayout.addView(qualTV)

        val hobbyTV=TextView(this)
        hobbyTV.text="Hobbies : "+hobbies
        hobbyTV.textSize=20f
        linearLayout.addView(hobbyTV)

        val ratingTV=TextView(this)
        ratingTV.text="Rating : "+ratings
        ratingTV.textSize=20f
        linearLayout.addView(ratingTV)
    }
}