package com.test.manoj.doordashlite


import android.content.Context
import android.support.test.InstrumentationRegistry
import android.support.test.runner.AndroidJUnit4
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.test.manoj.doordashlite.network.Restaurant
import com.test.manoj.doordashlite.ui.RestaurantsAdapter
import kotlinx.android.synthetic.main.restaurent_list_item.view.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import kotlin.test.assertEquals
import kotlin.test.assertNotNull
import android.view.ViewGroup
import android.widget.ImageView
import org.mockito.Mockito.mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.`when`







//
// Created by Manoj Kamde on 12/20/18.
// for Test Projects.
//
@RunWith(AndroidJUnit4::class)
public class AdapterTest {
    var context: Context? = null

    val mutableList = mutableListOf<Restaurant>()
    val restaurant1 = Restaurant(id = 100, description = "Authentic Mediterranean Cuisine"
        , name = "Mediterranean Grill House", cover_img_url =  "https://cdn.doordash.com/media/restaurant/cover/MediterraneanGrillHouse_650_Mountain_View_CA.png"
        , status = "Pre-order",  status_type = "pre-order", delivery_fee = 0)

    val restaurant2 = Restaurant(id = 200, description = "Canadian bacon"
        , name = "Canadian bacon House", cover_img_url =  "https://cdn.doordash.com/media/restaurant/cover/MediterraneanGrillHouse_650_Mountain_View_CA.png"
        , status = "Pre-order",  status_type = "pre-order", delivery_fee = 2)


    private var restaurantsAdapter: RestaurantsAdapter? = null

    @Before
    fun setUp() {
        val application = InstrumentationRegistry.getContext();
        assertNotNull(application);
        context = application;
        mutableList.add(restaurant1)
        mutableList.add(restaurant2)
        restaurantsAdapter = RestaurantsAdapter(restaurants = mutableList)
    }

    @Test
    fun test_getItemCount() {
        val initialExpected = 2
        val initialActual = restaurantsAdapter?.getItemCount()
        assertEquals(initialExpected, initialActual)
    }
}