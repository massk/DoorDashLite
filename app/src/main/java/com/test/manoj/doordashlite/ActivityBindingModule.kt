package com.test.manoj.doordashlite

import com.test.manoj.doordashlite.ui.Discover
import com.test.manoj.doordashlite.ui.RestaurantsActivityModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBindingModule {

    @ContributesAndroidInjector(modules = [(RestaurantsActivityModule::class)])
    abstract fun bindRestaurantsActivity(): Discover
}