package com.nad.foodie.feature.referral

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.nad.foodie.R
import com.nad.foodie.databinding.FragmentReferralBinding
import com.nad.foodie.feature.base.BaseFragment

class ReferralFragment : BaseFragment() {

    private lateinit var binding: FragmentReferralBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_referral, container, false)
        return binding.root
    }
}