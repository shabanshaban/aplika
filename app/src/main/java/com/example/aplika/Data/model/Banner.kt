package com.example.aplika.Data.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Banner(val id:Int, val image:String, val link_type:Int, val link_value:Int): Parcelable
