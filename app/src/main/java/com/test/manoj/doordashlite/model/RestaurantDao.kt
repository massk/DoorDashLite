package com.test.manoj.doordashlite.model

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import com.test.manoj.doordashlite.network.Restaurant


//
// Created by Manoj Kamde on 12/17/18.
// for Test Projects.
//

@Dao
interface RestaurantDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertRestaurants(restaurant: MutableList<Restaurant>): List<Long>

    @Query("SELECT * FROM restaurants")
    fun selectRestaurants(): List<Restaurant>

    @Query("DELETE FROM restaurants")
    fun deleteRestaurants()

}