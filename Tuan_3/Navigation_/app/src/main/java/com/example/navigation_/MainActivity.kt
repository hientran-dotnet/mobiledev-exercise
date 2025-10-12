package com.example.navigation_

import android.annotation.SuppressLint
import android.graphics.Paint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.snapping.SnapPosition
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
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.adaptive.currentWindowAdaptiveInfo
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.LinkAnnotation
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextLinkStyles
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withLink
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import androidx.room.util.copy
import androidx.window.core.layout.WindowWidthSizeClass
import coil.compose.AsyncImage
import com.example.navigation_.Screen.MainLayout.route
import com.example.navigation_.ui.theme.FontRoboto_Bold
import com.example.navigation_.ui.theme.FontRoboto_regular
import com.example.navigation_.ui.theme.FontSourceCodePro
import com.example.navigation_.ui.theme.FrontPoppins
import com.example.navigation_.ui.theme.FrontPoppinsBold
import com.example.navigation_.ui.theme.Navigation_Theme
import com.example.navigation_.ui.theme.Roboto_Bold


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
                            UiComponentScreen(navController = navController)
                        }
                        composable (route = Screen.TextDetailScreen.route){
                            TextDetailScreen(navController = navController)
                        }
                        composable(route = Screen.ImageScreen.route){
                            ImageScreen(navController = navController)
                        }
                        composable(route = Screen.TextFieldScreen.route){
                            TextFieldScreen()
                        }
                        composable(route = Screen.PasswordFieldScreen.route){
                            PasswordFieldScreen()
                        }
                        composable(route = Screen.ColumnScreen.route){
                            ColumnScreen()
                        }
                        composable(route = Screen.RowScreen.route){
                            RowScreen()
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

@Composable
fun UiComponentScreen(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
//            .padding(24.dp),
            .statusBarsPadding()
            .padding(10.dp),

        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .navigationBarsPadding(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Tiêu đề chính
            Text(
                text = "UI Component List",
                modifier = Modifier
                    .fillMaxWidth(),
                textAlign = TextAlign.Center,
                style = FrontPoppinsBold,
                fontWeight = FontWeight.SemiBold,
                fontSize = 24.sp,
                color = Color(0xFF2196F3)
            )

            // Cách dòng tiêu đề tiêu đề phụ
//            Spacer(modifier = Modifier.height(22.dp))

            Box(
                modifier = Modifier
                    .fillMaxWidth(),
                contentAlignment = Alignment.TopCenter
            ){
                Column(
                    // Tiêu đề phụ
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalAlignment = CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ){
                    Text(
                        text = "Display",
                        modifier = Modifier
                            .fillMaxWidth(),
                        textAlign = TextAlign.Start,
                        style = FontRoboto_Bold,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 16.sp
                    )
                    // Cách dòng giữa tiêu đề phụ và nội dung
//                    Spacer(modifier = Modifier.height(12.dp))

                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(71.dp)
                            .background(
                                Color(0x4D2196F3),
                                shape = RoundedCornerShape(10.dp)
                            )
                            .clickable{
                                navController.navigate(Screen.TextDetailScreen.route)
                            }
                    ){
                        Column(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(horizontal = 16.dp, vertical = 10.dp),
                            horizontalAlignment = CenterHorizontally
                        ){
                            // Tiêu đề phụ
                            Text(
                                text = "Text",
                                modifier = Modifier
                                    .fillMaxWidth(),
//                                    .padding(16.dp),
                                textAlign = TextAlign.Start,
                                style = FontRoboto_Bold,
                                fontWeight = FontWeight.Bold,
                                fontSize = 18.sp,
                            )

                            // Nội dung
                            Text(
                                text = "Displays text",
                                modifier = Modifier
                                    .fillMaxWidth(),
                                textAlign = TextAlign.Start,
                                style = FontRoboto_regular,
//                                fontWeight = FontWeight.Bold,
                                fontSize = 18.sp
                            )
                        }
                    }

//                    Spacer(modifier = Modifier.height(14.dp))

                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(71.dp)
                            .background(
                                Color(0x4D2196F3),
                                shape = RoundedCornerShape(10.dp)
                            )
                            .clickable{
                                navController.navigate(Screen.ImageScreen.route)
                            }
                    ){
                        Column(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(horizontal = 16.dp, vertical = 10.dp),
                            horizontalAlignment = CenterHorizontally
                        ){
                            // Tiêu đề phụ
                            Text(
                                text = "Image",
                                modifier = Modifier
                                    .fillMaxWidth(),
//                                    .padding(16.dp),
                                textAlign = TextAlign.Start,
                                style = FontRoboto_Bold,
                                fontWeight = FontWeight.Bold,
                                fontSize = 18.sp,
                            )

                            // Nội dung
                            Text(
                                text = "Displays an image",
                                modifier = Modifier
                                    .fillMaxWidth(),
                                textAlign = TextAlign.Start,
                                style = FontRoboto_regular,
                                fontSize = 18.sp
                            )
                        }
                    }


                    Text(
                        text = "Input",
                        modifier = Modifier
                            .fillMaxWidth(),
                        textAlign = TextAlign.Start,
                        style = FontRoboto_Bold,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 16.sp
                    )


                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(71.dp)
                            .background(
                                Color(0x4D2196F3),
                                shape = RoundedCornerShape(10.dp)
                            )
                            .clickable{
                                navController.navigate(Screen.TextFieldScreen.route)
                            }
                    ){
                        Column(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(horizontal = 16.dp, vertical = 10.dp),
                            horizontalAlignment = CenterHorizontally
                        ){
                            // Tiêu đề phụ
                            Text(
                                text = "TextField",
                                modifier = Modifier
                                    .fillMaxWidth(),
//                                    .padding(16.dp),
                                textAlign = TextAlign.Start,
                                style = FontRoboto_Bold,
                                fontWeight = FontWeight.Bold,
                                fontSize = 18.sp,
                            )

                            // Nội dung
                            Text(
                                text = "Input field for text",
                                modifier = Modifier
                                    .fillMaxWidth(),
                                textAlign = TextAlign.Start,
                                style = FontRoboto_regular,
//                                fontWeight = FontWeight.Bold,
                                fontSize = 18.sp
                            )
                        }
                    }

//                    Spacer(modifier = Modifier.height(10.dp))

                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(71.dp)
                            .background(
                                Color(0x4D2196F3),
                                shape = RoundedCornerShape(10.dp)
                            )
                            .clickable{
                                navController.navigate(Screen.PasswordFieldScreen.route)
                            }
                    ){
                        Column(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(horizontal = 16.dp, vertical = 10.dp),
                            horizontalAlignment = CenterHorizontally
                        ){
                            // Tiêu đề phụ
                            Text(
                                text = "PasswordField",
                                modifier = Modifier
                                    .fillMaxWidth(),
//                                    .padding(16.dp),
                                textAlign = TextAlign.Start,
                                style = FontRoboto_Bold,
                                fontWeight = FontWeight.Bold,
                                fontSize = 18.sp,
                            )

                            // Nội dung
                            Text(
                                text = "Input field for password",
                                modifier = Modifier
                                    .fillMaxWidth(),
                                textAlign = TextAlign.Start,
                                style = FontRoboto_regular,
//                                fontWeight = FontWeight.Bold,
                                fontSize = 18.sp
                            )
                        }
                    }

                    // Layout
//                    Spacer(modifier = Modifier.height(20.dp))

                    Text(
                        text = "Layout",
                        modifier = Modifier
                            .fillMaxWidth(),
                        textAlign = TextAlign.Start,
                        style = FontRoboto_Bold,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 16.sp
                    )

//                    Spacer(modifier = Modifier.height(10.dp))

                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(71.dp)
                            .background(
                                Color(0x4D2196F3),
                                shape = RoundedCornerShape(10.dp)
                            )
                            .clickable{
                                navController.navigate(Screen.ColumnScreen.route)
                            }
                    ){
                        Column(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(horizontal = 16.dp, vertical = 10.dp),
                            horizontalAlignment = CenterHorizontally
                        ){
                            // Tiêu đề phụ
                            Text(
                                text = "Column",
                                modifier = Modifier
                                    .fillMaxWidth(),
//                                    .padding(16.dp),
                                textAlign = TextAlign.Start,
                                style = FontRoboto_Bold,
                                fontWeight = FontWeight.Bold,
                                fontSize = 18.sp,
                            )

                            // Nội dung
                            Text(
                                text = "Arranges element vertically",
                                modifier = Modifier
                                    .fillMaxWidth(),
                                textAlign = TextAlign.Start,
                                style = FontRoboto_regular,
//                                fontWeight = FontWeight.Bold,
                                fontSize = 18.sp
                            )
                        }
                    }

