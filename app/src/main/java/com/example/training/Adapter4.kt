package com.example.training

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter

class Adapter4(f:FragmentManager) : FragmentStatePagerAdapter(f) {
    override fun getCount(): Int {
        return 2
    }

    override fun getItem(position: Int): Fragment {
        if(position==0){
            return FragmentA()
        }
        else{
            return FragmentB()
        }

    }
}