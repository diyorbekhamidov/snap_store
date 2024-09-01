package com.bounce.snapstore

import android.app.Application
import com.bounce.snapstore.presentation.di.component.DaggerNetworkComponent
import com.bounce.snapstore.presentation.di.component.NetworkComponent

class MyApplication : Application() {

    lateinit var networkComponent: NetworkComponent
    override fun onCreate() {
        super.onCreate()
        networkComponent = DaggerNetworkComponent.factory().create(this)
    }
}