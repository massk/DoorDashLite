package com.test.manoj.doordashlite.network

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


//
// Created by Manoj Kamde on 12/17/18.
// for Test Projects.
//

data class Source (
    @SerializedName("id")
    @Expose
    var id: Any? = null,
    @SerializedName("name")
    @Expose
    var name: String? = null

)
