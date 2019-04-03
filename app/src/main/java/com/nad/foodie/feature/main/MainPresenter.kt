package com.nad.foodie.feature.main

import com.nad.foodie.api.ApiInterface
import com.nad.foodie.feature.base.BasePresenter
import javax.inject.Inject

class MainPresenter @Inject constructor(private val api: ApiInterface) : BasePresenter(),
    MainContract.Presenter {

    private var view: MainContract.View? = null
    override fun attachView(view: MainContract.View) {
        this.view = view
    }
}