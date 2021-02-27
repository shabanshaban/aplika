package com.example.aplika.Data.Datasource

import com.example.aplika.Data.model.Product
import com.example.aplika.Servicee.ApiService.ApiService
import io.reactivex.Single

class ProductRemoteDataSource(val apiService: ApiService) : ProductDataSource {
    override fun getProducts(): Single<List<Product>>  =apiService.getProduct()

}