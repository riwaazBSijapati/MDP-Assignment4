package com.example.walmartcopy.model

import kotlinx.serialization.Serializable

@Serializable
data class Product (
    val title: String,
    val price: Double,
    val color: String,
    val image: String,
    val itemId: String,
    val descrip: String
)