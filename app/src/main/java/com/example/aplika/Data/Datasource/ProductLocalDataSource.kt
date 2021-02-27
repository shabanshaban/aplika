package com.example.aplika.Data.Datasource

import com.example.aplika.Data.model.Product
import io.reactivex.Single

class ProductLocalDataSource :ProductDataSource {
    override fun getProducts(): Single<List<Product>> {
        TODO("Not yet implemented")
    }
}