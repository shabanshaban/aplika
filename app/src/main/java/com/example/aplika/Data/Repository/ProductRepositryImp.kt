package com.example.aplika.Data.Repository

import com.example.aplika.Data.Datasource.ProductDataSource
import com.example.aplika.Data.Datasource.ProductRemoteDataSource
import com.example.aplika.Data.model.Product
import io.reactivex.Single

class ProductRepositryImp(val remoteDataSource: ProductDataSource) :ProductRepository {
    override fun getProducts(): Single<List<Product>> {
         return remoteDataSource.getProducts()
    }
}