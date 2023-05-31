package com.example.brews.data.cloud

import com.example.brews.data.model.categories.Categories
import com.example.brews.data.model.cocktail.by_category.CocktailsByCategory
import com.example.brews.data.model.cocktail.full.FullCocktail
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface CocktailApi {

    @Headers("Content-Type: application/json")
    @GET("random.php")
    suspend fun randomCocktail(): FullCocktail

    @Headers("Content-Type: application/json")
    @GET("list.php")
    suspend fun searchCategories(@Query("c") list: String = "list"): Categories

    @Headers("Content-Type: application/json")
    @GET("filter.php")
    suspend fun searchCocktailsByCategory(@Query("c") categoryName: String): CocktailsByCategory

    @Headers("Content-Type: application/json")
    @GET("lookup.php")
    suspend fun getCocktailById(@Query("i") id: Int): FullCocktail

}