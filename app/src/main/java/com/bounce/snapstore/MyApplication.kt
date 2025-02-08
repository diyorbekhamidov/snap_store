package com.bounce.snapstore

import android.app.Application
import com.bounce.snapstore.di.component.NetworkComponent
import com.bounce.snapstore.di.component.DaggerNetworkComponent

class MyApplication : Application() {

    lateinit var networkComponent: NetworkComponent
    override fun onCreate() {
        super.onCreate()
        networkComponent = DaggerNetworkComponent.factory().create(this)
    }
}