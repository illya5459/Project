package com.example.brews.presentation.categories

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.brews.data.Repository
import com.example.brews.data.model.categories.Categories
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CategoriesViewModel : ViewModel() {

    private val repository = Repository()
    val categoriesLiveData = MutableLiveData<Categories?>()

    init {
        getCategories()
    }

    fun getCategories() {
        viewModelScope.launch(Dispatchers.IO) {
            val categories = repository.searchCategories()
            categoriesLiveData.postValue(categories)
        }
    }

}