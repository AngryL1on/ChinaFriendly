package ru.rutmiit.chinafriendly.ui.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import ru.rutmiit.chinafriendly.R
import ru.rutmiit.chinafriendly.ui.components.toolbar.ToolBar
import ru.rutmiit.chinafriendly.ui.theme.ChinaFriendlyTheme
import ru.rutmiit.chinafriendly.ui.theme.YellowPrimary

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ChinaFriendlyTheme {
                Scaffold(
                    topBar = {
                        ToolBar(
                            modifier = Modifier,
                            textToolBar = "China Friendly",
                            iconLeft = R.drawable.ic_menu,
                            onLeftIconClick = { /* TODO: Change when added Drawer */ }
                        )
                    },
                    content = { paddings ->
                        Box(modifier = Modifier.padding(paddings)) {
                            Surface(
                                modifier = Modifier.fillMaxSize(),
                                color = YellowPrimary
                            ) {
                                Greeting("Android")
                            }
                        }
                    }
                )
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ChinaFriendlyTheme {
        Greeting("Android")
    }
}
