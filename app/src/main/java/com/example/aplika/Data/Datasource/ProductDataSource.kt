package com.example.aplika.Data.Datasource

import com.example.aplika.Data.model.Product
import io.reactivex.Single

interface ProductDataSource {

    fun getProducts(): Single<List<Product>>
}