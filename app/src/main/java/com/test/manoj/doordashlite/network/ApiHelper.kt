package com.test.manoj.doordashlite.network

import io.reactivex.Observable


//
// Created by Manoj Kamde on 12/17/18.
// for Test Projects.
//
interface ApiHelper {
    fun getRestaurants(): Observable<List<Restaurant>>
}