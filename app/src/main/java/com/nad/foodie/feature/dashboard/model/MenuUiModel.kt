package com.nad.foodie.feature.dashboard.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MenuUiModel(
    val name_menu: String = "",
    val price_menu: String = "",
    val image_menu: String = "",
    var store_menu: String = ""
) : Parcelable