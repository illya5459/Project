package com.example.brews.data.model.categories


import com.google.gson.annotations.SerializedName

data class Drink(
    @SerializedName("strCategory")
    val strCategory: String?
)