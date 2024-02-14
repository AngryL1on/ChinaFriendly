package ru.rutmiit.chinafriendly.ui.theme

import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

/**
 * This date class contains the dimensions used in the project.
 *
 * To make the code easier to understand, one size can be entered twice,
 * but have a different name depending on its demandingness
 */
data class Dimensions(
    val verticalTiny: Dp = 10.dp,
    val horizontalXTiny: Dp = 5.dp,
    val defaultBorderWidth: Dp = 1.dp,
    val defaultButtonHeight: Dp = 65.dp,
    val defaultCornerRadius: Dp = 10.dp,
    val defaultToolbarSize: Dp = 50.dp,
)

val LocalDimensions = compositionLocalOf { Dimensions() }
