package ru.rutmiit.chinafriendly.ui.components.drawer

import androidx.annotation.DrawableRes
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import ru.rutmiit.chinafriendly.R
import ru.rutmiit.chinafriendly.ui.theme.LocalDimensions
import ru.rutmiit.chinafriendly.ui.theme.AdditionalRed
import ru.rutmiit.chinafriendly.ui.theme.RegularText18
import ru.rutmiit.chinafriendly.ui.theme.AdditionalYellow

@Composable
fun DrawerItem(
    text: String,
    @DrawableRes iconItem: Int,
    selected: Boolean,
    modifier: Modifier = Modifier,
    onItemClick: () -> Unit
) {
    val dimensions = LocalDimensions.current

    NavigationDrawerItem (
        modifier = modifier,
        label = {
            Text(
                text = text,
                style = RegularText18
            )
        },
        icon = {
            Icon(
                imageVector = ImageVector.vectorResource(id = iconItem),
                contentDescription = text
            )
        },
        shape = RoundedCornerShape(dimensions.defaultCornerRadius),
        colors = NavigationDrawerItemDefaults.colors(
            selectedContainerColor = AdditionalRed,
            unselectedContainerColor = AdditionalRed,
            selectedTextColor = AdditionalYellow,
            unselectedTextColor = AdditionalYellow,
            selectedIconColor = AdditionalYellow,
            unselectedIconColor = AdditionalYellow
        ),
        selected = selected,
        onClick = onItemClick,
    )
}

@Composable
@Preview
fun DrawerItemPreview() {
    DrawerItem(
        text = "Menu",
        iconItem = R.drawable.ic_menu,
        selected = false,
        onItemClick = { /* Do nothing */ }
    )
}
