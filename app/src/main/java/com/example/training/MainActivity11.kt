package com.example.training

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout

class MainActivity11 : AppCompatActivity() {
    private lateinit var viewPager: ViewPager
    private lateinit var tabLayout: TabLayout
    private lateinit var viewPagerAdapter: ViewPagerAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main11)
        val toolbar=findViewById<androidx.appcompat.widget.Toolbar>(R.id.toolbar)
        toolbar.setTitleTextColor(ContextCompat.getColor(this,R.color.white))

        viewPager=findViewById(R.id.viewPager)
        viewPagerAdapter = ViewPagerAdapter(supportFragmentManager)
        viewPager.adapter = viewPagerAdapter

        tabLayout=findViewById(R.id.tabLayout)
        tabLayout.setupWithViewPager(viewPager)
        tabLayout.getTabAt(0)!!.setText("Favourites")
        tabLayout.getTabAt(1)!!.setText("Notes")

        viewPager.currentItem=1
        tabLayout.setScrollPosition(1,0f,true)
        tabLayout.addOnTabSelectedListener(object:TabLayout.OnTabSelectedListener{
            override fun onTabSelected(tab: TabLayout.Tab?) {
                viewPager.currentItem=tab!!.position
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {

            }

            override fun onTabReselected(tab: TabLayout.Tab?) {

            }

        })

        viewPager.addOnPageChangeListener(object :ViewPager.OnPageChangeListener{
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {

            }

            override fun onPageSelected(position: Int) {
               viewPager.currentItem=position
                tabLayout.setScrollPosition(position,0f,true)
            }

            override fun onPageScrollStateChanged(state: Int) {

            }

        })

        viewPager.setOffscreenPageLimit(2)
    }



    override fun onBackPressed() {
        if(viewPager.currentItem==1) {
            super.onBackPressed()
        }
        else{
            viewPager.setCurrentItem(1)
        }
    }

    inner class ViewPagerAdapter(fragmentManager: FragmentManager) : FragmentStatePagerAdapter(fragmentManager) {

        override fun getCount(): Int {
            return 2
        }

        override fun getItem(position: Int): Fragment {
            if(position==0){
                return FavouriteFrag()
            }
            else{
                return NotesFrag()
            }
        }
    }
}