package com.example.aplika.Servicee.ImageLoadinServices

import com.example.aplika.CoustomeView.NikeImageView

interface ImageLoadingService {
    fun load(imageView: NikeImageView,imageUrl:String)
}