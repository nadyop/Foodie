package com.nad.foodie.dagger.component

import com.nad.foodie.ApplicationBase
import com.nad.foodie.api.ApiInterface
import com.nad.foodie.dagger.module.ActivityModule
import com.nad.foodie.dagger.module.ApplicationModule
import com.nad.foodie.dagger.scope.ApplicationScope
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector

@ApplicationScope
@Component(modules = [AndroidInjectionModule::class, ApplicationModule::class, ActivityModule::class])
interface ApplicationComponent : AndroidInjector<ApplicationBase>{

    fun apiInterface(): ApiInterface
}