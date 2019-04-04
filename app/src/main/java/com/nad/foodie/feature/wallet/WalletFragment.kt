package com.nad.foodie.feature.wallet

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.nad.foodie.R
import com.nad.foodie.databinding.FragmentWalletBinding
import com.nad.foodie.feature.base.BaseFragment

class WalletFragment : BaseFragment() {

    private lateinit var binding: FragmentWalletBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_wallet, container, false)
        return binding.root
    }
}