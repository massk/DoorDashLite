package com.test.manoj.doordashlite.model

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.test.manoj.doordashlite.network.Restaurant


//
// Created by Manoj Kamde on 12/17/18.
// for Test Projects.
//

@Database( entities = arrayOf(Restaurant::class), version = 1)
public abstract class RestaurantDatabase : RoomDatabase() {
        abstract fun restaurantsDao(): RestaurantDao
}