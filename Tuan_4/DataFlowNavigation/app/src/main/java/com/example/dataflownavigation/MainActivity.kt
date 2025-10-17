package com.example.dataflownavigation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHost
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.dataflownavigation.ui.theme.DataFlowNavigationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DataFlowNavigationTheme {
                val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = "main",
                    builder = {
                        composable("main"){
                            MainScreen(navController = navController)
                        }
                        composable("verify"){
                            VerifyScreen()
                        }
                        composable("create_new_password"){
                            CreateNewPasswordScreen()
                        }
                        composable ("confirm_screen"){
                            ConfirmScreen()
                        }
                    }
                )
            }
        }
    }
}
