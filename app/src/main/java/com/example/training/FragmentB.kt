package com.example.training

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.navigation.Navigation


private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class FragmentB : Fragment() {
    private var param1: String? = null
    private var param2: String? = null

    override fun onAttach(context: Context) {
        Toast.makeText(context, "Fragment B onAttach()", Toast.LENGTH_LONG).show()
        Log.d("tag", "Fragment B onAttach()")
        super.onAttach(context)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
        Toast.makeText(context, "Fragment B onCreate()", Toast.LENGTH_LONG).show()
        Log.d("tag", "Fragment B onCreate()")
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view:View=inflater.inflate(R.layout.fragment_b, container, false)

        Toast.makeText(context, "Fragment B onCreateView()", Toast.LENGTH_LONG).show()
        Log.d("tag", "Fragment B onCreateView()")

        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        Toast.makeText(context, "Fragment B onActivityCreate()", Toast.LENGTH_LONG).show()
        Log.d("tag", "Fragment B onActivityCreate()")
        super.onActivityCreated(savedInstanceState)
    }

    override fun onStart() {
        Toast.makeText(context, "Fragment B onStart()", Toast.LENGTH_LONG).show()
        Log.d("tag", "Fragment B onStart()")
        super.onStart()
    }

    override fun onResume() {
        Toast.makeText(context, "Fragment B onResume()", Toast.LENGTH_LONG).show()
        Log.d("tag", "Fragment B onResume()")
        super.onResume()
    }

    override fun onPause() {
        Toast.makeText(context, "Fragment B onPause()", Toast.LENGTH_LONG).show()
        Log.d("tag", "Fragment B onPause()")
        super.onPause()
    }

    override fun onStop() {
        Toast.makeText(context, "Fragment B onStop()", Toast.LENGTH_LONG).show()
        Log.d("tag", "Fragment B onStop()")
        super.onStop()
    }

    override fun onDestroyView() {
        Toast.makeText(context, "Fragment B onDestroyView()", Toast.LENGTH_LONG).show()
        Log.d("tag", "Fragment B onDestroyView()")
        super.onDestroyView()
    }

    override fun onDestroy() {
        Toast.makeText(context, "Fragment B onDestroy()", Toast.LENGTH_LONG).show()
        Log.d("tag", "Fragment B onDestroy()")
        super.onDestroy()
    }

    override fun onDetach() {
        Toast.makeText(context, "Fragment B onDetach()", Toast.LENGTH_LONG).show()
        Log.d("tag", "Fragment B onDetach()")
        super.onDetach()
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            FragmentB().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}