package com.example.aplika.Data.Repository

import com.example.aplika.Data.model.Banner
import io.reactivex.Single

interface BannerRepository {

    fun getBanner() :Single<List<Banner>>

}