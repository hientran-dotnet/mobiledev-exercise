package com.example.ui_component

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
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ui_component.ui.theme.UI_ComponentTheme

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                MainLayout()
            }
        }
    }
}

@Preview(
    name = "Pixel 6 Pro Preview",
    showBackground = true,
    showSystemUi = true,
    device = "id:pixel_6_pro"
)

@Composable
fun MainLayout(){
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(30.dp)
    ){


        // Khung layout chính
        Column (
            modifier = Modifier,
//            horizontalAlignment = Alignment.CenterHorizontally
        ){
            // Khung info của người dùng
//            Row(
//                modifier = Modifier,
//                horizontalArrangement = Arrangement.End
//            ){
//
//            }
            Column (
                modifier = Modifier
                    .padding()
                    .fillMaxWidth(),
                    horizontalAlignment = Alignment.End
            ){
                // Tên người dùng
                Text(
                    text = "Trần Minh Hiền",
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp,
                )
                // Mã người dùng
                Text(
                    text = "08325000978",
                    textAlign = TextAlign.End,
                    fontWeight = FontWeight.Light,
                )
            }

            Image(
                painter = painterResource(R.drawable.jetpackcompose),
                contentDescription = "Jetpack Compose Logo",
                modifier = Modifier
                    .fillMaxWidth()
                    .size(240.dp)
            )
            Spacer(modifier = Modifier.height(120.dp))
            Text(
                text = "",
                fontSize = 36.sp,
            )
//            Spacer(modifier = Modifier.height(1.dp))
            // Text
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = "Jetpack Compose",
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp
            )

            Spacer(modifier = Modifier.height(12.dp))

            // Description
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = "Jetpack Compose is a modern UI toolkit for building native Android applications using a declarative programming approach.",
                textAlign = TextAlign.Center,
                color = Color.Gray,
                fontSize = 14.sp
            )

            Button(
                onClick = {
                },
                modifier = Modifier
//                    .align(Alignment.BottomCenter)
                    .fillMaxWidth()
                    .safeDrawingPadding()
                    .height(56.dp),

                shape = RoundedCornerShape(28.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF2196F3)
                )
            ) {
                Text("I'm ready")
            }
        }


    }
}
