package com.example.aplika.Data.Repository

import com.example.aplika.Data.Datasource.BannerDataSource
import com.example.aplika.Data.model.Banner
import com.example.aplika.Servicee.ApiService.ApiService
import io.reactivex.Single

class BannerRepositoryImpl(val bannerDataSource: BannerDataSource) :BannerRepository {
    override fun getBanner(): Single<List<Banner>> {

        return bannerDataSource.getBanner()
    }
}