package com.example.walmartcopy

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class RegisterActivity:AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        (findViewById(R.id.createAcc) as Button).setOnClickListener{
            val fsName=(findViewById(R.id.fNameInp) as TextView).toString()
            val lnName=(findViewById(R.id.lNameInp) as TextView).toString()
            val emailAdd=(findViewById(R.id.emailAddInp) as TextView).toString()
            val passWrd=(findViewById(R.id.pwdInp) as TextView).toString()

            val returnData = Intent()
            returnData.putExtra("user",User(fsName,lnName,emailAdd,passWrd))
            finish()
        }
    }
}