package com.example.brews.data.model.cocktail.full


import com.google.gson.annotations.SerializedName

data class FullCocktail(
    @SerializedName("drinks")
    val drinks: List<Drink?>?
)