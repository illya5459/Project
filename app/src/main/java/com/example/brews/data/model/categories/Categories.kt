package com.example.brews.data.model.categories


import com.google.gson.annotations.SerializedName

data class Categories(
    @SerializedName("drinks")
    val drinks: List<Drink?>?
)