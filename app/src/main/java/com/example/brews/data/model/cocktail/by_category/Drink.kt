package com.example.brews.data.model.cocktail.by_category


import com.google.gson.annotations.SerializedName

data class Drink(
    @SerializedName("idDrink")
    val idDrink: String?,
    @SerializedName("strDrink")
    val strDrink: String?,
    @SerializedName("strDrinkThumb")
    val strDrinkThumb: String?
)