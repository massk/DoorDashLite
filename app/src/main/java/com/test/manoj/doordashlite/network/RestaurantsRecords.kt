package com.test.manoj.doordashlite.network

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class RestaurantsRecords(
        @SerializedName("status")
        @Expose
        var status: String? = null,
        @SerializedName("totalResults")
        @Expose
        var totalResults: Int? = null,
        @SerializedName("articles")
        @Expose
        var restaurants: List<Restaurant>
)
