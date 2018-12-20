package com.test.manoj.doordashlite.model

import com.test.manoj.doordashlite.network.Restaurant


//
// Created by Manoj Kamde on 12/17/18.
// for Test Projects.
//
interface DbHelper {
    fun insertRestaurants(restaurant: MutableList<Restaurant>): List<Long>

    fun selectRestaurants(): List<Restaurant>

    fun deleteRestaurants()
}