package com.example.walmartcopy

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.example.walmartcopy.activities.RegisterActivity
import com.example.walmartcopy.activities.ShoppingCategoryActivity
import com.example.walmartcopy.databinding.ActivityMainBinding
import com.example.walmartcopy.model.User

//import com.example.walmartcopy.databinding.ActivityMainBinding

class MainActivity:AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private val usersList = ArrayList<User>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        binding = ActivityMainBinding.inflate(layoutInflater)

        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_main)

        //Initialize list of users
        usersList.add(User("Todd","Chavez","chavezTodd@hotmail.com","AaronPaul"))
        usersList.add(User("Amy","Wong","awong@marslink.web","LaurenTom"))
        usersList.add(User("Andrew","Glouberman","glouberJazzHat@hotmail.com","JohnMulaney"))
        usersList.add(User("Tiabeani","Grunkwitz","queenBean@hotmail.com","Abbi Jacobson"))
        usersList.add(User("R","S","r@b.s","rbs"))
        usersList.add(User("a","s","d","f"))
        val signIn = findViewById(R.id.createAcc) as Button;

        signIn.setOnClickListener{
            var email: TextView = findViewById<TextView>(R.id.emailAddInp);
            var emailStr = (email.text).toString();
            var pass: TextView= findViewById<TextView>(R.id.pwdInp);
            var passStr = pass.text.toString();
            println(emailStr+" "+passStr)
            if(emailStr.isEmpty()||passStr.isEmpty())
                Toast.makeText(
                this,
                "Please Enter Valid Value",
                Toast.LENGTH_SHORT)
            else{
                val comprUsr= User("","",emailStr,passStr)
                for (usr in usersList){
                    if(usr.equals(comprUsr)){
                        println("Ahhhhh")
                        startActivity(
                            Intent(
                            this,
                            ShoppingCategoryActivity::class.java
                        ).apply{
                            putExtra("email",emailStr)
                        })
                    }
                }
            }
        }
        val newAcc = findViewById(R.id.newAccount) as Button
        newAcc.setOnClickListener{
            var intention = Intent(this, RegisterActivity::class.java)
            lancher.launch(intention)
        }

        val forgetPwd = findViewById(R.id.forgetPwd) as TextView
        forgetPwd.setOnClickListener {
// needs implientations
        }

    }
    var lancher =registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
                result->
        if(result.resultCode== Activity.RESULT_OK){
            val user = result.data!!.getSerializableExtra("user")as User
            if(user!=null){
                usersList.add(user)
            }else{
                println("OH NOOO")
            }
        }
    }
}