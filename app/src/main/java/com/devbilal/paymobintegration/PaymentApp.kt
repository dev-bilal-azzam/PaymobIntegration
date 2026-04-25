package com.devbilal.paymobintegration

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber

@HiltAndroidApp
class PaymentApp: Application()  {
    override fun onCreate() {
        super.onCreate()

        // for logging
        Timber.plant(Timber.DebugTree())
    }
}