package com.nad.foodie.api

import com.nad.foodie.api.response.MenuResponse
import com.nad.foodie.api.response.PromoResponse
import io.reactivex.Observable
import retrofit2.http.GET

interface ApiInterface {

    //    menu
    @GET("7s80o")
    fun getMenu(): Observable<RestListResponse<MenuResponse>>

    //    promo
    @GET("13q2b4")
    fun getPromo(): Observable<RestListResponse<PromoResponse>>
}