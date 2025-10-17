package com.example.quanlythuvien.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun StudentPage(navController: NavController, modifier: Modifier = Modifier) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding()
            .verticalScroll(rememberScrollState())
    ){
        Column(
            modifier = Modifier
                .fillMaxSize()
        ){

            // Tiêu đề chính
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(24.dp)

                ,
                textAlign = TextAlign.Center,
                text = "Quản lý Sinh viên",
                fontWeight = FontWeight.Bold,
                fontSize = 26.sp
            )


            // Tiêu đề phụ
            Text(
                text = "Sinh viên",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 24.dp, top = 24.dp)
                ,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp
            )

            // Ô nhập + Nút
            Row(
                modifier = Modifier
                    .padding(24.dp)
                    .fillMaxWidth(),
            ){
                var textState by remember { mutableStateOf("") }
                TextField(
                    modifier = Modifier
                        .weight(1f)
                        .clip(
                            shape = RoundedCornerShape(16.dp)
                        )
                    ,
                    value = textState,
                    onValueChange = {
                        textState = it
                    },
                    placeholder = { Text(text = "Tên sinh viên") }
                )

                Spacer(modifier = Modifier.weight(0.05f))

                Button(
                    modifier = Modifier
                        .padding(start = 5.dp)
                        .weight(0.6f)
                        .height(55.dp)
                    ,
                    shape = RoundedCornerShape(8.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xffCD1818)),
                    onClick = {
                        // TODO:
                    }
                ) {
                    Text(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(top = 10.dp),
                        text = "Tìm kiếm",
                        fontSize = 18.sp,
                    )
                }
            }

            // Tiêu đề phụ
            Text(
                text = "Danh sách sinh viên",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 24.dp, bottom = 24.dp)
                ,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )

            Box(
                modifier = Modifier
                    .padding(start = 24.dp, bottom = 24.dp, end = 24.dp)
                    .fillMaxWidth()
                    .height(180.dp)
                    .background(
                        shape = RoundedCornerShape(16.dp),
                        color = Color(0xffd8d8d8)
                    )
                ,
            ){
                // LazyColumn
                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp)
                    ,
                    horizontalAlignment = Alignment.CenterHorizontally
                ){
                    items(20) { index ->
                        Text(text = "Item: $index")
                    }
                }
            }
            // Nút
            Button(
                modifier = Modifier
                    .padding(start = 130.dp, end = 130.dp, bottom = 24.dp)
                    .fillMaxSize()
                    .size(50.dp)
                ,
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xffCD1818)),
                shape = RoundedCornerShape(8.dp),
                onClick = {
                    navController.navigate("addStudent")
                }
            ) {
                Text(
                    text = "Thêm",
                    fontSize = 20.sp,
                )
            }
            // Bottom nav

        }
    }
}