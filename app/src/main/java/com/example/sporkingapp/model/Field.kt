package com.example.sporkingapp.model

data class Field (
    val id: Int,
    val name: String,
    val price: String,
    val distance: Double,
    val rating: Int,
    val photo: Int,
    val phoneNumber: String,
    val lat: Double,
    val long: Double,
    val category: String
)
