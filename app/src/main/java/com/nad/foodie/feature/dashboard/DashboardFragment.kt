package com.nad.foodie.feature.dashboard

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.nad.foodie.R
import com.nad.foodie.databinding.FragmentDashboardBinding
import com.nad.foodie.feature.base.BaseFragment
import com.nad.foodie.feature.dashboard.model.MenuUiModel
import com.nad.foodie.feature.dashboard.model.PromoUiModel
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

class DashboardFragment : BaseFragment(), DashboardContract.View {
    @Inject
    lateinit var presenter: DashboardContract.Presenter
    private lateinit var binding: FragmentDashboardBinding
    private var menuAdapter: MenuAdapter? = null
    private var promoAdapter: PromoAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {

        AndroidSupportInjection.inject(this)
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_dashboard, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.attachView(this)
        initView()
    }

    private fun initView() {
        val layoutManager = GridLayoutManager(context, 1)
        layoutManager.orientation = LinearLayoutManager.HORIZONTAL
        binding.rvFeaturedMenu.layoutManager = layoutManager

        val layoutManagerPromo = GridLayoutManager(context, 1)
        layoutManagerPromo.orientation = LinearLayoutManager.HORIZONTAL
        binding.rvPromo.layoutManager = layoutManagerPromo

        val layoutManagerNew = GridLayoutManager(context, 1)
        layoutManagerNew.orientation = LinearLayoutManager.HORIZONTAL
        binding.rvNewProduct.layoutManager = layoutManagerNew

        if (menuAdapter == null) {
            menuAdapter = MenuAdapter(ArrayList())
        }
        binding.rvFeaturedMenu.adapter = menuAdapter
        binding.rvNewProduct.adapter = menuAdapter

        if (promoAdapter == null) {
            promoAdapter = PromoAdapter(ArrayList())
        }
        binding.rvPromo.adapter = promoAdapter

        presenter.fetchMenu()
        presenter.fetchPromo()
    }

    override fun fetchMenuSuccess(list: MutableList<MenuUiModel>) {
        menuAdapter?.addItems(list)
        binding.rvFeaturedMenu.adapter = menuAdapter
        binding.rvNewProduct.adapter = menuAdapter
    }

    override fun fetchPromoSuccess(list: MutableList<PromoUiModel>) {
        promoAdapter?.addItems(list)
        binding.rvPromo.adapter = promoAdapter
    }

}