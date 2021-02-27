package com.example.aplika.Servicee.ApiService

import com.example.aplika.Data.model.Banner
import com.example.aplika.Data.model.Product
import com.google.gson.JsonObject
import io.reactivex.Completable
import io.reactivex.Single
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {
    @GET("product/list")
    fun getProduct():Single<List<Product>>

    @GET("banner/slider")
    fun getBannerList():Single<List<Banner>>
}
fun createApiServiceInstance():ApiService{
    val retrofit= Retrofit.Builder()
        .baseUrl("http://expertdevelopers.ir/api/v1/")
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build()

    return  retrofit.create(ApiService::class.java)
}