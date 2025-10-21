package com.example.navdataflow

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@Composable
fun MainScreen(
    modifier: Modifier = Modifier,
    forgotPasswordViewModel: ForgotPasswordViewModel,
    navController: NavHostController
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .statusBarsPadding()

    ){
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 32.dp, vertical = 24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp, Alignment.CenterVertically)
        ){
            Image(
                painter = painterResource(R.drawable.logo_uth),
                contentDescription = "logo Uth",
                modifier = Modifier
                    .fillMaxWidth(0.35f)
            )
            Text("SmartTasks", fontSize = 22.sp, color = Color(0xFF1E88E5))
            Text("Forget Password?", fontWeight = FontWeight.Bold, fontSize = 18.sp)
            Text(
                "Enter your Email, we will send you a verification code.",
                textAlign = TextAlign.Center,
                color = Color.Gray,
                fontSize = 14.sp
            )

            val regex = remember { Regex("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}\$") }

            OutlinedTextField(
                value = forgotPasswordViewModel._email,
                onValueChange = {
                    forgotPasswordViewModel.setEmail(it)
                },
                label = { Text("Your Email") },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Email,
                        contentDescription = "Email Icon"
                    )
                },
                shape = RoundedCornerShape(8.dp),
                modifier = Modifier.fillMaxWidth()
            )

            var isValid: Boolean
            if(!forgotPasswordViewModel._email.isEmpty()) {
                if (regex.matches(forgotPasswordViewModel._email)) {
                    isValid = true
                    Button(
                        onClick = {
                            navController.navigate("verify_code")
                        },
                        enabled = true,
                        colors = ButtonDefaults.buttonColors(Color(0XFF2196F3)),
                        modifier = Modifier
                            .fillMaxWidth()
                    ) {
                        Text("Next")
                    }
                } else {
                    Text(
                        text = "Please enter a valid email address",
                        color = Color.Red,
                        fontSize = 12.sp,
                        textAlign = TextAlign.Start,
                        modifier = Modifier
                            .fillMaxWidth(1f)
                    )
                }
            }else{
                isValid = false
                Button(
                    onClick = {

                    },
                    enabled = false,
                    colors = ButtonDefaults.buttonColors(Color(0XFF2196F3)),
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    Text("Next")
                }
            }
        }
    }
}