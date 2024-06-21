package com.example.sporkingapp.model.login

data class LoginState(
    val success: String? = "",
    val error: String? = "",
    val loading: Boolean = false
)