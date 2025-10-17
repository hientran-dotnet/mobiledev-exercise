package com.example.dataflownavigation

import android.graphics.Paint
import android.graphics.drawable.Icon
import android.icu.text.TimeZoneFormat
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun MainScreen(modifier: Modifier = Modifier, navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                color = Color(0XFFFFFFFF)
            )
            .statusBarsPadding()
    ){
        Column (
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ){
            Image(
                painter = painterResource(R.drawable.uth_logo),
                contentDescription = "UTH Logo",
                modifier = Modifier
                    .width(100.dp)
                    .height(68.dp)
            )
            Text(
                text = "Smart Tasks",
                fontFamily = FontFamily(Font(R.font.roboto_regular)),
                fontWeight = FontWeight.SemiBold,
                fontSize = 24.sp,
                color = Color(0XFF2196F3),
                modifier = Modifier
                    .padding(top = 16.dp)
            )
            Text(
                text = "Forgot Password?",
                fontFamily = FontFamily(Font(R.font.inter_regular)),
                fontWeight = FontWeight.SemiBold,
                fontSize = 20.sp,
                color = Color(0XFF1C2A3A),
                modifier = Modifier
                        .padding(top = 32.dp)
            )
            Text(
                text = "Enter your Email, we will send you a verification code.",
                fontFamily = FontFamily(Font(R.font.inter_regular)),
                fontWeight = FontWeight.Normal,
                fontSize = 14.sp,
                color = Color(0XFF6B7280),
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .padding(top = 8.dp)
            )

            var emailTextField by remember { mutableStateOf("") }

            TextField(

                value = emailTextField,
                onValueChange = { emailTextField = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 32.dp),
                shape = RoundedCornerShape(8.dp),
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color(0xFFFBF9F9),
                    unfocusedContainerColor = Color(0xFFFBF9F9),
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                ),
                placeholder = {Text("Your email")},
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Email,
                        contentDescription = "Email Icon",
                        tint = Color(0XFF9CA3AF)
                    )
                }
            )
            Button(
                onClick = {
                     navController.navigate("verify")
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 32.dp)
                    .height(48.dp),
                shape = RoundedCornerShape(42.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0XFF2196F3),
                    contentColor = Color.White
                )
            ) {
                Text(
                    text = "Send Code",
                    fontFamily = FontFamily(Font(R.font.inter_regular)),
                    fontWeight = FontWeight.Medium,
                    fontSize = 16.sp
                )
            }
        }
    }
}

