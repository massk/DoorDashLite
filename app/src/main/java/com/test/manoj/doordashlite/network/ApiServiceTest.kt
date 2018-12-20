package com.test.manoj.doordashlite.network

import io.reactivex.Observable
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query



interface ApiServiceTest {

    @GET("restaurant")
    fun getRestaurants(
            @Query("lat") lat: String,
            @Query("lng") lng: String,
            @Query("offset") offset: String,
            @Query("limit") limit: String
    ): Observable<List<Restaurant>>
}