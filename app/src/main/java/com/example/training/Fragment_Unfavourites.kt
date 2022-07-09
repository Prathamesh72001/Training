package com.example.training

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView


private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class Fragment_Unfavourites : Fragment(), listCallBack {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        if(Companion.view1 ==null) {
            Companion.view1 = inflater.inflate(R.layout.fragment__unfavourites, container, false)

            Companion.recycler = Companion.view1!!.findViewById(R.id.recycler)
            Companion.recycler!!.layoutManager = GridLayoutManager(context, 2)
        }

        return Companion.view1
    }


    override fun refresh(obj: BookHelperClass) {
        if (obj.isFav) {
            try {
                Companion.unfav_List.remove(obj)
                Companion.recycler!!.adapter = Books_Adapter2(Companion.unfav_List)
                Companion.recycler!!.adapter!!.notifyDataSetChanged()
            } catch (e: Exception) {
                Companion.recycler = Companion.view1!!.findViewById(R.id.recycler)
                Companion.unfav_List.remove(obj)
                Companion.recycler!!.adapter = Books_Adapter2(Companion.unfav_List)
                Companion.recycler!!.adapter!!.notifyDataSetChanged()
            }
        } else {

            try {
                Companion.unfav_List.add(obj)
                Companion.recycler!!.adapter = Books_Adapter2(Companion.unfav_List)
                Companion.recycler!!.adapter!!.notifyDataSetChanged()
            } catch (e: Exception) {
                Companion.recycler = Companion.view1!!.findViewById(R.id.recycler)
                Companion.unfav_List.add(obj)
                Companion.recycler!!.adapter = Books_Adapter2(Companion.unfav_List)
                Companion.recycler!!.adapter?.notifyDataSetChanged()
            }
        }
    }

    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Fragment_Unfavourites().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }

        var view1:View?=null
        var recycler: RecyclerView?=null
        val unfav_List = ArrayList<BookHelperClass>()
    }


}