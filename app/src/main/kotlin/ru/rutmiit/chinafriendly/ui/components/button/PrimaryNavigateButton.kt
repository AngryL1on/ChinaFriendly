package ru.rutmiit.chinafriendly.ui.components.button

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.rutmiit.chinafriendly.ui.theme.ChinaFriendlyTheme
import ru.rutmiit.chinafriendly.ui.theme.LocalDimensions
import ru.rutmiit.chinafriendly.ui.theme.RegularText16

@Composable
fun PrimaryNavigateButton(
    textButton: String,
    onButtonClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val dimensions = LocalDimensions.current

    Button(
        modifier = modifier
            .height(dimensions.defaultButtonHeight)
            .fillMaxWidth(),
        shape = RoundedCornerShape(dimensions.defaultCornerRadius),
        contentPadding = PaddingValues(
            horizontal = dimensions.horizontalMedium,
            vertical = dimensions.verticalMTiny
        ),
        colors = ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.colorScheme.primary,
            contentColor = MaterialTheme.colorScheme.onPrimary
        ),
        onClick = remember { onButtonClick }
    ) {
        Text(
            text = textButton,
            style = RegularText16
        )
        Spacer(Modifier.weight(1f))
        Icon(
            imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
            contentDescription = null
        )
    }
}

@Composable
@Preview
fun PrimaryNavigateButtonPreview() {
    ChinaFriendlyTheme {
        Column(
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            PrimaryNavigateButton(
                textButton = "Menu",
                onButtonClick = { /* Do nothing */ }
            )

            PrimaryNavigateButton(
                modifier = Modifier.width(150.dp),
                textButton = "Menu",
                onButtonClick = { /* Do nothing */ }
            )
        }
    }
}