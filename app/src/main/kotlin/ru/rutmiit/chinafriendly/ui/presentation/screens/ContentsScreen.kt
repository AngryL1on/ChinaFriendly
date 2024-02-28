package ru.rutmiit.chinafriendly.ui.presentation.screens

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign.Companion.Center
import androidx.compose.ui.text.style.TextAlign.Companion.Justify
import androidx.navigation.NavHostController
import ru.rutmiit.chinafriendly.R
import ru.rutmiit.chinafriendly.models.Topics
import ru.rutmiit.chinafriendly.ui.components.button.PrimaryNavigateButton
import ru.rutmiit.chinafriendly.ui.theme.LocalDimensions
import ru.rutmiit.chinafriendly.ui.theme.RegularText12
import ru.rutmiit.chinafriendly.ui.theme.RegularText16

@Composable
fun ContentsScreen(topics: Topics, navController: NavHostController) {
    TopicsContent(topics = topics, navController = navController)
}

@Composable
fun TopicsContent(topics: Topics, navController: NavHostController) {
    val dimensions = LocalDimensions.current

    LazyColumn {
        items(topics.topics) { topic ->
            PrimaryNavigateButton(
                textButton = topic.topicTitle.text,
                onButtonClick = { navController.navigate("topicDetails/${topic.topicTitle.id}") }
            )
            Spacer(modifier = Modifier.height(dimensions.verticalTiny))
        }
    }
}

@Composable
fun TopicDetailsScreen(topicId: String?, topics: Topics) {
    val dimensions = LocalDimensions.current
    val topic = topics.topics.firstOrNull { it.topicTitle.id.toString() == topicId }

    LazyColumn {
        if (topic != null) {
            items(topic.topicContents) { content ->
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = content.title,
                    fontWeight = FontWeight.Medium ,
                    textAlign = Center,
                    style = RegularText16
                )
                Spacer(modifier = Modifier.height(dimensions.defaultBeforeTopicSpacing))
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = content.content,
                    textAlign = Justify,
                    style = RegularText12
                )
                Spacer(modifier = Modifier.height(dimensions.defaultAfterTopicSpacing))
            }
        } else {
            item {
                Text(
                    text = stringResource(R.string.theme_not_found),
                    style = RegularText16
                )
            }
        }
    }
}
