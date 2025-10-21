package com.example.firebaseauthentication

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun MainScreen(modifier: Modifier = Modifier) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding()
    ){
        Button(
            onClick = {

            },
            colors = ButtonDefaults.buttonColors(Color(0XFF2196F3)),
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Text("Login with Gmail")
        }
    }

}