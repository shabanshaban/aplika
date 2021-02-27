package com.example.aplika.Data.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize
data class Product(
    val discount:Int,
    val id:Int,
    val image:String,
    val previous_price:Int,
    val price:Int,
    val status:Int,
    val title:String,
):Parcelable


