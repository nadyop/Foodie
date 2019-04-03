package com.nad.foodie.feature.dashboard

import com.nad.foodie.feature.base.BaseContract
import com.nad.foodie.feature.dashboard.model.MenuUiModel

class DashboardContract {

    interface View : BaseContract.View {
        fun fetchMenu(list: MutableList<MenuUiModel>)
    }

    interface Presenter : BaseContract.Presenter {
//        fun fetchData()
        fun attachView(view: View)
    }
}