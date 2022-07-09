package com.example.training

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.GridView
import android.widget.TextView

class MainActivity2() : AppCompatActivity() {
    val s=arrayOf("1","2","3","+","4","5","6","-","7","8","9","x","AC","0","/","=")
    var isactiontaken:Boolean=false
    var isplus:Boolean=false
    var isminus:Boolean=false
    var isdiv:Boolean=false
    var ismul:Boolean=false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        val gridView=findViewById<GridView>(R.id.grid)
        val textView=findViewById<TextView>(R.id.textView)
        var n=""
        var m=""
        gridView.adapter=Adapter(this,s)
        gridView.onItemClickListener= AdapterView.OnItemClickListener { parent, view, position, id ->
            if(s[position] == "AC"){
              textView.text=""
                isactiontaken=false
                isplus=false
                isminus=false
                isdiv=false
                ismul=false
            }
            else if(s[position]=="="){
                if(isplus){
                    var sum=n.toInt()+m.toInt()
                    textView.text=sum.toString()
                }
                if(isminus){
                    var sub=n.toInt()-m.toInt()
                    textView.text=sub.toString()
                }
                if(ismul){
                    var mul=n.toInt()*m.toInt()
                    textView.text=mul.toString()
                }
                if(isdiv){
                    var div=n.toInt()/m.toInt()
                    textView.text=div.toString()
                }
            }
            else if(s[position]=="+"){
                isplus=true
                textView.text=""
                isactiontaken=true
            }
            else if(s[position]=="-"){
                isminus=true
                textView.text=""
                isactiontaken=true
            }
            else if(s[position]=="x"){
                ismul=true
                textView.text=""
                isactiontaken=true
            }
            else if(s[position]=="/"){
                isdiv=true
                textView.text=""
                isactiontaken=true
            }
            else{
                if(isactiontaken){
                    m=textView.text.toString()+s[position]
                    textView.text=m
                }
                else {
                    n = textView.text.toString() + s[position]
                    textView.text = n
                }
            }
        }
    }
}