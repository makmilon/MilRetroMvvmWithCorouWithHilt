package com.milon.retromvvmwithcorouwithhilt.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.milon.retromvvmwithcorouwithhilt.models.Product
import com.milon.retromvvmwithcorouwithhilt.repository.ProductRepository
import kotlinx.coroutines.launch

class MainViewModel(private val repository: ProductRepository): ViewModel() {

    val productLiveData: LiveData<List<Product>>
    get() = repository.product

    init {
        viewModelScope.launch {
            repository.getProduct()
        }
    }

}