package com.example.aplika.Data.Repository

import com.example.aplika.Data.model.Product
import io.reactivex.Single

interface ProductRepository {


    fun getProducts():Single<List<Product>>

}