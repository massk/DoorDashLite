package com.test.manoj.doordashlite.di

import com.test.manoj.doordashlite.ActivityBindingModule
import com.test.manoj.doordashlite.ApplicationModule
import com.test.manoj.doordashlite.DoorDashLiteApplication
import com.test.manoj.doordashlite.network.NetworkModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AndroidSupportInjectionModule::class,
    NetworkModule::class,
    ApplicationModule::class,
    ActivityBindingModule::class
])
interface ApplicationComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(doorDashLiteApplication: DoorDashLiteApplication): Builder

        fun build(): ApplicationComponent
    }

    fun inject(doorDashLiteApplication: DoorDashLiteApplication)

}