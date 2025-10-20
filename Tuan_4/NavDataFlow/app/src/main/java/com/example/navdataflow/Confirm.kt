package com.example.navdataflow

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.material.icons.filled.Person
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
fun ConfirmScreen(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    forgotPasswordViewModel: ForgotPasswordViewModel
) {
    Image(
        painter = painterResource(R.drawable.arrowback_icon),
        contentDescription = "back button",
        Modifier
            .padding(24.dp)
            .size(40.dp)
            .clickable {
                navController.popBackStack()
            }
    )

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
        Text("Confirm", fontWeight = FontWeight.Bold, fontSize = 18.sp)
        Text(
            "We are here to help you!",
            textAlign = TextAlign.Center,
            color = Color.Gray,
            fontSize = 14.sp
        )

        OutlinedTextField(
            value = forgotPasswordViewModel._email,
            onValueChange = { forgotPasswordViewModel.setEmail(it) },

            label = { Text("Email") },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Person,
                    contentDescription = "Email Icon"
                )
            },
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = forgotPasswordViewModel._verifyCode,
            onValueChange = { forgotPasswordViewModel.setVerifyCode(it)},
            label = { Text("Verify code") },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.MailOutline,
                    contentDescription = "Verify Code Icon"
                )
            },
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = forgotPasswordViewModel._password,
            onValueChange = { forgotPasswordViewModel.setPassword(it)},
            label = { Text("Password") },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Lock,
                    contentDescription = "Password Icon"
                )
            },
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier.fillMaxWidth()
        )

        Button(
            onClick = {
                navController.navigate("main")
            },
            colors = ButtonDefaults.buttonColors(Color(0XFF2196F3)),
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Text("Next")
        }
    }
}