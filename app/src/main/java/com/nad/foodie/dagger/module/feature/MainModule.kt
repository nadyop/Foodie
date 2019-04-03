package com.nad.foodie.dagger.module.feature

import com.nad.foodie.dagger.scope.ActivityScope
import com.nad.foodie.feature.main.MainActivity
import com.nad.foodie.feature.main.MainContract
import com.nad.foodie.feature.main.MainPresenter
import dagger.Binds
import dagger.Module

@Module
abstract class MainModule {
    @ActivityScope
    @Binds
    internal abstract fun provideMainView(mainView: MainActivity): MainContract.View

    @ActivityScope
    @Binds
    internal abstract fun provideMainPresenter(
        mainPresenter: MainPresenter): MainContract.Presenter
}