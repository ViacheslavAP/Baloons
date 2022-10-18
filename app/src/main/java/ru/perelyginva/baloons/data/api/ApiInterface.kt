package ru.perelyginva.baloons.data.api

import retrofit2.Call
import retrofit2.http.GET
import ru.perelyginva.baloons.data.models.ProductsApiModel

interface ApiInterface {

    @GET("getProducts.php")
    fun getProduct(): Call<ArrayList<ProductsApiModel>>
}
