package com.example.training

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ListAdapter
import android.widget.ListView
import android.widget.SimpleAdapter
import androidx.recyclerview.widget.RecyclerView
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject
import java.io.InputStream
import java.lang.Exception

class MainActivity12 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main12)

        try {


            val userList = ArrayList<StudentHelperClass>()

            val recyclerView = findViewById<RecyclerView>(R.id.recycler)

            val jObj = JSONObject(loadJSONFromAsset())
            val jsonArry = jObj.getJSONArray("Students")
            for (i in 0 until jsonArry.length()) {
                val obj = jsonArry.getJSONObject(i)
                val s=StudentHelperClass(obj)
                userList.add(s)
            }

            val adapter=StudentAdapter(userList)
            recyclerView.adapter = adapter
        } catch (ex: JSONException) {
            Log.e("JsonParser Example", "unexpected JSON exception", ex)
        }
    }

    private fun loadJSONFromAsset(): String {
        var jsonStr:String?=null
        try{
            val IS:InputStream=assets.open("student.json")
            val size:Int=IS.available()
            val buffer=ByteArray(size)
            IS.read(buffer)
            IS.close()
            jsonStr=String(buffer)
        }catch(e:Exception){

        }
        return jsonStr!!
    }


}