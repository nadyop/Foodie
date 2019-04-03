package com.nad.foodie.dagger.module

import com.nad.foodie.dagger.module.feature.DashboardModule
import com.nad.foodie.dagger.module.feature.MainModule
import com.nad.foodie.dagger.scope.ActivityScope
import com.nad.foodie.feature.dashboard.DashboardFragment
import com.nad.foodie.feature.main.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityModule {

    @ActivityScope
    @ContributesAndroidInjector(modules = [MainModule::class])
    abstract fun provideMainActivity(): MainActivity

    @ActivityScope
    @ContributesAndroidInjector(modules = [DashboardModule::class])
    abstract fun provideDashboardFragment(): DashboardFragment
}