package com.example.brews.data

import com.example.brews.data.cloud.RetrofitInstance
import com.example.brews.data.model.categories.Categories
import com.example.brews.data.model.cocktail.by_category.CocktailsByCategory
import com.example.brews.data.model.cocktail.full.FullCocktail
import java.lang.Exception

class Repository {

    private val cocktailApi = RetrofitInstance.cocktailApi

    suspend fun randomCocktail(): FullCocktail? {
        return try {
            cocktailApi.randomCocktail()
        } catch (e: Exception) {
            e
            null
        }
    }

    suspend fun searchCategories(): Categories? {
        return try {
            cocktailApi.searchCategories()
        } catch (e: Exception) {
            e
            null
        }
    }

    suspend fun searchCocktailsByCategory(categoryName: String): CocktailsByCategory? {
        return try {
            cocktailApi.searchCocktailsByCategory(categoryName)
        } catch (e: Exception) {
            e
            null
        }
    }

    suspend fun getCocktailById(id: Int): FullCocktail? {
        return try {
            cocktailApi.getCocktailById(id)
        } catch (e: Exception) {
            e
            null
        }
    }

}