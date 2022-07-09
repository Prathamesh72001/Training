package com.example.training

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class Fragment_All : Fragment() {
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

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view=inflater.inflate(R.layout.fragment__all, container, false)

        val recycler=view.findViewById<RecyclerView>(R.id.recycler)
        recycler.layoutManager=GridLayoutManager(context,2)
        val data=ArrayList<BookHelperClass>()
        data.add(BookHelperClass("1984","By G. Owell",R.drawable.book1,false))
        data.add(BookHelperClass("The Diary of","By A. Frank",R.drawable.book2,false))
        data.add(BookHelperClass("Harry Potter Vol 1","By J. K. Rowling",R.drawable.harrypotter,false))
        data.add(BookHelperClass("The Hobbit","By J. R. R. Tolkien",R.drawable.hobbit,false))
        data.add(BookHelperClass("Little Woman","By L. M. Alcott",R.drawable.littlewoman,false))
        data.add(BookHelperClass("Lord Of The Rings","By J. R. R. Tolkien",R.drawable.lordoftherings,false))
        data.add(BookHelperClass("The Great Gatsby","By S. Fitzgerald",R.drawable.penguin,false))
        data.add(BookHelperClass("Pride \u0026 Prejudice","By J. Austen",R.drawable.pride_and_prejudice,false))
        data.add(BookHelperClass("The Book Thief","By M. Zusak",R.drawable.thebookthief,false))
        data.add(BookHelperClass("To Kill Mocking Bird","By H. Lee",R.drawable.tokillmockingbird,false))

        recycler.adapter=Books_Adapter(data)

        return view
    }

    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Fragment_All().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}