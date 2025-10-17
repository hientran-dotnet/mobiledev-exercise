package com.example.quanlythuvien.pages

import android.net.Uri
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
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.quanlythuvien.models.Student

@Composable
fun AddStudentPage(modifier: Modifier = Modifier, navController: NavController) {
    var studentList :List<Student>
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
                text = "Thêm Sinh Viên",
                fontWeight = FontWeight.Bold,
                fontSize = 26.sp
            )

            var studentId by remember { mutableStateOf("") }
            TextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 24.dp, end = 24.dp, bottom = 16.dp)
                    .clip(
                        shape = RoundedCornerShape(16.dp)
                    )
                ,
                value = studentId,
                onValueChange = {
                    studentId = it
                },
                label = { Text("Mã sinh viên") }
            )

            var studentName by remember { mutableStateOf("") }
            TextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 24.dp, end = 24.dp, bottom = 16.dp)
                    .clip(
                        shape = RoundedCornerShape(16.dp)
                    )
                ,
                value = studentName,
                onValueChange = {
                    studentName = it
                },
                label = { Text("Tên sinh viên") }
            )
            var studentEmail by remember { mutableStateOf("") }
            TextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 24.dp, end = 24.dp, bottom = 16.dp)
                    .clip(
                        shape = RoundedCornerShape(16.dp)
                    )
                ,
                value = studentEmail,
                onValueChange = {
                    studentEmail = it
                },
                label = { Text("Email") }
            )

            if(studentId.isEmpty() || studentName.isEmpty() || studentEmail.isEmpty()) {
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 24.dp, end = 24.dp, bottom = 16.dp),
                    text = "Vui lòng điền đầy đủ thông tin",
                    color = Color.Red,
                    fontSize = 16.sp,
                    textAlign = TextAlign.Center
                )
            }
            else{
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




                    }
                ) {
                    Text(
                        text = "Thêm",
                        fontSize = 20.sp,
                    )
                }
            }


        }
    }
}

fun AddStudent() {

}

