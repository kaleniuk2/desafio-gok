package com.kaleniuk2.desafiogo_k

import android.app.Application
import androidx.appcompat.app.AppCompatDelegate
import com.kaleniuk2.data.remote.di.dataModules
import com.kaleniuk2.desafiogo_k.di.presentationModule
import com.kaleniuk2.domain.di.domainModule
import org.koin.android.ext.android.startKoin

class CustomApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        startKoin(this, dataModules + presentationModule + domainModule)
    }
}