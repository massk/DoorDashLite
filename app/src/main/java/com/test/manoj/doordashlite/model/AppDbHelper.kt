package com.test.manoj.doordashlite.model

import com.test.manoj.doordashlite.network.Restaurant
import javax.inject.Inject


//
// Created by Manoj Kamde on 12/17/18.
// for Test Projects.
//

class AppDbHelper @Inject
constructor(private val appDatabase: RestaurantDatabase) : DbHelper {

    override fun insertRestaurants(restaurant: MutableList<Restaurant>): List<Long> {
        return appDatabase.restaurantsDao().insertRestaurants(restaurant)
    }

    override fun selectRestaurants(): List<Restaurant> {
        return appDatabase.restaurantsDao().selectRestaurants()
    }

    override fun deleteRestaurants() {
        appDatabase.restaurantsDao().deleteRestaurants()
    }
}