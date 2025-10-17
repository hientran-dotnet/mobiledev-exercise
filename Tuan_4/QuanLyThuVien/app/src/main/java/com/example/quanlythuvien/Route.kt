package com.example.quanlythuvien

sealed class Route(val route: String){
    object MainScreen: Route("main_screen")
    object StudentPage: Route("student_page")
    object AddStudentPage: Route("add_student_page")
}