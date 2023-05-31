package com.example.brews.data.model.cocktail.by_category


import com.google.gson.annotations.SerializedName

data class CocktailsByCategory(
    @SerializedName("drinks")
    val drinks: List<Drink?>?
)