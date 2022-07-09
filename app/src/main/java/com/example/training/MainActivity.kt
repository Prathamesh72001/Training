package com.example.training

import android.content.Intent
import android.content.IntentSender
import android.content.pm.PackageManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import java.util.jar.Manifest

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //hooks
        val sms=findViewById<Button>(R.id.SMS)
        val call=findViewById<Button>(R.id.Call)
        val email=findViewById<Button>(R.id.Email)
        //listeners
        sms.setOnClickListener {
            val intent= Intent(Intent.ACTION_VIEW, Uri.fromParts("sms","9594903747",null))
            intent.putExtra("sms_body","Good Evening")
            startActivity(intent)
        }

        call.setOnClickListener {
            makePhoneCall()
        }


        email.setOnClickListener {
            val intent= Intent(Intent.ACTION_SENDTO)
            val to=arrayOf<String>("shivanisawardekar@gmail.com")
            intent.setData(Uri.parse("mailto:"))
            intent.putExtra(Intent.EXTRA_EMAIL,to)
            intent.putExtra(Intent.EXTRA_SUBJECT,"Email Subject")
            intent.putExtra(Intent.EXTRA_TEXT,"Email Body")
            startActivity(intent)
        }


    }


    private fun makePhoneCall() {
        val intent= Intent(Intent.ACTION_CALL)
        if(ContextCompat.checkSelfPermission(this,android.Manifest.permission.CALL_PHONE)==PackageManager.PERMISSION_GRANTED) {
            intent.setData(Uri.parse("tel:8108655480"))
            startActivity(intent)
        }
        else{
            val permission=arrayOf<String>(android.Manifest.permission.CALL_PHONE)
            ActivityCompat.requestPermissions(this,permission,1)
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if(requestCode==1){
            if(grantResults.isNotEmpty() && grantResults[0]==PackageManager.PERMISSION_GRANTED){
                makePhoneCall()
            }
            else{
                Toast.makeText(this,"Permission Denied",Toast.LENGTH_LONG).show();
            }
        }
    }


}