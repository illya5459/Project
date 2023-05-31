package com.example.brews.presentation.cocktail

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.brews.data.Repository
import com.example.brews.data.model.cocktail.full.FullCocktail
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CocktailViewModel : ViewModel() {

    private val repository = Repository()
    val cocktailLiveData = MutableLiveData<FullCocktail?>()

    fun getFullCocktail(id: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            if (id == -1) {
                cocktailLiveData.postValue(repository.randomCocktail())
            } else {
                cocktailLiveData.postValue(repository.getCocktailById(id))
            }
        }
    }

}