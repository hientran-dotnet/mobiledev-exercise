package com.example.navigation_.ui.theme

import com.example.navigation_.R
import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.googlefonts.GoogleFont
import androidx.compose.ui.unit.sp

// Font regular
val PoppinsFont = FontFamily(
    Font(R.font.poppins_regular)
)

val SourceCodeProFont = FontFamily(
    Font(R.font.poppins_regular)
)

val FrontPoppins = TextStyle(
    fontFamily = PoppinsFont
)

val FontSourceCodePro = TextStyle(
    fontFamily = SourceCodeProFont
)


// Font poppins bold
val PoppinsBoldFont = FontFamily(
    Font(R.font.poppins_font)
)

val SourceCodeProPPBoldFont = FontFamily(
    Font(R.font.poppins_font)
)

val FrontPoppinsBold = TextStyle(
    fontFamily = PoppinsBoldFont
)

val FontBoldSourceCodePro = TextStyle(
    fontFamily = SourceCodeProPPBoldFont
)


// Font poppins bold
val Roboto_Bold = FontFamily(
    Font(R.font.roboto_bold)
)

val SrcRoboto_Bold = FontFamily(
    Font(R.font.roboto_bold)
)

val FontRoboto_Bold = TextStyle(
    fontFamily = Roboto_Bold
)

val FontSrcRoboto_Bold = TextStyle(
    fontFamily = SrcRoboto_Bold
)




// Set of Material typography styles to start with
val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    )
    /* Other default text styles to override
    titleLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),
    labelSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    )
    */
)