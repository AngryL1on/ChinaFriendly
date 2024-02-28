package ru.rutmiit.chinafriendly.ui.components.drawer

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import ru.rutmiit.chinafriendly.R
import ru.rutmiit.chinafriendly.ui.components.models.DrawerMenuItem
import ru.rutmiit.chinafriendly.ui.theme.ChinaFriendlyTheme
import ru.rutmiit.chinafriendly.ui.theme.LocalDimensions

@Composable
fun Drawer(
    items: List<DrawerMenuItem>,
    navController: NavController,
    scope: CoroutineScope,
    drawerState: DrawerState,
    modifier: Modifier = Modifier,
) {

    val selected by rememberSaveable { mutableIntStateOf(0) }

    val dimensions = LocalDimensions.current

    ModalDrawerSheet(
        modifier = modifier,
        drawerContainerColor = MaterialTheme.colorScheme.primary,
        drawerShape = RectangleShape
    ) {
        Spacer(modifier = Modifier.height(dimensions.verticalLarge))
        items.forEachIndexed { index, item ->

            DrawerItem(
                iconItem = item.icon,
                selected = selected == index,
                text = item.text,
                onItemClick = {
                    scope.launch {
                        navController.navigate(item.route) {
                            popUpTo(navController.graph.startDestinationId)
                            launchSingleTop = true
                        }
                        drawerState.close()
                    }
                }
            )
        }
    }
}

@Composable
@Preview
fun DrawerPreview() {
    val drawerItems = listOf(
        DrawerMenuItem(
            icon = R.drawable.ic_home,
            text = "Home",
            route = "home"
        )
    )

    ChinaFriendlyTheme {
        Drawer(
            items = drawerItems,
            navController = rememberNavController(),
            scope = rememberCoroutineScope(),
            drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
        )
    }
}
