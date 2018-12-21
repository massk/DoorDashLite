package com.test.manoj.doordashlite

import android.arch.persistence.room.Room
import android.support.test.InstrumentationRegistry
import android.support.test.runner.AndroidJUnit4
import com.test.manoj.doordashlite.model.RestaurantDao
import com.test.manoj.doordashlite.model.RestaurantDatabase
import com.test.manoj.doordashlite.network.Restaurant
import org.junit.Before
import org.junit.runner.RunWith
import org.junit.After
import org.junit.Assert.assertNotNull
import org.junit.Test
import java.io.IOException
import org.junit.Assert.*

//
// Created by Manoj Kamde on 12/19/18.
// for Test Projects.
//

// Instrumental Tests
@RunWith(AndroidJUnit4::class)
class RestaurantsDaoTests {
    var restaurantDatabase: RestaurantDatabase? = null

    @Before
    fun initDb() {
        val context = InstrumentationRegistry.getTargetContext()
        restaurantDatabase = Room.inMemoryDatabaseBuilder(context, RestaurantDatabase::class.java).build()
    }

    @After
    fun closeDB() {
        restaurantDatabase!!.close()
    }

    @Test
    fun insertRestaurantsTest() {
        val mutableList = mutableListOf<Restaurant>()
        val restaurant1 = Restaurant(id = 100, description = "Authentic Mediterranean Cuisine"
            , name = "Mediterranean Grill House", cover_img_url =  "https://cdn.doordash.com/media/restaurant/cover/MediterraneanGrillHouse_650_Mountain_View_CA.png"
            , status = "Pre-order",  status_type = "pre-order", delivery_fee = 0)

        val restaurant2 = Restaurant(id = 200, description = "Canadian bacon"
            , name = "Canadian bacon House", cover_img_url =  "https://cdn.doordash.com/media/restaurant/cover/MediterraneanGrillHouse_650_Mountain_View_CA.png"
            , status = "Pre-order",  status_type = "pre-order", delivery_fee = 2)
        mutableList.add(restaurant1)
        mutableList.add(restaurant2)
        restaurantDatabase?.restaurantsDao()?.insertRestaurants(mutableList)

        var restaurants = restaurantDatabase?.restaurantsDao()?.selectRestaurants()
        assertEquals(restaurants?.size, 2)
    }

    @Test
    fun deleteRestaurantsTest() {
        restaurantDatabase?.restaurantsDao()?.deleteRestaurants()
        var restaurants = restaurantDatabase?.restaurantsDao()?.selectRestaurants()
        assertEquals(restaurants?.size, 0)
    }



}