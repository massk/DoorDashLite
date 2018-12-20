package com.test.manoj.doordashlite.network

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

//
// Created by Manoj Kamde on 12/17/18.
// for Test Projects.
//

@Entity(tableName = "restaurants")
data class Restaurant(
    @PrimaryKey(autoGenerate = false)
    val id: Int, // 89

    @SerializedName("description")
    @Expose
    @ColumnInfo(name = "description")
    val description: String, // Authentic Mediterranean Cuisine

    @SerializedName("name")
    @Expose
    @ColumnInfo(name = "name")
    val name: String, // Mediterranean Grill House

    @SerializedName("cover_img_url")
    @Expose
    @ColumnInfo(name = "cover_img_url")
    val cover_img_url: String, // https://cdn.doordash.com/media/restaurant/cover/MediterraneanGrillHouse_650_Mountain_View_CA.png

    @SerializedName("status")
    @Expose
    @ColumnInfo(name = "status")
    val status: String, // Pre-order for Pre-order

    @SerializedName("status_type")
    @Expose
    @ColumnInfo(name = "status_type")
    val status_type: String, // pre-order

    @SerializedName("delivery_fee")
    @Expose
    @ColumnInfo(name = "delivery_fee")
    val delivery_fee: Int // 0
)