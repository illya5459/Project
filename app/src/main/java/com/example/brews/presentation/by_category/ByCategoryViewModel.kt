package com.example.brews.presentation.by_category

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.brews.data.Repository
import com.example.brews.data.model.cocktail.by_category.CocktailsByCategory
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ByCategoryViewModel : ViewModel() {

    private val repository = Repository()
    val cocktailsByCategoryLiveData = MutableLiveData<CocktailsByCategory?>()

    fun getCocktailsByCategory(categoryName: String) {
        viewModelScope.launch(Dispatchers.IO) {
            cocktailsByCategoryLiveData.postValue(repository.searchCocktailsByCategory(categoryName))
        }
    }

}