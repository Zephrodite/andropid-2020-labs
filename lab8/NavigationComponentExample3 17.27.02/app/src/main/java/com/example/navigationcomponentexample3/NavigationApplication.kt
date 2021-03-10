package com.example.navigationcomponentexample3

import android.app.Application
import timber.log.Timber

class NavigationApplication: Application() {
    override fun onCreate() {
        super.onCreate()

        Timber.plant(Timber.DebugTree())
    }
}