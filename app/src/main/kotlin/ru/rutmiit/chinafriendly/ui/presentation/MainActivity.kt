package ru.rutmiit.chinafriendly.ui.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import kotlinx.coroutines.launch
import ru.rutmiit.chinafriendly.R
import ru.rutmiit.chinafriendly.data.parseTopics
import ru.rutmiit.chinafriendly.ui.components.drawer.Drawer
import ru.rutmiit.chinafriendly.ui.components.models.DrawerMenuItem
import ru.rutmiit.chinafriendly.ui.components.toolbar.ToolBar
import ru.rutmiit.chinafriendly.ui.presentation.screens.ContentsScreen
import ru.rutmiit.chinafriendly.ui.presentation.screens.CurrencyExchangeScreen
import ru.rutmiit.chinafriendly.ui.presentation.screens.HomeScreen
import ru.rutmiit.chinafriendly.ui.presentation.screens.TestsScreen
import ru.rutmiit.chinafriendly.ui.presentation.screens.TopicDetailsScreen
import ru.rutmiit.chinafriendly.ui.presentation.screens.TranslatorScreen
import ru.rutmiit.chinafriendly.ui.theme.ChinaFriendlyTheme
import ru.rutmiit.chinafriendly.ui.theme.LocalDimensions

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ChinaFriendlyTheme {
                val navController = rememberNavController()
                val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
                val scope = rememberCoroutineScope()
                val dimensions = LocalDimensions.current

                val context = LocalContext.current
                val jsonString = context.resources.openRawResource(R.raw.topics).bufferedReader()
                    .use { it.readText() }
                val topics = parseTopics(jsonString)


                ModalNavigationDrawer(
                    drawerState = drawerState,
                    drawerContent = {
                        Drawer(
                            items = listOf(
                                DrawerMenuItem(
                                    icon = R.drawable.ic_home,
                                    text = getString(R.string.home_item),
                                    route = "home"
                                ),
                                DrawerMenuItem(
                                    icon = R.drawable.ic_test,
                                    text = getString(R.string.tests_item),
                                    route = "tests"
                                ),
                                DrawerMenuItem(
                                    icon = R.drawable.ic_contents,
                                    text = getString(R.string.contents_item),
                                    route = "contents"
                                ),
                                DrawerMenuItem(
                                    icon = R.drawable.ic_translate,
                                    text = getString(R.string.translator_item),
                                    route = "translator"
                                ),
                                DrawerMenuItem(
                                    icon = R.drawable.ic_currency_exchange,
                                    text = getString(R.string.currency_exchange_item),
                                    route = "currencyExchange"
                                )
                            ),
                            navController = navController,
                            scope = scope,
                            drawerState = drawerState
                        )
                    }
                ) {
                    Scaffold(
                        topBar = {
                            ToolBar(
                                modifier = Modifier,
                                textToolBar = "China Friendly",
                                iconLeft = R.drawable.ic_menu,
                                onLeftIconClick = { scope.launch { drawerState.open() } }
                            )
                        },
                        containerColor = MaterialTheme.colorScheme.surface,
                        content = { paddings ->
                            Surface(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .padding(paddings) // This padding is provided by Scaffold and is commonly used to pad AppBar and other UI elements
                                    .padding(
                                        horizontal = dimensions.horizontalTiny,
                                        vertical = dimensions.verticalTiny
                                    ),
                                color = MaterialTheme.colorScheme.surface
                            ) {
                                NavHost(navController, startDestination = "home") {
                                    composable("home") { HomeScreen(navController) }
                                    composable("tests") { TestsScreen() }
                                    composable("contents") { ContentsScreen(topics, navController) }
                                    composable(
                                        route = "topicDetails/{topicId}",
                                        arguments = listOf(
                                            navArgument("topicId") {type = NavType.StringType }
                                        )
                                    ) { backStackEntry ->
                                        val topicId = backStackEntry.arguments?.getString("topicId")
                                        TopicDetailsScreen(topicId = topicId, topics = topics)
                                    }
                                    composable("translator") { TranslatorScreen() }
                                    composable("currencyExchange") { CurrencyExchangeScreen() }
                                }
                            }
                        }
                    )
                }
            }
        }
    }
}
