package com.example.training

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager

class MainActivity6 : AppCompatActivity() {
    lateinit var viewPager:ViewPager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main6)

        viewPager=findViewById<ViewPager>(R.id.viewPager)
        viewPager.adapter=Adapter4(supportFragmentManager)
    }

    override fun onBackPressed() {
        if(viewPager.currentItem==0) {
            super.onBackPressed()
        }
        else{
            viewPager.setCurrentItem(viewPager.currentItem-1)
        }
    }
}