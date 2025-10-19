package com.example.quanlythuvien

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.quanlythuvien.pages.AddStudentPage
import com.example.quanlythuvien.pages.BookPage
import com.example.quanlythuvien.pages.HomePage
import com.example.quanlythuvien.pages.StudentPage
import com.example.quanlythuvien.viewmodels.StudentViewModel


@Composable
fun MainScreen(modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    val navItemList = listOf(
        NavItem("Trang chủ", Icons.Filled.Home),
        NavItem("DS Sách", Icons.Filled.Book),
        NavItem("Sinh viên", Icons.Filled.Person)
    )

    // Danh sách các route hiển thị bottom bar
    val routesWithBottomBar = listOf("home", "books", "students")
    val showBottomBar = currentRoute in routesWithBottomBar

    val studentViewModel : StudentViewModel = viewModel()

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = {
            if (showBottomBar) {
                NavigationBar {
                    navItemList.forEachIndexed { index, item ->
                        val route = when(index) {
                            0 -> "home"
                            1 -> "books"
                            2 -> "students"
                            else -> "home"
                        }

                        NavigationBarItem(
                            selected = currentRoute == route,
                            onClick = {
                                navController.navigate(route) {
                                    popUpTo("home") { saveState = true }
                                    launchSingleTop = true
                                    restoreState = true
                                }
                            },
                            icon = {
                                Icon(imageVector = item.icon, contentDescription = "Icon")
                            },
                            label = {
                                Text(text = item.label)
                            }
                        )
                    }
                }
            }
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = "home",
            modifier = Modifier.padding(innerPadding)
        ) {
            composable("home") { HomePage(modifier = modifier) }
            composable("books") { BookPage(modifier = modifier) }
            composable("students") { StudentPage(navController = navController, modifier = modifier, studentViewModel = studentViewModel) }
            composable("addStudent") { AddStudentPage(navController = navController, modifier = modifier, studentViewModel = studentViewModel) }
        }
    }
}