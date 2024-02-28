package ru.rutmiit.chinafriendly.ui.theme

import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

/**
 * This data class contains the dimensions used in the project.
 *
 * To make the code easier to understand, one size can be entered twice,
 * but have a different name depending on its demandingness
 */
data class Dimensions(
    val verticalMTiny: Dp = 8.dp,
    val verticalTiny: Dp = 10.dp,
    val verticalLarge: Dp = 35.dp,
    val horizontalXTiny: Dp = 5.dp,
    val horizontalTiny: Dp = 10.dp,
    val horizontalMedium: Dp = 16.dp,
    val defaultBorderWidth: Dp = 1.dp,
    val defaultCornerRadius: Dp = 10.dp,
    val defaultHeightDrawer: Dp = 30.dp,
    val defaultBeforeTopicSpacing: Dp = 30.dp,
    val defaultToolbarSize: Dp = 50.dp,
    val defaultButtonHeight: Dp = 65.dp,
    val defaultAfterTopicSpacing: Dp = 75.dp
)

val LocalDimensions = compositionLocalOf { Dimensions() }
