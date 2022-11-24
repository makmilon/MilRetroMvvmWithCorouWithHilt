package com.milon.retromvvmwithcorouwithhilt.retrofit

import com.milon.retromvvmwithcorouwithhilt.models.Product
import retrofit2.Response
import retrofit2.http.GET

interface FakerApi {

    @GET("products")
    suspend fun getProduct(): Response<List<Product>>

}