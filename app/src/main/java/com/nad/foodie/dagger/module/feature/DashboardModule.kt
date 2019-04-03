package com.nad.foodie.dagger.module.feature

import com.nad.foodie.dagger.scope.ActivityScope
import com.nad.foodie.feature.dashboard.DashboardContract
import com.nad.foodie.feature.dashboard.DashboardFragment
import com.nad.foodie.feature.dashboard.DashboardPresenter
import dagger.Binds
import dagger.Module

@Module
abstract class DashboardModule {

    @ActivityScope
    @Binds
    abstract fun provideUserView(
        dashboardFragment: DashboardFragment): DashboardContract.View

    @ActivityScope
    @Binds
    abstract fun provideUserPresenter(
        dashboardPresenter: DashboardPresenter): DashboardContract.Presenter
}