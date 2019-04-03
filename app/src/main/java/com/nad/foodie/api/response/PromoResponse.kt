package com.nad.foodie.api.response

import com.google.gson.annotations.SerializedName

data class PromoResponse(

    @field:SerializedName("name_promo") val name_promo: String? = null,

    @field:SerializedName("image_promo") val image_promo: String? = null
)