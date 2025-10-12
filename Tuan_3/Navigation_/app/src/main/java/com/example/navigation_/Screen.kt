package com.example.navigation_

sealed class Screen(val route: String){
    object MainLayout : Screen("main_layout")
    object  UiComponent : Screen("ui_component")

    object TextDetailScreen : Screen("text_detail_screen")

    object ImageScreen : Screen("image_detail_screen")

    object TextFieldScreen : Screen("text_field_detail_screen")

    object PasswordFieldScreen : Screen("password_field_detail_screen")

    object ColumnScreen : Screen("column_detail_screen")

    object RowScreen : Screen("row_detail_screen")

}