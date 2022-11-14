package com.example.walmartcopy

import com.example.walmartcopy.model.Product

interface ProdClickListner {
    fun onProductItemClicked(prod: Product)
}