//                    Spacer(modifier = Modifier.height(10.dp))

                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(71.dp)
                            .background(
                                Color(0x4D2196F3),
                                shape = RoundedCornerShape(10.dp)
                            )
                            .clickable{
                                navController.navigate(Screen.RowScreen.route)
                            }
                    ){
                        Column(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(horizontal = 16.dp, vertical = 10.dp),
                            horizontalAlignment = CenterHorizontally
                        ){
                            // Tiêu đề phụ
                            Text(
                                text = "Row",
                                modifier = Modifier
                                    .fillMaxWidth(),
//                                    .padding(16.dp),
                                textAlign = TextAlign.Start,
                                style = FontRoboto_Bold,
                                fontWeight = FontWeight.Bold,
                                fontSize = 18.sp,
                            )

                            // Nội dung
                            Text(
                                text = "Arranges elements horizontally",
                                modifier = Modifier
                                    .fillMaxWidth(),
                                textAlign = TextAlign.Start,
                                style = FontRoboto_regular,
//                                fontWeight = FontWeight.Bold,
                                fontSize = 18.sp
                            )
                        }
                    }

//                  Spacer(modifier = Modifier.weight(1f))

                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(71.dp)
                            .background(
                                Color(0x4DE80400),
                                shape = RoundedCornerShape(10.dp)
                            )
                            .clickable{

                            }
                    ){
                        Column(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(horizontal = 16.dp, vertical = 10.dp),
                            horizontalAlignment = CenterHorizontally
                        ){
                            // Tiêu đề phụ
                            Text(
                                text = "Tự tìm hiểu",
                                modifier = Modifier
                                    .fillMaxWidth(),
//                                    .padding(16.dp),
                                textAlign = TextAlign.Start,
                                style = FontRoboto_Bold,
                                fontWeight = FontWeight.Bold,
                                fontSize = 18.sp,
                            )

                            // Nội dung
                            Text(
                                text = "Tìm ra tất cả các thành phần UI Cơ bản",
                                modifier = Modifier
                                    .fillMaxWidth(),
                                textAlign = TextAlign.Start,
                                style = FontRoboto_regular,
//                                fontWeight = FontWeight.Bold,
                                fontSize = 18.sp
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun TextDetailScreen(navController: NavController){

    Box(
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding()
//            .padding(24.dp)
        ,
    ) {
        Row (
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ){

            // Nút quay lại
            Icon(
                painter = painterResource(R.drawable.baseline_arrow_back_ios_24),
                contentDescription = null,
                tint = Color(0xFF2196F3),
                modifier = Modifier
                    .padding(start = 24.dp)
                    .clickable(
                        onClick = {
                            navController.popBackStack()
                        }
                    )
            )

            Text(
                text = "Text Component",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 70.dp)
                ,
                textAlign = TextAlign.Start,
                style = FrontPoppinsBold,
                fontWeight = FontWeight.SemiBold,
                fontSize = 20.sp,
                color = Color(0xFF2196F3)
            )
        }

        Column(
            modifier = Modifier
//                .fillMaxWidth()
                .fillMaxSize()
            ,
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = CenterHorizontally
        ){


            Text(
                buildAnnotatedString {
                    withStyle(
                        style = SpanStyle(
                            color = Color.Black,
                            fontSize = 40.sp,
                            fontWeight = FontWeight.Normal,
                        )
                    ){
                        append("The ")
                    }
                    withStyle(
                        style = SpanStyle(
                            color = Color.Black,
                            fontSize = 40.sp,
                            textDecoration = TextDecoration.LineThrough
                        )
                    ){
                        append("quick")
                    }

                    withStyle(
                        style = SpanStyle(
                            color = Color(0xFFFF5722),
                            fontSize = 80.sp,

                        )
                    ){
                        append(" B")
                    }

                    withStyle(
                        style = SpanStyle(
                            color = Color(0xFFFF5722),
                            fontSize = 40.sp,

                        )
                    ){
                        append("rown\n\n")
                    }

                    withStyle(
                        style = SpanStyle(
                            color = Color.Black,
                            fontSize = 40.sp
                        )
                    ){
                        append("fox ")
                    }

                    withStyle(
                        style = SpanStyle(
                            color = Color.Black,
                            fontSize = 40.sp,
                            letterSpacing = 12.sp
                        )
                    ){
                        append("jumps ")
                    }

                    withStyle(
                        style = SpanStyle(
                            color = Color.Black,
                            fontSize = 40.sp,
                            fontStyle = FontStyle.Italic,
                            fontWeight = FontWeight.Bold

                        )
                    ){
                        append("over\n\n")
                    }

                    withStyle(
                        style = SpanStyle(
                            color = Color.Black,
                            fontSize = 40.sp,
                            textDecoration = TextDecoration.Underline

                        )
                    ){
                        append("the")
                    }


                    withStyle(
                        style = SpanStyle(
                            color = Color.Black,
                            fontSize = 40.sp,
                            fontFamily = FontFamily(Font(R.font.dacingscript))
                        )
                    ){
                        append(" lazy")
                    }

                    withStyle(
                        style = SpanStyle(
                            color = Color.Black,
                            fontSize = 40.sp,
//                            fontFamily = FontFamily(Font(R.font.dacingscript))
                        )
                    ){
                        append(" dog")
                    }

                }
            )
        }

    }


}

@Composable
fun ImageScreen(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding(),
        contentAlignment = Alignment.Center,
    ) {


        Column(
            modifier = Modifier
                .fillMaxSize(),
        ) {
            Row (
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically
            ){

                // Nút quay lại
                Icon(
                    painter = painterResource(R.drawable.baseline_arrow_back_ios_24),
                    contentDescription = null,
                    tint = Color(0xFF2196F3),
                    modifier = Modifier
                        .padding(start = 24.dp)
                        .clickable(
                            onClick = {
                                navController.popBackStack()
                            }
                        )
                )

                Text(
                    text = "Images Component",
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 70.dp)
                    ,
                    textAlign = TextAlign.Start,
                    style = FrontPoppinsBold,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 20.sp,
                    color = Color(0xFF2196F3)
                )
            }

            AsyncImage(
                model = "https://clc.ut.edu.vn/wp-content/uploads/2025/03/TN_00033-2048x1365.jpg",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(24.dp)
                    .clip(shape = RoundedCornerShape(16.dp))
                ,
                contentDescription = "Hình ảnh đại học giao thông vận tải"
            )

            Text(
                text = buildAnnotatedString {
                    withLink(
                        LinkAnnotation.Url(
                            "https://clc.ut.edu.vn/wp-content/uploads/2025/03/TN_00033-2048x1365.jpg",
                        )
                    ) {
                        append("https://clc.ut.edu.vn/wp-content/uploads/2025/03/TN_00033-2048x1365.jpg")
                    }
                },
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp),
            )

            Image(
                painter = painterResource(R.drawable.uthmoi),
                contentDescription = "Hình ảnh đại học giao thông vận tải",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(24.dp)
                    .clip(shape = RoundedCornerShape(16.dp))
            )

            Text(
                text = "In app",
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp),
            )
        }
    }
}


@Composable
fun TextFieldScreen(){
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text("Đây là trang input text component")
    }
}

@Composable
fun PasswordFieldScreen(){
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text("Đây là trang input password component!")
    }
}

@Composable
fun ColumnScreen(){
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text("Đây là trang column layout!")
    }
}

@Composable
fun RowScreen(){
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text("Đây là trang row layout!")
    }
}

//@Composable
//fun responsivePadding(
//    compact: Dp = 16.dp,
//    medium: Dp = 24.dp,
//    expanded: Dp = 32.dp
//): Dp {
//    val windowSizeClass = currentWindowAdaptiveInfo().windowSizeClass
//
//    return when (windowSizeClass.windowWidthSizeClass) {
//        WindowWidthSizeClass.COMPACT -> compact
//        WindowWidthSizeClass.MEDIUM -> medium
//        WindowWidthSizeClass.EXPANDED -> expanded
//        else -> medium
//    }
//}