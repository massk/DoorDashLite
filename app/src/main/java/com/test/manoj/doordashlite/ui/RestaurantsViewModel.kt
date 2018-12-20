package com.test.manoj.doordashlite.ui

import android.app.Application
import com.test.manoj.doordashlite.network.DataManager
import android.arch.lifecycle.AndroidViewModel
import com.test.manoj.doordashlite.network.Restaurant
import com.test.manoj.doordashlite.network.RestaurantsRecords
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers


//
// Created by Manoj Kamde on 12/17/18.
// for Test Projects.
//

class RestaurantsViewModel (
    context: Application,
    private val dataManager: DataManager)
    : AndroidViewModel(context) {

    fun getRestaurantsFromDatabase(): Observable<List<Restaurant>> {
        return Observable.defer { Observable.just(dataManager.selectRestaurants())}
            .map { it: List<Restaurant> ->
                it
            }
            .subscribeOn(Schedulers.computation())
    }

    fun getRestaurantsFromNetwork(): Observable<List<Restaurant>> {
        return dataManager.getRestaurants()
            .map { it: List<Restaurant> ->
                if (it != null) {
                    dataManager.deleteRestaurants()
                    dataManager.insertRestaurants(it as MutableList<Restaurant>)
                }
                it
            }
            .subscribeOn(Schedulers.io())
    }
}