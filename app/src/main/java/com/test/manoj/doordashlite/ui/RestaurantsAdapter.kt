package com.test.manoj.doordashlite.ui

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions.withCrossFade
import com.test.manoj.doordashlite.R
import com.test.manoj.doordashlite.network.Restaurant
import kotlinx.android.synthetic.main.restaurent_list_item.view.*

class RestaurantsAdapter(private val restaurants: MutableList<Restaurant>?) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    interface Callback {
        fun onRestaurantClick(url: String)
    }

    private var callback: Callback? = null

    fun setCallback(callback: Callback) {
        this.callback = callback
    }

    fun addItems(restaurant: MutableList<Restaurant>?) {
        this.restaurants?.clear()
        restaurant?.let { this.restaurants?.addAll(it) }
        notifyDataSetChanged()
    }

    private fun getItem(position: Int): Restaurant? {
        return if (position != RecyclerView.NO_POSITION) {
            restaurants?.get(position)
        } else
            null
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val restaurantViewHolder = RestaurantsViewHolder(LayoutInflater.from(parent.context).inflate(
            R.layout.restaurent_list_item, parent, false))
        restaurantViewHolder.itemView.setOnClickListener({
            val restaurant: Restaurant? = getItem(restaurantViewHolder.adapterPosition)
//            if (restaurant != null) {
//                callback?.onRestaurantClick(restaurant.url ?: "")
//            }
        })
        return restaurantViewHolder
    }

    override fun getItemCount(): Int {
        return restaurants?.size ?: 0
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as RestaurantsViewHolder).onBind(restaurants?.get(position))
    }

    class RestaurantsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun onBind(restaurant: Restaurant?) {

                    Glide.with(itemView.context)
                    .load(restaurant?.cover_img_url)
                    .transition(withCrossFade())
                    //.fitCenter()
                    .into(itemView.image)

            itemView.title.text = restaurant?.name
            itemView.description.text = restaurant?.description
            itemView.status.text = restaurant?.status

        }
    }
}