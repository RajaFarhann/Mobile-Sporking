package com.example.sporkingapp.navigation

sealed class Screen(val route: String) {
    data object Beranda : Screen("beranda")
    data object FieldSearch : Screen("field_search")
    data object Category : Screen("category")
    data object Pemesanan : Screen("pemesanan")
    data object Komunitas : Screen("komunitas")
    data object Detail : Screen("detail_field}")
    data object NewsDetail: Screen("news_detail")
    data object NewsScreen: Screen("news_screen")
    data object Welcome: Screen("welcome")
    data object SignIn: Screen("sign_in")
    data object SignUp: Screen("sign_up")
    data object Agreement: Screen("agreement")
    data object ProfileScreen: Screen("profile_screen")
    data object ChangePasswordScreen: Screen("change_password")
    data object AccountScreen: Screen("account_screen")
    data object SecurityNotify: Screen("security_notify")
}