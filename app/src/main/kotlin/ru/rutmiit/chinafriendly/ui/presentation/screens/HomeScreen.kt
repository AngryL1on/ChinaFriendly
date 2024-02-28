package ru.rutmiit.chinafriendly.ui.presentation.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import ru.rutmiit.chinafriendly.R
import ru.rutmiit.chinafriendly.ui.components.button.PrimaryButton
import ru.rutmiit.chinafriendly.ui.theme.LocalDimensions

@Composable
fun HomeScreen(
    navController: NavController,
    modifier: Modifier = Modifier
) {
    val dimensions = LocalDimensions.current

    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(dimensions.verticalTiny)
    ) {
        PrimaryButton(
            textButton = "Contents",
            iconLeft = R.drawable.ic_contents,
            onButtonClick = { navController.navigate("contents") }
        )
        PrimaryButton(
            textButton = "Tests",
            iconLeft = R.drawable.ic_test,
            onButtonClick = { navController.navigate("tests") }
        )
        PrimaryButton(
            textButton = "Translator",
            iconLeft = R.drawable.ic_translate,
            onButtonClick = { navController.navigate("translator") }
        )
        PrimaryButton(
            textButton = "Currency Exchange",
            iconLeft = R.drawable.ic_currency_exchange,
            onButtonClick = { navController.navigate("currencyExchange") }
        )
    }
}

@Composable
@Preview
fun HomeScreenPreview() {
    HomeScreen(navController = rememberNavController())
}
