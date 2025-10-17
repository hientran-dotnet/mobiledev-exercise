package com.example.thuchanhlop

import android.R.attr.clickable
import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.modifier.modifierLocalOf
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.thuchanhlop.Screen.MainLayout.route
import com.example.thuchanhlop.ui.theme.ThucHanhLopTheme

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ThucHanhLopTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) {
                    val navController = rememberNavController()

                    NavHost(
                        navController = navController,
                        startDestination = route
                    ){
                        composable(route = Screen.MainLayout.route){
                            MainLayout(navController = navController)
                        }
                        composable(route = Screen.LazyColumnLayout.route){
                            LazyColumnLayout(navController = navController)
                        }

                    }
                }
            }
        }
    }
}

@Composable
fun MainLayout(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp)
    ){
        Column (
            modifier = Modifier
                .fillMaxSize()
//                .padding(104.dp),
                .padding(),
            horizontalAlignment = CenterHorizontally
        ){
            Spacer(modifier = Modifier.height(102.dp))
            // ảnh
            Image(
                painter = painterResource(R.drawable.jpc_logo),
                contentDescription = "logo jetpack compose",
                modifier = Modifier
                    .fillMaxWidth()
                    .size(240.dp),
//                    .padding(128.dp),
                alignment = Alignment.TopCenter

            )

            // Cách dòng ảnh - tiêu đề
            Spacer(modifier = Modifier.height(56.dp))

            // tiêu đề
            Text(
                text = "Navigation",
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium,
            )

            // Cách dòng tiêu đề - mô tả
            Spacer(modifier = Modifier.height(16.dp))

            // mô tả
            Text(
                text = "is a framework that simplifies the implementation of navigation between different UI components (activities, fragments, or composables) in an app",
                textAlign = TextAlign.Center,
                fontSize = 14.sp,
                fontWeight = FontWeight.Normal,
            )

            // Cách dòng mô tả - nút
            Spacer(modifier = Modifier.weight(1f))


            // nút
            Button(
                onClick = {
                    navController.navigate(Screen.LazyColumnLayout.route)
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .navigationBarsPadding()
                    .imePadding(),
                shape = RoundedCornerShape(28.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF2196F3)
                )

            ){
                Text(
                    text = "PUSH",
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp
                )
            }
        }
    }
}

@Composable
fun LazyColumnLayout(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding()
//            .padding(24.dp)
    )   {
        Column(modifier = Modifier
            .fillMaxSize()
            ,
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.Start,
        ) {
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(24.dp),
            ) {
                Image(
                    painter = painterResource(R.drawable.img_arrow_back),
                    contentDescription = "back",
                    modifier = Modifier
                        .size(36.dp)
                        .clickable{
                            navController.popBackStack()
                        }
                )

                Text(
                    text = "Lazy Column",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Medium,
                    modifier = Modifier
                        .padding(start = 16.dp, top = 8.dp)
                )
            }
        }

    }
}