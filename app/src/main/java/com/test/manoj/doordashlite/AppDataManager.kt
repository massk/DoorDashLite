package com.test.manoj.doordashlite

import com.test.manoj.doordashlite.model.AppDbHelper
import com.test.manoj.doordashlite.network.DataManager
import com.test.manoj.doordashlite.network.Restaurant
import io.reactivex.Observable
import javax.inject.Inject


//
// Created by Manoj Kamde on 12/17/18.
// for Test Projects.
//

class AppDataManager @Inject constructor(private val appApiHelper: AppApiHelper, private val appDbHelper: AppDbHelper) :
    DataManager {

    override fun getRestaurants(): Observable<List<Restaurant>> {
        return appApiHelper.getRestaurants()
    }

    override fun insertRestaurants(restaurant: MutableList<Restaurant>): List<Long> {
        return appDbHelper.insertRestaurants(restaurant)
    }

    override fun selectRestaurants(): List<Restaurant> {
        return appDbHelper.selectRestaurants()
    }

    override fun deleteRestaurants() {
        appDbHelper.deleteRestaurants()
    }
}