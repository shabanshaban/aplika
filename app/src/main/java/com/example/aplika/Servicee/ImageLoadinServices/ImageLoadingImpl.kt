package com.example.aplika.Servicee.ImageLoadinServices

import com.example.aplika.CoustomeView.NikeImageView
import com.facebook.drawee.view.SimpleDraweeView
import java.lang.IllegalStateException

class ImageLoadingImpl :ImageLoadingService {
    override fun load(imageView: NikeImageView, imageUrl: String) {
        if (imageView is SimpleDraweeView)
            imageView.setImageURI(imageUrl)
        else
            throw IllegalStateException("ImageView must be instance of simpleDraweeView")
    }
}