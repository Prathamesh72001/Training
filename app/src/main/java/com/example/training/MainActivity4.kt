package com.example.training

import android.app.ProgressDialog
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.os.Handler
import android.text.InputType
import android.view.Gravity
import android.view.View
import android.widget.*
import android.widget.AdapterView.OnItemSelectedListener
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView


class MainActivity4 : AppCompatActivity() {
    val genders=arrayOf("Male","Female","Others")
    val qualification=arrayOf("BSc-IT","BSc-CS","BE","BCA")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main4)

        var qual=""
        var gen=""
        var id=""
        var username=""
        var hobbies=""
        var ratings=""

        val linearLayout=findViewById<LinearLayout>(R.id.linear)

        val toolbar = Toolbar(this)
        val layoutParams = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT, 100
        )
        toolbar.layoutParams = layoutParams
        toolbar.popupTheme = R.style.Base_TextAppearance_AppCompat_Widget_PopupMenu_Header
        toolbar.setBackgroundColor(resources.getColor(R.color.grey))
        toolbar.title = "My Toolbar"
        linearLayout.addView(toolbar)

        val idET = EditText(this)
        idET.textSize = 20f
        idET.setHint("Enter ID")
        idET.inputType=InputType.TYPE_CLASS_NUMBER
        idET.setHintTextColor(Color.parseColor("#808080"))
        linearLayout.addView(idET)

        val usernameET = EditText(this)
        usernameET.textSize = 20f
        usernameET.setHint("Enter Username")
        idET.inputType=InputType.TYPE_CLASS_TEXT
        usernameET.setHintTextColor(Color.parseColor("#808080"))
        linearLayout.addView(usernameET)

        val rb= arrayOfNulls<RadioButton>(3)
        val rg = RadioGroup(this)
        rg.orientation = RadioGroup.HORIZONTAL
        for (i in 0..2) {
            rb[i] = RadioButton(this)
            rb[i]!!.text = genders[i]
            rb[i]!!.id = i
            rg.addView(rb[i])
        }
        linearLayout.addView(rg)
        rg.setOnCheckedChangeListener { group, checkedId ->
            var radioBtn:RadioButton=findViewById(checkedId)
            gen+=radioBtn.text.toString()
        }

        val spin=Spinner(this,Spinner.MODE_DROPDOWN)
        spin.setBackgroundResource(android.R.drawable.btn_dropdown)
        val adapter=ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item,qualification)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spin.adapter=adapter
        linearLayout.addView(spin)
        spin.onItemSelectedListener =
            object : OnItemSelectedListener { override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
                qual+=parent.getItemAtPosition(position).toString()
            }

                override fun onNothingSelected(parent: AdapterView<*>?) {

                }
            }

        val checkBox1=CheckBox(this)
        checkBox1.text="Dancing"
        checkBox1.setOnCheckedChangeListener { buttonView, isChecked ->
            if(isChecked){
                hobbies+="Dancing "
            }
        }
        linearLayout.addView(checkBox1)

        val checkBox2=CheckBox(this)
        checkBox2.text="Singing"
        checkBox2.setOnCheckedChangeListener { buttonView, isChecked ->
            if(isChecked){
                hobbies+="Singing "
            }
        }
        linearLayout.addView(checkBox2)

        val checkBox3=CheckBox(this)
        checkBox3.text="Traveling"
        checkBox3.setOnCheckedChangeListener { buttonView, isChecked ->
            if(isChecked){
                hobbies+="Traveling "
            }
        }
        linearLayout.addView(checkBox3)

        val ratingBar=RatingBar(this)
        ratingBar.numStars=5
        linearLayout.addView(ratingBar)
        ratingBar.setOnRatingBarChangeListener { ratingBar, rating, fromUser ->
            ratings+=rating.toString()
        }

        val progressBar=ProgressBar(this@MainActivity4,null,R.attr.circularProgressIndicatorStyle)
        linearLayout.addView(progressBar)


        val btn=Button(this)
        btn.text="Submit"
        linearLayout.addView(btn)
        btn.setOnClickListener {
            val progressDoalog = ProgressDialog(this)
            progressDoalog.setMax(100)
            progressDoalog.setMessage("Its loading....")
            progressDoalog.setTitle("ProgressDialog bar example")
            progressDoalog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL)
            progressDoalog.show()
            val mythread: Thread = object : Thread() {
                override fun run() {
                    try {
                        progressBar.visibility=ProgressBar.VISIBLE
                        sleep(500)
                    } catch (e: Exception) {
                    } finally {
                        id+=idET.text.toString()
                        username+=usernameET.text.toString()

                        val intent= Intent(this@MainActivity4,UserData::class.java)
                        intent.putExtra("ID",id)
                        intent.putExtra("Username",username)
                        intent.putExtra("Gender",gen)
                        intent.putExtra("Qualification",qual)
                        intent.putExtra("Hobbies",hobbies)
                        intent.putExtra("Ratings",ratings)
                        startActivity(intent)
                    }
                }
            }
            mythread.start()

        }


        val bottomNavigationView=BottomNavigationView(this)
        bottomNavigationView.menu.clear()
        bottomNavigationView.inflateMenu(R.menu.main_menu);
        var lp=LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.WRAP_CONTENT)
        lp.gravity=Gravity.BOTTOM
        bottomNavigationView.layoutParams=lp
        linearLayout.addView(bottomNavigationView)


        bottomNavigationView.setOnNavigationItemReselectedListener {
            when(it.itemId){
                R.id.nav_home -> Toast.makeText(this,"Home Selected",Toast.LENGTH_LONG).show()
                R.id.nav_settings -> Toast.makeText(this,"Setting Selected",Toast.LENGTH_LONG).show()
                R.id.nav_login -> Toast.makeText(this,"Login Selected",Toast.LENGTH_LONG).show()
            }
        }



    }
}