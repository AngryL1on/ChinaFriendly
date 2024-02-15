package ru.rutmiit.chinafriendly.ui.components.models

import android.annotation.SuppressLint
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.runtime.Stable

@Stable
@SuppressLint("SupportAnnotationUsage")
data class DrawerMenuItem(
    @DrawableRes val icon: Int,
    @StringRes val text: String,
    val route: String
)
