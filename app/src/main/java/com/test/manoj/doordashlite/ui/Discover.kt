package com.test.manoj.doordashlite.ui

import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.net.Uri
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.Toolbar
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import dagger.android.AndroidInjection
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import timber.log.Timber
import javax.inject.Inject
import com.test.manoj.doordashlite.R
import com.test.manoj.doordashlite.R.id.*
import com.test.manoj.doordashlite.ViewModelFactory
import com.test.manoj.doordashlite.network.*
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_discover.*
import retrofit2.adapter.rxjava2.Result.response
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory


class Discover : AppCompatActivity(), RestaurantsAdapter.Callback {

    @Inject
    lateinit var dataManager: DataManager
    @Inject
    lateinit var compositeDisposable: CompositeDisposable
    @Inject
    lateinit var linearLayoutManager: LinearLayoutManager
    @Inject
    lateinit var restaurantsAdapter: RestaurantsAdapter

    private lateinit var restaurantViewModel: RestaurantsViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_discover)

        restaurantViewModel = ViewModelProviders.of(this,
            ViewModelFactory.getInstance( application,  dataManager)
        ).get(RestaurantsViewModel::class.java)
        restaurantsAdapter.setCallback(this)

        init()
    }

    private fun init() {

        setSupportActionBar(toolbar as Toolbar?)

        refresh_layout.setOnRefreshListener {
            restaurantViewModel.getRestaurantsFromNetwork()
                .observeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : Observer<List<Restaurant>> {
                    override fun onComplete() {
                        refresh_layout.isRefreshing = false
                    }

                    override fun onSubscribe(d: Disposable) {
                        refresh_layout.isRefreshing = true
                        compositeDisposable.add(d)
                    }

                    override fun onNext(t: List<Restaurant>) {
                        restaurantsAdapter.addItems(t as MutableList<Restaurant>?)
                    }

                    override fun onError(e: Throwable) {
                        refresh_layout.isRefreshing = false
                        Timber.e(e)
                    }
                })
        }

        restaurants_list.layoutManager = linearLayoutManager
        restaurants_list.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
        restaurants_list.adapter = restaurantsAdapter

        getRestaurants()

    }

    private fun getRestaurants() {
        Observable.concat(
            restaurantViewModel.getRestaurantsFromDatabase(),
            restaurantViewModel.getRestaurantsFromNetwork()
        )
            .observeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread(), true)
            .subscribe(object : Observer<List<Restaurant>> {
                override fun onComplete() {
                    refresh_layout.isRefreshing = false
                }

                override fun onSubscribe(d: Disposable) {
                    refresh_layout.isRefreshing = true
                    compositeDisposable.add(d)
                }

                override fun onNext(t: List<Restaurant>) {
                    restaurantsAdapter.addItems(t as MutableList<Restaurant>?)
                }

                override fun onError(e: Throwable) {
                    refresh_layout.isRefreshing = false
                    Timber.e(e)
                }
            })
    }



    override fun onRestaurantClick(url: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}
