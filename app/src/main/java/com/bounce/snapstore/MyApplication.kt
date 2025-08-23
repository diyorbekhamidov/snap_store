package com.bounce.snapstore

import android.app.Application
import androidx.appcompat.app.AppCompatDelegate
import com.bounce.snapstore.di.component.DaggerNetworkComponent
import com.bounce.snapstore.di.component.NetworkComponent

class MyApplication : Application() {

    lateinit var networkComponent: NetworkComponent
    override fun onCreate() {
        super.onCreate()

        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        networkComponent = DaggerNetworkComponent.create()
    }
}