package com.example.navigation_

sealed class Screen(val route: String){
    object MainLayout : Screen("main_layout")
    object  UiComponent : Screen("ui_component")

    object TextDetailScreen : Screen("text_detail_screen")
}