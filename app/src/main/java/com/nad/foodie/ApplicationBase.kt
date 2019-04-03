package com.nad.foodie

import android.app.Activity
import android.app.Application
import android.app.Service
import com.nad.foodie.dagger.component.ApplicationComponent
import com.nad.foodie.dagger.component.DaggerApplicationComponent
import com.nad.foodie.dagger.module.ApplicationModule
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import dagger.android.HasServiceInjector
import javax.inject.Inject

class ApplicationBase : Application(), HasActivityInjector, HasServiceInjector {

    @Inject
    lateinit var activityDispatchingAndroidInjector: DispatchingAndroidInjector<Activity>

    @Inject
    lateinit var serviceDispatchingAndroidInjector: DispatchingAndroidInjector<Service>

    lateinit var appComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()

        instance = this
        DaggerApplicationComponent.builder().applicationModule(ApplicationModule(getInstance()))
            .build().inject(this)
    }

    override fun activityInjector(): AndroidInjector<Activity> {
        return activityDispatchingAndroidInjector
    }

    override fun serviceInjector(): AndroidInjector<Service> {
        return serviceDispatchingAndroidInjector
    }

    fun getInstance(): ApplicationBase {
        return instance
    }

    companion object {
        lateinit var instance: ApplicationBase private set
    }

    fun getApplicationComponent(): ApplicationComponent {
        return this.appComponent
    }

}
