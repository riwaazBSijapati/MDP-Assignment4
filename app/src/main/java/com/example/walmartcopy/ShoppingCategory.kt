package com.example.walmartcopy

import android.os.Bundle
import android.os.PersistableBundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class ShoppingCategory: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shopping_category)

        val userStr = intent.getStringExtra("email").toString()
        val welcomeTxt = findViewById(R.id.welcomeUser) as TextView
        welcomeTxt.text = "Welcome: $userStr"

        (findViewById(R.id.clothingView) as ImageView).setOnClickListener{
            showToast("Clothing")
        }
        (findViewById(R.id.groceryView) as ImageView).setOnClickListener{
            showToast("Grocery")
        }
        (findViewById(R.id.electronicsView) as ImageView).setOnClickListener{
            showToast("Electronics")
        }
        (findViewById(R.id.beautyView) as ImageView).setOnClickListener{
            showToast("Beauty")
        }
    }

    private fun showToast(s: String) {
        Toast.makeText(
            this,
            "You have chosen the $s category of shoppint",
            Toast.LENGTH_SHORT
        ).show()
    }
}