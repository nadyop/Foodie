package com.nad.foodie.feature.main

import android.support.v4.app.Fragment
import com.nad.foodie.feature.base.BaseContract

class MainContract {

    interface View: BaseContract.View {
        fun addFragment(fragment: Fragment)
    }

    interface Presenter: BaseContract.Presenter {
        fun attachView(view: View)
    }
}