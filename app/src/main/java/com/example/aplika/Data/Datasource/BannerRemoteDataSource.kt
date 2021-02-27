package com.example.aplika.Data.Datasource

import com.example.aplika.Data.model.Banner
import com.example.aplika.Servicee.ApiService.ApiService
import io.reactivex.Single

class BannerRemoteDataSource (val apiService: ApiService) :BannerDataSource {
    override fun getBanner(): Single<List<Banner>> {

        return apiService.getBannerList()
    }
}