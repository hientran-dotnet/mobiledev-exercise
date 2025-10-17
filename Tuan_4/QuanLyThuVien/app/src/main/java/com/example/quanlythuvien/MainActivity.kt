package com.example.quanlythuvien

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.quanlythuvien.Route.AddStudentPage.route
import com.example.quanlythuvien.pages.AddStudentPage
import com.example.quanlythuvien.pages.StudentPage
import com.example.quanlythuvien.ui.theme.QuanLyThuVienTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            QuanLyThuVienTheme {
                MainScreen()
            }
        }
    }
}