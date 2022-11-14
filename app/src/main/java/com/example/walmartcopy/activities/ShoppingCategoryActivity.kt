package com.example.walmartcopy.activities

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.walmartcopy.R
import com.example.walmartcopy.model.Product
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

class ShoppingCategoryActivity: AppCompatActivity() {
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
            val itemList=ArrayList<Product>()
            itemList.add(Product(
                "Stealth GS66 15.6",
                2499.99,
                "Black",
                "https://pisces.bbystatic.com/image2/BestBuy_US/images/products/6494/6494335_sd.jpg",
                "6494335",
                "Edge ahead of the pack with this MSI Stealth GS66 gaming laptop."
            ))
            itemList.add(Product(
                "Odyssey 49” 1000R",
                1199.99,
                "Black",
                "https://pisces.bbystatic.com/image2/BestBuy_US/images/products/6425/6425569_sd.jpg",
                "6425569",
                "At 49”, and arced to match the curvature of the human eye"
            ))
            itemList.add(Product(
                "Victrola - Empire Bluetooth 6-in-1 Record Player",
                219.99,
                "Gold/Brown/Black",
                "https://pisces.bbystatic.com/image2/BestBuy_US/images/products/6280/6280547_rd.jpg",
                "6280547",
                "The Victrola Empire Signature 6-in-1 Bluetooth Record Player."
            ))
            itemList.add(Product(
                "Samsung - Galaxy Watch4",
                169.99,
                "Black",
                "https://pisces.bbystatic.com/image2/BestBuy_US/images/products/6464/6464594_sd.jpg",
                "6494335",
                "Crush workouts and all your health goals with Samsung Galaxy Watch4."
            ))
            var testList = Json.encodeToString(itemList)
            println(testList)
            switchToProductListActivity(itemList)
        }
        (findViewById(R.id.beautyView) as ImageView).setOnClickListener{
            showToast("Beauty")
        }
    }
    private fun switchToProductListActivity(prodList:ArrayList<Product>){
        val intent=Intent(this, ItemListActivity::class.java)
        intent.putExtra("productList", Json.encodeToString(prodList))
        startActivity(intent)
    }
    private fun showToast(s: String) {
        Toast.makeText(
            this,
            "You have chosen the $s category of shoppint",
            Toast.LENGTH_SHORT
        ).show()
    }
}