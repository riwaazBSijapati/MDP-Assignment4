package com.example.walmartcopy.activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.walmartcopy.ProdClickListner
import com.example.walmartcopy.R
import com.example.walmartcopy.databinding.ActivityItemViewsBinding
import com.example.walmartcopy.model.Product
import com.example.walmartcopy.service.ProductAdapter
import com.google.gson.Gson
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.decodeFromJsonElement
import java.lang.reflect.Type


class ItemListActivity:AppCompatActivity(),ProdClickListner {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item_views)

        val productList: ArrayList<Product> =
            Json.decodeFromString((intent
                .getStringExtra("productList")
                .toString()))
        for (prod in productList){
            println(prod)
        }
        println("-------------")
        println(productList.size)
        val recycleItem: RecyclerView = findViewById(R.id.itemRecyclerView)
        recycleItem.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        val adapter=ProductAdapter(productList,this)
        recycleItem.adapter=adapter
    }

    override fun onProductItemClicked(prod: Product) {
        println(prod.toString())
        val intent = Intent(this, ProductInfoDetail::class.java)
        var extra = prod.toString().substringAfter("Product(")
        intent.putExtra("product", Gson().toJson(prod))
        startActivity(intent)
    }
}

