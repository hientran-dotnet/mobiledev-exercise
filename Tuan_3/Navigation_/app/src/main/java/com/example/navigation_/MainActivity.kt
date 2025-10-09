package com.example.navigation_

import android.annotation.SuppressLint
import android.graphics.Paint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.navigation_.ui.theme.FontRoboto_Bold
import com.example.navigation_.ui.theme.FrontPoppins
import com.example.navigation_.ui.theme.FrontPoppinsBold
import com.example.navigation_.ui.theme.Navigation_Theme


class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Navigation_Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) {
                    val navController = rememberNavController()

                    NavHost(
                        navController = navController,
                        startDestination = Screen.MainLayout.route
                    ){
                        composable(route = Screen.MainLayout.route){
                            MainLayout(navController = navController)
                        }
                        composable(route = Screen.UiComponent.route){
                            UiComponentScreen()
                        }
                    }
                }
            }
        }
    }
}


//@Preview(
//    showBackground = true,
//    showSystemUi = true,
//    device = "id:pixel_6_pro",
//    name = "Pixel 6 Pro"
//)
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
            horizontalAlignment = Alignment.CenterHorizontally
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
                text = "Jetpack Compose",
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium,
                style = FrontPoppinsBold,
            )

            // Cách dòng tiêu đề - mô tả
            Spacer(modifier = Modifier.height(16.dp))

            // mô tả
            Text(
                text = "Jetpack Compose is a modern UI toolkit for building native Android applications using a declarative programming approach.",
                textAlign = TextAlign.Center,
                fontSize = 14.sp,
                fontWeight = FontWeight.Normal,
                style = FrontPoppins,
            )

            // Cách dòng mô tả - nút
            Spacer(modifier = Modifier.weight(1f))


            // nút
            Button(
                onClick = {
                    navController.navigate(Screen.UiComponent.route)
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
                    text = "I'm Ready",
                    textAlign = TextAlign.Center,
                    style = FontRoboto_Bold,
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp
                )
            }
        }
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true,
    device = "id:pixel_6_pro",
    name = "Pixel 6 Pro"
)
@Composable
fun MainLayoutPreview() {
    // Tạo một NavController giả cho Preview
    val navController = rememberNavController()
    MainLayout(navController = navController)
}
