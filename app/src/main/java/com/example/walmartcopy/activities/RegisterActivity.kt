package com.example.walmartcopy.activities

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.walmartcopy.MainActivity
import com.example.walmartcopy.R
import com.example.walmartcopy.model.User

class RegisterActivity:AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        var createAcc =findViewById<Button>(R.id.createAcc)
        createAcc.setOnClickListener{
            var fsName=(findViewById(R.id.fNameInp) as TextView)
            var f = fsName.text.toString()
            var lnName=(findViewById(R.id.lNameInp) as TextView)
            var l = lnName.text.toString()
            var emailAdd=(findViewById(R.id.emailAddInp) as TextView)
            var e = emailAdd.text.toString()
            var passWrd=(findViewById(R.id.pwdInp) as TextView)
            var p = passWrd.text.toString()
            println(f+l+e+p)
            val user = User(f,l,e,p)
            var returnData = Intent(this, MainActivity::class.java)
            returnData.putExtra("user", User(f,l,e,p))
            setResult(Activity.RESULT_OK,returnData)
            finish()
        }
    }
}