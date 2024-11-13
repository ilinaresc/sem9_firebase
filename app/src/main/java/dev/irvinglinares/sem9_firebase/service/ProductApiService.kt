package dev.irvinglinares.sem9_firebase.service

import dev.irvinglinares.sem9_firebase.model.ProductApiModel
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ProductApiService {

    @GET("products")
    fun getProducts(): Call<List<ProductApiModel>>

    @POST("products")
    fun createProduct(@Body product: ProductApiModel): Call<ProductApiModel>

}