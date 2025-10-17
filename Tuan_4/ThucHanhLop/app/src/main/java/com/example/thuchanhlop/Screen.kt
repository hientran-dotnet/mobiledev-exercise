package com.example.thuchanhlop

sealed class Screen(val route: String){
    object MainLayout : Screen("main_layout")

    object  LazyColumnLayout : Screen("lazy_column_layout")
}