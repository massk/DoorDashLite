package com.test.manoj.doordashlite

import android.app.Application
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import com.test.manoj.doordashlite.di.ApplicationContext
import com.test.manoj.doordashlite.di.BaseUrl
import com.test.manoj.doordashlite.model.AppDbHelper
import com.test.manoj.doordashlite.model.DbHelper
import com.test.manoj.doordashlite.model.RestaurantDatabase
import com.test.manoj.doordashlite.network.ApiHelper
import com.test.manoj.doordashlite.network.DataManager
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Singleton


//
// Created by Manoj Kamde on 12/17/18.
// for Test Projects.
//

@Module
class ApplicationModule {

    @Provides
    @ApplicationContext
    internal fun provideContext(doorDashLiteApplication: DoorDashLiteApplication): Context {
        return doorDashLiteApplication.applicationContext
    }


    @Provides
    internal fun provideApplication(doorDashLiteApplication: DoorDashLiteApplication): Application {
        return doorDashLiteApplication
    }



    @Provides
    internal fun provideCompositeDisposable(): CompositeDisposable {
        return CompositeDisposable()
    }


    @Provides
    @Singleton
    fun provideRoomDatabase(@ApplicationContext context: Context): RestaurantDatabase {
        return Room.databaseBuilder(context, RestaurantDatabase::class.java, Config.DB_NAME)
            .setJournalMode(RoomDatabase.JournalMode.TRUNCATE)
            .build()
    }

    @Provides
    @Singleton
    internal fun provideDataManager(appDataManager: AppDataManager): DataManager {
        return appDataManager
    }

    @Provides
    @Singleton
    internal fun provideDbHelper(appDbHelper: AppDbHelper): DbHelper {
        return appDbHelper
    }

    @Provides
    @Singleton
    internal fun provideApiHelper(appApiHelper: AppApiHelper): ApiHelper {
        return appApiHelper
    }

    @Provides
    @BaseUrl
    internal fun provideBaseUrl(): String {
        return Config.BASE_URL
    }

}