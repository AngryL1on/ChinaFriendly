package ru.rutmiit.chinafriendly.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp

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

val RegularTextStyle = TextStyle(
    fontWeight = FontWeight.Normal,
    platformStyle = PlatformTextStyle(
        includeFontPadding = false
    )
)

val RegularText12 = RegularTextStyle.copy(
    fontSize = 12.sp,
    lineHeight = 17.sp,
)
val RegularText16 = RegularTextStyle.copy(
    fontSize = 16.sp,
    textAlign = TextAlign.Center,
    lineHeight = 21.sp,
)
val RegularText18 = RegularTextStyle.copy(
    fontSize = 18.sp,
    lineHeight = 23.sp,
)
val RegularText20 = RegularTextStyle.copy(
    fontSize = 20.sp,
    lineHeight = 25.sp,
)
