package com.adormantsakthi.watchfacemobileapp.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.adormantsakthi.watchfacemobileapp.R

val LangarFontFamily = FontFamily(
    Font(R.font.langar_regular, FontWeight.Normal)
)

val AbhayaLibreFontFamily = FontFamily(
    Font(R.font.abhayalibre_regular, FontWeight.Normal),
    Font(R.font.abhayalibre_semibold, FontWeight.SemiBold),
    Font(R.font.abhayalibre_extrabold, FontWeight.ExtraBold)
)

// Set of Material typography styles to start with
val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    ),
    titleMedium = TextStyle(
        fontFamily = LangarFontFamily,
        fontSize = 24.sp
    ),
    displaySmall = TextStyle(
        fontFamily = AbhayaLibreFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp
    ),

    displayMedium = TextStyle(
        fontFamily = AbhayaLibreFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 32.sp
    )
)