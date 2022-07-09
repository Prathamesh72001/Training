package com.example.training

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class FragmentA : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onAttach(context: Context) {
        Toast.makeText(context, "Fragment A onAttach()", Toast.LENGTH_LONG).show()
        Log.d("tag", "Fragment A onAttach()")
        super.onAttach(context)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
        Toast.makeText(context, "Fragment A onCreate()", Toast.LENGTH_LONG).show()
        Log.d("tag", "Fragment A onCreate()")
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view:View=inflater.inflate(R.layout.fragment_a, container, false)

        Toast.makeText(context, "Fragment A onCreateView()", Toast.LENGTH_LONG).show()
        Log.d("tag", "Fragment A onCreateView()")


        return view
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            FragmentA().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        Toast.makeText(context, "Fragment A onActivityCreate()", Toast.LENGTH_LONG).show()
        Log.d("tag", "Fragment A onActivityCreate()")
        super.onActivityCreated(savedInstanceState)
    }

    override fun onStart() {
        Toast.makeText(context, "Fragment A onStart()", Toast.LENGTH_LONG).show()
        Log.d("tag", "Fragment A onStart()")
        super.onStart()
    }

    override fun onResume() {
        Toast.makeText(context, "Fragment A onResume()", Toast.LENGTH_LONG).show()
        Log.d("tag", "Fragment A onResume()")
        super.onResume()
    }

    override fun onPause() {
        Toast.makeText(context, "Fragment A onPause()", Toast.LENGTH_LONG).show()
        Log.d("tag", "Fragment A onPause()")
        super.onPause()
    }

    override fun onStop() {
        Toast.makeText(context, "Fragment A onStop()", Toast.LENGTH_LONG).show()
        Log.d("tag", "Fragment A onStop()")
        super.onStop()
    }

    override fun onDestroyView() {
        Toast.makeText(context, "Fragment A onDestroyView()", Toast.LENGTH_LONG).show()
        Log.d("tag", "Fragment A onDestroyView()")
        super.onDestroyView()
    }

    override fun onDestroy() {
        Toast.makeText(context, "Fragment A onDestroy()", Toast.LENGTH_LONG).show()
        Log.d("tag", "Fragment A onDestroy()")
        super.onDestroy()
    }

    override fun onDetach() {
        Toast.makeText(context, "Fragment A onDetach()", Toast.LENGTH_LONG).show()
        Log.d("tag", "Fragment A onDetach()")
        super.onDetach()
    }
}