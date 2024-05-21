package com.example.sporkingapp.model

data class Category(
    val id: Int,
    val name: String,
    val photo: Int,
    val fields: List<Field>
)
