package com.nad.foodie.feature.base

abstract class BaseContract {

    interface View {
        fun showProgress(show: Boolean)
    }

    interface Presenter {
        fun attach()
        fun dettach()
    }
}