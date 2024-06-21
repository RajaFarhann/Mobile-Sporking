package com.example.sporkingapp

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class Sporking : Application() {
    override fun onCreate() {
        super.onCreate()
        // Inisialisasi lainnya jika diperlukan
    }
}