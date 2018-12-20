package com.test.manoj.doordashlite

import android.util.Log
import com.test.manoj.doordashlite.network.ApiHelper
import com.test.manoj.doordashlite.network.ApiService
import com.test.manoj.doordashlite.network.Restaurant
import com.test.manoj.doordashlite.network.RestaurantsRecords
import io.reactivex.Observable
import timber.log.Timber
import javax.inject.Inject


//
// Created by Manoj Kamde on 12/17/18.
// for Test Projects.
//

class AppApiHelper @Inject constructor(private val apiService: ApiService) : ApiHelper {

    override fun getRestaurants(): Observable<List<Restaurant>> {
        Timber.plant(Timber.DebugTree())
        var value: Any  = apiService.getRestaurants("37.422740", "-122.139956", "0", "5")
        Log.i("Test,value", value.toString());
        return apiService.getRestaurants("37.422740", "-122.139956", "0", "50")
    }
}

//37.422740&lng=-122.139956