package com.example.jetwishlistapp.di

import android.content.Context
import androidx.room.Room
import com.example.jetwishlistapp.data.local.WishDatabase
import com.example.jetwishlistapp.data.repository.WishRepository

object Graph {

    lateinit var database: WishDatabase

    val wishRepository by lazy {
        WishRepository(wishDao = database.wishDao())
    }

    fun provide(context: Context) {
        database = Room.databaseBuilder(context, WishDatabase::class.java, "wishlist.db").build()
    }
}