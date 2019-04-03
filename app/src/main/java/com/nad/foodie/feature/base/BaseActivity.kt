package com.nad.foodie.feature.base

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log

abstract class BaseActivity : AppCompatActivity(), BaseContract.View {

    fun BaseActivity() {}

    protected open fun getPresenter(): BaseContract.Presenter? {
        return null
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Log.d(javaClass.simpleName, "oncreate")
        val presenter = getPresenter()
        presenter?.attach()
    }

    override fun onResume() {
        super.onResume()
        Log.d(javaClass.simpleName, "onresume")
    }

    override fun onStart() {
        super.onStart()
        Log.d(javaClass.simpleName, "onstart")

    }

    override fun onPause() {
        super.onPause()

        Log.d(javaClass.simpleName, "onpause")
    }

    override fun onDestroy() {
        Log.d(javaClass.simpleName, "ondestroy")

        val presenter = getPresenter()
        presenter?.dettach()

        super.onDestroy()
    }
}