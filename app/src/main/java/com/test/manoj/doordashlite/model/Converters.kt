package com.test.manoj.doordashlite.model

import android.arch.persistence.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.test.manoj.doordashlite.network.Source


//
// Created by Manoj Kamde on 12/17/18.
// for Test Projects.
//

class Converters {
    @TypeConverter
    fun sourceToString(source: Source?): String? {
        if (source == null) {
            return null
        }
        val gson = Gson()
        val type = object : TypeToken<Source>() {

        }.type
        return gson.toJson(source, type)
    }

    @TypeConverter
    fun stringToSource(sourceString: String?): Source? {
        if (sourceString == null) {
            return null
        }
        val gson = Gson()
        val type = object : TypeToken<Source>() {

        }.type
        return gson.fromJson<Source>(sourceString, type)
    }
}