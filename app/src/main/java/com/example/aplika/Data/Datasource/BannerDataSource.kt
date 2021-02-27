package com.example.aplika.Data.Datasource

import com.example.aplika.Data.model.Banner
import io.reactivex.Single

interface BannerDataSource {


    fun getBanner():Single<List<Banner>>

}