package com.nad.foodie.feature.main

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.util.Log
import android.view.Menu
import com.nad.foodie.R
import com.nad.foodie.databinding.ActivityMainBinding
import com.nad.foodie.feature.base.BaseActivity
import com.nad.foodie.feature.dashboard.DashboardFragment
import com.nad.foodie.feature.order.OrderFragment
import com.nad.foodie.feature.referral.ReferralFragment
import com.nad.foodie.feature.wallet.WalletFragment
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : BaseActivity(), MainContract.View, HasSupportFragmentInjector {

    @Inject
    internal lateinit var supportFragmentInjector: DispatchingAndroidInjector<Fragment>

    @Inject
    lateinit var presenter: MainContract.Presenter
    private var tabIndex = 0
    private lateinit var binding: ActivityMainBinding

    override fun supportFragmentInjector(): AndroidInjector<Fragment> {
        return supportFragmentInjector
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        AndroidInjection.inject(this)

        presenter.attach()
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
        val fragment = DashboardFragment()
        addFragment(fragment)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                val fragment = DashboardFragment()
                addFragment(fragment)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_order -> {
                val fragment = OrderFragment()
                addFragment(fragment)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_wallet -> {
                val fragment = WalletFragment()
                addFragment(fragment)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_referral -> {
                val fragment = ReferralFragment()
                addFragment(fragment)
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun addFragment(fragment: Fragment) {
        val data = Bundle()
        data.putInt("DEFAULT_TAB", tabIndex)
        supportFragmentManager
            .beginTransaction()
            .disallowAddToBackStack()
            .replace(R.id.container_main, fragment, fragment.javaClass.simpleName)
            .commit()
    }

    override fun onBackPressed() {
        super.onBackPressed()

        finish()
    }

    override fun showProgress(show: Boolean) {
        Log.d(javaClass.simpleName, "showprogress")
    }
}