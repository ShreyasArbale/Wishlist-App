package com.example.jetwishlistapp

import android.app.Application
import com.example.jetwishlistapp.di.Graph

class WishListApp : Application() {
    override fun onCreate() {
        super.onCreate()
        Graph.provide(
            this
        )
    }
}