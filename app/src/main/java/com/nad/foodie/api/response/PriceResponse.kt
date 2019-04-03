package com.nad.foodie.api.response

import com.google.gson.annotations.SerializedName

data class PriceResponse(

    @field:SerializedName("name_price") val name_price: String? = null,

    @field:SerializedName("desc_price") val desc_price: String? = null
)