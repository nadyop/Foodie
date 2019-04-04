package com.nad.foodie.feature.dashboard.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class PromoUiModel(
    val image_promo: String = ""
) : Parcelable