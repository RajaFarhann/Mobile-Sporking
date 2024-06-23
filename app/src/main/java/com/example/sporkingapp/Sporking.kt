package com.example.sporkingapp

import android.app.Application
import android.util.Log
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class Sporking : Application() {

    override fun onCreate() {
        super.onCreate()
        Log.d(TAG, "coming_inside_onCreate")
    }

    companion object{
        const val TAG = "Sporking"
    }
//    override fun onCreate() {
//        super.onCreate()
//        // Inisialisasi lainnya jika diperlukan
//    }
}