package com.example.navdataflow

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@Composable
fun VerifyCode(
    modifier: Modifier = Modifier,
    forgotPasswordViewModel: ForgotPasswordViewModel,
    navController: NavHostController
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
        Text(
            text = "SmartTasks",
            fontSize = 22.sp,
            color = Color(0xFF1E88E5),
            fontFamily = FontFamily(Font(R.font.inter_regular))
        )
        Text(
            text = "Verify Code",
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp,
            fontFamily = FontFamily(Font(R.font.inter_regular))
        )
        Text(
            "Enter the the code \n" +
                    "we just sent you on your registered Email",
            textAlign = TextAlign.Center,
            color = Color.Gray,
            fontSize = 14.sp,
            fontFamily = FontFamily(Font(R.font.inter_regular))
        )

        Spacer(Modifier.height(10.dp))

        var otpValue = rememberSaveable { mutableStateOf("") }
        OtpInputField(
            otp = otpValue ,
            count = 6,
            mask = true,
        )

        Button(
            onClick = {
                forgotPasswordViewModel.setVerifyCode(otpValue.value)
                navController.navigate("create_new_password")
            },
            colors = ButtonDefaults.buttonColors(Color(0XFF2196F3)),
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Text(
                text = "Next",
                fontFamily = FontFamily(Font(R.font.inter_regular))
            )
        }
    }
}