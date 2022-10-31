package com.example.walmartcopy

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity

//import com.example.walmartcopy.databinding.ActivityMainBinding

class MainActivity:AppCompatActivity() {
    private val usersList = ArrayList<User>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_main)

        //Initialize list of users
        usersList.add(User("Todd","Chavez","chavezTodd@hotmail.com","AaronPaul"))
        usersList.add(User("Amy","Wong","awong@marslink.web","LaurenTom"))
        usersList.add(User("Andrew","Glouberman","glouberJazzHat@hotmail.com","JohnMulaney"))
        usersList.add(User("Tiabeani","Grunkwitz","queenBean@hotmail.com","Abbi Jacobson"))
        val signIn = findViewById(R.id.createAcc) as Button
            val emailAdd = (findViewById(R.id.emailAddInp) as TextView).toString()
            val passWord = (findViewById(R.id.pwdInp) as TextView).toString()

        signIn.setOnClickListener{


            if(emailAdd.isEmpty()||passWord.isEmpty()) Toast.makeText(
                this,
                "Please Enter Valid Value",
                Toast.LENGTH_SHORT
            )else{
                val comprUsr=User("","",emailAdd,passWord)
                for (usr in usersList){
                    if(usr == comprUsr){
                        startActivity(
                            Intent(
                            this,
                            ShoppingCategory::class.java
                        ).apply{
                            putExtra("email",emailAdd)
                        })
                    }
                }
            }
        }
        val newAcc = findViewById(R.id.newAccount) as Button
        newAcc.setOnClickListener{
            lancher.launch(Intent(this,RegisterActivity::class.java))
        }

        val forgetPwd = findViewById(R.id.forgetPwd) as TextView
        forgetPwd.setOnClickListener {
// needs implientations
        }

    }
    private var lancher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
                result->
            val data: User = result.data?.extras?.get("user") as User
            usersList.add(data)
        }
}