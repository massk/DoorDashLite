package com.test.manoj.doordashlite.ui

import android.content.Context
import android.support.v7.widget.LinearLayoutManager
import com.test.manoj.doordashlite.di.ApplicationContext
import dagger.Module
import dagger.Provides


//
// Created by Manoj Kamde on 12/17/18.
// for Test Projects.
//

@Module
class RestaurantsActivityModule {

    @Provides
    fun provideRestaurantsAdapter(): RestaurantsAdapter{
        return RestaurantsAdapter(ArrayList())
    }

    @Provides
    fun provideLinearLayoutManager(@ApplicationContext context: Context): LinearLayoutManager {
        return LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
    }

}