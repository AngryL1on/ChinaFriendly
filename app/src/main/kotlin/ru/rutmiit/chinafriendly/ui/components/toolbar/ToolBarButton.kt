package ru.rutmiit.chinafriendly.ui.components.toolbar

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import ru.rutmiit.chinafriendly.R
import ru.rutmiit.chinafriendly.ui.theme.YellowPrimary

@Composable
fun ToolBarButton(
    modifier: Modifier = Modifier,
    @DrawableRes icon: Int,
    onClick: () -> Unit
) {
    IconButton(
        modifier = modifier,
        onClick = onClick
    ) {
        Icon(
            modifier = Modifier.fillMaxSize(),
            imageVector = ImageVector.vectorResource(id = icon),
            contentDescription = null,
            tint = YellowPrimary
        )
    }
}

@Composable
@Preview(showBackground = true)
fun ToolBarButtonPreview() {
    ToolBarButton(
        onClick = { /* Do nothing */ },
        icon = R.drawable.ic_menu
    )
}