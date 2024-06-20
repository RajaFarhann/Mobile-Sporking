package com.example.sporkingapp.utils

import com.example.sporkingapp.navigation.Screen

fun String?.shouldShowBottomBar(): Boolean {
    return this in setOf(
        Screen.Beranda.route,
        Screen.Category.route,
        Screen.NewsScreen.route,
        Screen.Komunitas.route,
        Screen.Pemesanan.route,
    )
}