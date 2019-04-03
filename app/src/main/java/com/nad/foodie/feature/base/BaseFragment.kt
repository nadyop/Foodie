package com.nad.foodie.feature.base

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

abstract class BaseFragment : Fragment(), BaseContract.View {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = super.onCreateView(inflater, container, savedInstanceState)

        val presenter: BaseContract.Presenter? = getPresenter()
        presenter?.attach()

        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()

        val presenter: BaseContract.Presenter? = getPresenter()
        presenter?.dettach()
    }

    override fun showProgress(show: Boolean) {
        if (show) {
//            progressBar.visibility = View.VISIBLE
        } else {
//            progressBar.visibility = View.GONE
        }
    }

    protected fun getPresenter(): BaseContract.Presenter? {
        return null
    }
}