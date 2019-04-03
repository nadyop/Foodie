package com.nad.foodie.feature.dashboard

import com.nad.foodie.api.ApiInterface
import com.nad.foodie.feature.base.BasePresenter
import javax.inject.Inject

class DashboardPresenter @Inject constructor(private val api: ApiInterface) :
    BasePresenter(), DashboardContract.Presenter {

    private lateinit var view: DashboardContract.View

    override fun attachView(view: DashboardContract.View) {
        this.view = view
    }
}