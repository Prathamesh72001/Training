package com.example.training

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.lifecycle.Lifecycle
import androidx.viewpager.widget.ViewPager
import androidx.viewpager.widget.ViewPager.OnPageChangeListener
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity8 : AppCompatActivity() {
    private lateinit var viewPager: ViewPager
    private lateinit var viewPagerAdapter: ViewPagerAdapter
    lateinit var prevMenuItem:MenuItem
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main8)

        viewPager=findViewById<ViewPager>(R.id.viewPager)

        viewPager.offscreenPageLimit = 3
        viewPagerAdapter = ViewPagerAdapter(supportFragmentManager)
        viewPager.adapter = viewPagerAdapter



        val bottomNavigationView=findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        prevMenuItem = bottomNavigationView.menu.getItem(0)
        bottomNavigationView.setOnNavigationItemReselectedListener {
            when(it.itemId){
                R.id.nav_home -> {
                   viewPager.currentItem=0
                }
                R.id.nav_fav -> {
                    viewPager.currentItem=1
                }
                R.id.nav_unfav -> {
                    viewPager.currentItem=2
                }
            }
        }

        viewPager.addOnPageChangeListener(object : OnPageChangeListener {
            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
            }

            override fun onPageSelected(position: Int) {
                if (prevMenuItem != null) {
                    prevMenuItem.setChecked(false)
                } else {
                    bottomNavigationView.menu.getItem(0).isChecked = false
                }
                bottomNavigationView.menu.getItem(position).isChecked = true
                prevMenuItem = bottomNavigationView.menu.getItem(position)

            }

            override fun onPageScrollStateChanged(state: Int) {

            }


        })



    }



    override fun onBackPressed() {
        if(viewPager.currentItem==0){
            super.onBackPressed()
        }
        else{
            viewPager.currentItem=viewPager.currentItem-1
        }

    }

    inner class ViewPagerAdapter(fragmentManager: FragmentManager) : FragmentStatePagerAdapter(fragmentManager) {

        override fun getCount(): Int {
            return 3
        }

        override fun getItem(position: Int): Fragment {
            if(position==0){
                return Fragment_All()
            }
            else if(position==1){
                return Fragment_Favourites()
            }
            else{
                return Fragment_Unfavourites()
            }
        }
    }

}