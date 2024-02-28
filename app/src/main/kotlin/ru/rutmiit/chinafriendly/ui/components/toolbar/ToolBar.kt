package ru.rutmiit.chinafriendly.ui.components.toolbar

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import ru.rutmiit.chinafriendly.R
import ru.rutmiit.chinafriendly.ui.theme.ChinaFriendlyTheme
import ru.rutmiit.chinafriendly.ui.theme.LocalDimensions
import ru.rutmiit.chinafriendly.ui.theme.RegularText20

@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun ToolBar(
    textToolBar: String,
    @DrawableRes iconLeft: Int?,
    modifier: Modifier = Modifier,
    onLeftIconClick: () -> Unit
) {
    val dimensions = LocalDimensions.current

    CenterAlignedTopAppBar(
        modifier = modifier.height(dimensions.defaultToolbarSize),
        windowInsets = WindowInsets(
            top = dimensions.verticalTiny,
            bottom = dimensions.verticalTiny,
            left = dimensions.horizontalXTiny,
            right = dimensions.horizontalXTiny
        ),
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.primary,
            navigationIconContentColor = MaterialTheme.colorScheme.onPrimary
        ),
        title = {
            Row(
                modifier = Modifier.fillMaxHeight(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    modifier = Modifier,
                    text = textToolBar,
                    style = RegularText20.copy(color = MaterialTheme.colorScheme.onPrimary)
                )
            }
        },
        navigationIcon = {
            iconLeft?.let {
                ToolBarButton(
                    modifier = Modifier
                        .fillMaxHeight()
                        .aspectRatio(1f),
                    icon = it,
                    onClick = onLeftIconClick
                )
            }
        }
    )
}

@Composable
@Preview(showBackground = true)
fun ToolBarPreview() {
    ChinaFriendlyTheme {
        MaterialTheme {
            Column {
                ToolBar(
                    modifier = Modifier,
                    textToolBar = "China Friendly",
                    iconLeft = R.drawable.ic_menu,
                    onLeftIconClick = { /* Do nothing */ }
                )
            }
        }
    }
}
