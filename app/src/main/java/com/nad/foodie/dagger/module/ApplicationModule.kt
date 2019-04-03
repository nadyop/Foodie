package com.nad.foodie.dagger.module

import android.app.Application
import com.nad.foodie.ApplicationBase
import com.nad.foodie.dagger.scope.PerApplication
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(includes = [WebServiceModule::class])
class ApplicationModule(private val appBase: ApplicationBase) {

    @Provides
    @Singleton
    @PerApplication
    fun provideApplication(): Application {
        return appBase
    }
}