package com.nad.foodie.feature.dashboard

import android.util.Log
import com.nad.foodie.api.ApiInterface
import com.nad.foodie.api.RestListResponse
import com.nad.foodie.api.response.MenuResponse
import com.nad.foodie.feature.base.BasePresenter
import com.nad.foodie.feature.dashboard.model.MenuMapper
import com.nad.foodie.feature.dashboard.model.MenuUiModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class DashboardPresenter @Inject constructor(private val api: ApiInterface) :
    BasePresenter(), DashboardContract.Presenter {

    private lateinit var view: DashboardContract.View
    private val subscriptions = CompositeDisposable()

    override fun fetchMenu() {
        val subscribe = api.getMenu().subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ list: RestListResponse<MenuResponse> ->
                view.showProgress(false)
                Log.d("AAAAZ", "sukses nihh")
                val listItems: MutableList<MenuUiModel> = ArrayList()
                list.data.forEach { contentElement ->
                    listItems.add(MenuMapper.mapToMenuUiModel(contentElement))
                }
                view.fetchMenuSuccess(listItems)
            }, { error ->
                view.showProgress(false)
                Log.d("AAAAZ", "error nihh data get+ ==== + ${error.message} + ==== + ${error.cause}")
            })

        subscriptions.add(subscribe)
    }

    override fun fetchPromo() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun attachView(view: DashboardContract.View) {
        this.view = view
    }
}