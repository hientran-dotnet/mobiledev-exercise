package com.example.uthlibrarymanagement

sealed class Screen(val route: String){
    object MainLayout : Screen("main_layout")
    object BooksList : Screen(route = "books_list")
    object StudentsList : Screen(route = "students_list")

}