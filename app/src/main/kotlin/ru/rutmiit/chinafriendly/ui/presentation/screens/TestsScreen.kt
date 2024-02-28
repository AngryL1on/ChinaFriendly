package ru.rutmiit.chinafriendly.ui.presentation.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import ru.rutmiit.chinafriendly.R
import ru.rutmiit.chinafriendly.ui.components.button.PrimaryButton
import ru.rutmiit.chinafriendly.ui.theme.ChinaFriendlyTheme
import ru.rutmiit.chinafriendly.ui.theme.LocalDimensions

@Composable
fun TestsScreen(
    modifier:Modifier = Modifier
){
    val dimensions = LocalDimensions.current

    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(dimensions.verticalTiny)
    ) {
        PrimaryButton(
            textButton = "Культура",
            iconLeft = R.drawable.ic_test,
            onButtonClick = { /* Do nothing */ }
        )
        PrimaryButton(
            textButton = "Обычаи",
            iconLeft = R.drawable.ic_test,
            onButtonClick = { /* Do nothing */ }
        )
        PrimaryButton(
            textButton = "Этикет",
            iconLeft = R.drawable.ic_test,
            onButtonClick = { /* Do nothing */ }
        )
    }
}

@Composable
@Preview
fun TestsScreenPreview() {
    ChinaFriendlyTheme { TestsScreen() }
}
