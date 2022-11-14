package com.example.walmartcopy.activities

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.walmartcopy.R
import com.example.walmartcopy.model.Product
import com.google.gson.Gson
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

class ProductInfoDetail:AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_information)

        val product: Product = Gson().fromJson(
            intent.getStringExtra("product"),
            Product::class.java)

        val img: ImageView = findViewById(R.id.productImage)
        val title: TextView = findViewById(R.id.productTitle)
        val color: TextView = findViewById(R.id.productColor)
        val itemId: TextView = findViewById(R.id.productId)
        val desc: TextView = findViewById(R.id.productDescription)

        Glide.with(this).load(product.image).into(img)
        title.text = product.title
        color.text = "Color: " + product.color
        itemId.text = "Item Id: " + product.itemId
        desc.text = product.descrip
    }
}