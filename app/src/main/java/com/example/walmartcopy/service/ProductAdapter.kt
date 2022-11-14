package com.example.walmartcopy.service

import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.walmartcopy.ProdClickListner
//import com.bumptech.glide.Glide.with
import com.example.walmartcopy.R
import com.example.walmartcopy.activities.ProductInfoDetail
import com.example.walmartcopy.model.Product
import com.squareup.picasso.Picasso
import kotlinx.coroutines.NonDisposableHandle.parent
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

class ProductAdapter(val prodList: MutableList<Product> = mutableListOf(),val listner: ProdClickListner)
    :RecyclerView.Adapter<ProductAdapter.ProdViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProdViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.activity_recylceview_row,parent,false)
        return ProdViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProdViewHolder, position: Int) {
        val currProd = prodList[position]
//        holder.title.text = currProd.title
//        holder.price.text = "$ "+currProd.price
//        holder.color.text = currProd.color
//        val url: String= currProd.image
//        Picasso.get()
//            .load(url)
//            .into(holder.img)

        holder.apply {
            bind(prodList[position])
        }
    }

    override fun getItemCount():Int=prodList.size
    
    inner class ProdViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
//        val title: TextView=view.findViewById(R.id.productRecycleTitle)
//        val price: TextView=view.findViewById(R.id.productRecyclePrice)
//        val color: TextView=view.findViewById(R.id.productRecycleColor)
//        val img: ImageView =view.findViewById(R.id.productRecycleImage)
        //        title.text = product.title
//        price.text = "$"+product.price
//        color.text = product.color
//        Glide.with(view.context).load(product.image).into(img)
        fun bind(product: Product) {
            val title: TextView=view.findViewById(R.id.productRecycleTitle)
            val price: TextView=view.findViewById(R.id.productRecyclePrice)
            val color: TextView=view.findViewById(R.id.productRecycleColor)
            val img: ImageView =view.findViewById(R.id.productRecycleImage)

            title.text = product.title
            price.text = "$" + product.price
            color.text = product.color
            Glide.with(view.context).load(product.image).override(100,100).into(img)

            view.setOnClickListener{
                listner.onProductItemClicked(product)
            }
        }
    }
}