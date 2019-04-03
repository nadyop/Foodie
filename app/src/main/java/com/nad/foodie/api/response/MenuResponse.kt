package com.nad.foodie.api.response

import com.google.gson.annotations.SerializedName

data class MenuResponse(

    @field:SerializedName("name_menu") val name_menu: String? = null,

    @field:SerializedName("price_menu") val price_menu: String? = null,

    @field:SerializedName("image_menu") val image_menu: String? = null,

    @field:SerializedName("store_menu") val store_menu: String? = null
)