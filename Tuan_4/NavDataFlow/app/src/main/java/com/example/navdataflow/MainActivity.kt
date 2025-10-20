package com.example.navdataflow

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.navdataflow.ui.theme.NavDataFlowTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NavDataFlowTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    val navController = rememberNavController()
                    val startDestination = "main"
                    val forgotPasswordViewModel: ForgotPasswordViewModel = viewModel()
                    NavHost(
                        navController = navController,
                        startDestination = startDestination,
                        modifier = Modifier.padding(innerPadding)
                    ) {
                        composable(route = "main") {
                            MainScreen(
                                navController = navController,
                                forgotPasswordViewModel = forgotPasswordViewModel
                            )
                        }
                        composable (route = "verify_code") {
                            VerifyCode(
                                navController = navController,
                                forgotPasswordViewModel = forgotPasswordViewModel
                            )
                        }
                        composable(route = "create_new_password") {
                            CreateNewPassword(
                                navController = navController,
                                forgotPasswordViewModel = forgotPasswordViewModel
                            )
                        }
                        composable(route = "confirm_screen") {
                            ConfirmScreen(
                                navController = navController,
                                forgotPasswordViewModel = forgotPasswordViewModel
                            )
                        }
                    }
                }
            }
        }
    }
}