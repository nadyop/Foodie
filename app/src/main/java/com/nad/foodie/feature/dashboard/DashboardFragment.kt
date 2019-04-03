package com.nad.foodie.feature.dashboard

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.view.menu.MenuAdapter
import android.support.v7.widget.GridLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.nad.foodie.R
import com.nad.foodie.databinding.FragmentDashboardBinding
import com.nad.foodie.feature.base.BaseFragment
import com.nad.foodie.feature.dashboard.model.MenuUiModel
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

class DashboardFragment : BaseFragment() , DashboardContract.View {

    @Inject
    lateinit var presenter: DashboardContract.Presenter
    private lateinit var binding: FragmentDashboardBinding
    private var menuAdapter: MenuAdapter? = null

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
        val layoutManager = GridLayoutManager(context, 2)
//        binding.recyclerView.layoutManager = layoutManager

//        if (menuAdapter == null) {
//            menuAdapter = MenuAdapter(ArrayList())
//        }
//        binding.recyclerView.adapter = menuAdapter

//        presenter.fetchData()
    }

    override fun fetchMenu(list: MutableList<MenuUiModel>) {
//        menuAdapter?.addItems(list)
//        recyclerView.adapter = menuAdapter
    }

    override fun showProgress(show: Boolean) {
        if (show) {
//            binding.progressBar.visibility = View.VISIBLE
        } else {
//            binding.progressBar.visibility = View.GONE
        }
    }

}