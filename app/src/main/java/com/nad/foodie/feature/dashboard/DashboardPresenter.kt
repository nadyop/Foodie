package com.nad.foodie.feature.dashboard

import com.nad.foodie.api.ApiInterface
import com.nad.foodie.api.RestListResponse
import com.nad.foodie.api.response.MenuResponse
import com.nad.foodie.api.response.PromoResponse
import com.nad.foodie.feature.base.BasePresenter
import com.nad.foodie.feature.dashboard.model.MenuMapper
import com.nad.foodie.feature.dashboard.model.MenuUiModel
import com.nad.foodie.feature.dashboard.model.PromoMapper
import com.nad.foodie.feature.dashboard.model.PromoUiModel
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
                val listItems: MutableList<MenuUiModel> = ArrayList()
                list.data.forEach { contentElement ->
                    listItems.add(MenuMapper.mapToMenuUiModel(contentElement))
                }
                view.fetchMenuSuccess(listItems)
            }, { error ->
                view.showProgress(false)
            })

        subscriptions.add(subscribe)
    }

    override fun fetchPromo() {
        val subscribe = api.getPromo().subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ list: RestListResponse<PromoResponse> ->
                view.showProgress(false)
                val listItems: MutableList<PromoUiModel> = ArrayList()
                list.data.forEach { contentElement ->
                    listItems.add(PromoMapper.mapToPromoUiModel(contentElement))
                }
                view.fetchPromoSuccess(listItems)
            }, { error ->
                view.showProgress(false)
            })

        subscriptions.add(subscribe)
    }

    override fun attachView(view: DashboardContract.View) {
        this.view = view
    }
}