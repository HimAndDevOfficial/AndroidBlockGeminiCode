package com.example.androidpracticecode

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import kotlin.text.Typography.dagger

@HiltAndroidApp
class BLOCKGEMINIApp : Application() {
   override fun onCreate() {
        super.onCreate()
    }
}