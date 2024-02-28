package ru.rutmiit.chinafriendly.ui.components.button

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.rutmiit.chinafriendly.R
import ru.rutmiit.chinafriendly.ui.theme.ChinaFriendlyTheme
import ru.rutmiit.chinafriendly.ui.theme.LocalDimensions
import ru.rutmiit.chinafriendly.ui.theme.RegularText20

@Composable
fun PrimaryButton(
    textButton: String,
    @DrawableRes iconLeft: Int?,
    onButtonClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val dimensions = LocalDimensions.current

    Button(
        modifier = modifier
            .height(dimensions.defaultButtonHeight)
            .fillMaxWidth(),
        shape = RoundedCornerShape(dimensions.defaultCornerRadius),
        colors = ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.colorScheme.primary,
            contentColor = MaterialTheme.colorScheme.onPrimary
        ),
        onClick = onButtonClick
    ) {
        iconLeft?.let {
            Icon(
                modifier = Modifier.fillMaxHeight(),
                imageVector = ImageVector.vectorResource(id = it),
                contentDescription = null
            )
        }
        Spacer(Modifier.weight(1f))
        Text(
            text = textButton,
            style = RegularText20
        )
    }
}

@Composable
@Preview
fun PrimaryButtonPreview() {
    ChinaFriendlyTheme {
        Column(
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            PrimaryButton(
                textButton = "Menu",
                iconLeft = R.drawable.ic_menu,
                onButtonClick = { /* Do nothing */ }
            )

            PrimaryButton(
                modifier = Modifier.width(150.dp),
                textButton = "Menu",
                iconLeft = R.drawable.ic_menu,
                onButtonClick = { /* Do nothing */ }
            )
        }
    }
}
