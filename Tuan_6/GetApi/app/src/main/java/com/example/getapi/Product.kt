package com.example.getapi

import com.google.gson.annotations.SerializedName

data class Product(
    val id: String,
    val name: String,
    val price: Double,
    @SerializedName("des")
    val description: String,
    @SerializedName("imgURL")
    val imageUrl: String
)
