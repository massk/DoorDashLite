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

//    val address: Address,
//    val asap_time: Any, // null
//    val average_rating: Double, // 4.6
//    val business: Business,
//    @PrimaryKey(autoGenerate = false)
//    val business_id: Int, // 88
//    val composite_score: Int, // 9
//    val cover_img_url: String, // https://cdn.doordash.com/media/restaurant/cover/MediterraneanGrillHouse_650_Mountain_View_CA.png
//    val delivery_fee: Int, // 0
//    val description: String, // Authentic Mediterranean Cuisine
//    val extra_sos_delivery_fee: Int, // 0
//    val featured_category_description: Any, // null
//    val header_img_url: String,
//    val id: Int, // 89
//    val is_newly_added: Boolean, // false
//    val is_only_catering: Boolean, // false
//    val is_time_surging: Boolean, // false
//    val max_composite_score: Int, // 10
//    val max_order_size: Any, // null
//    val menus: List<Menu>,
//    val merchant_promotions: List<MerchantPromotion>,
//    val name: String, // Mediterranean Grill House
//    val number_of_ratings: Int, // 1603
//    val price_range: Int, // 2
//    val promotion: Any, // null
//    val service_rate: Double, // 11.0
//    val slug: String, // mediterranean-grill-house-mountain-view
//    val status: String, // Pre-order for Pre-order
//    val status_type: String, // pre-order
//    val tags: List<String>,
//    val url: String, // /store/mediterranean-grill-house-mountain-view-89/
//    val yelp_rating: Double, // 3.5
//    val yelp_review_count: Int // 430
)