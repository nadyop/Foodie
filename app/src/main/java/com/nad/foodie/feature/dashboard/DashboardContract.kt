package com.nad.foodie.feature.dashboard

import com.nad.foodie.feature.base.BaseContract
import com.nad.foodie.feature.dashboard.model.MenuUiModel

class DashboardContract {

    interface View : BaseContract.View {
        fun fetchMenuSuccess(list: MutableList<MenuUiModel>)
//        fun fetchPromoSuccess(list: MutableList<MenuUiModel>)
    }

    interface Presenter : BaseContract.Presenter {
        fun fetchMenu()
        fun fetchPromo()
        fun attachView(view: View)
    }
}