package com.milon.retromvvmwithcorouwithhilt.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.milon.retromvvmwithcorouwithhilt.models.Product
import com.milon.retromvvmwithcorouwithhilt.retrofit.FakerApi
import javax.inject.Inject

class ProductRepository @Inject constructor(private val fakerApi: FakerApi) {

    private val _products= MutableLiveData<List<Product>>()
    val product: LiveData<List<Product>>
    get() = _products

    suspend fun getProduct(){
        val result= fakerApi.getProduct()
        if (result.isSuccessful && result.body()!=null){
            _products.postValue(result.body())
        }
    }

}