package com.nad.foodie.feature.order

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.nad.foodie.R
import com.nad.foodie.databinding.FragmentOrderBinding
import com.nad.foodie.feature.base.BaseFragment

class OrderFragment : BaseFragment() {

    private lateinit var binding: FragmentOrderBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_order, container, false)
        return binding.root
    }
}