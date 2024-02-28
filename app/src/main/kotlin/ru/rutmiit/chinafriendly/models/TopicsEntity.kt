package ru.rutmiit.chinafriendly.models

import kotlinx.serialization.Serializable

@Serializable
data class Topic(
    val topicTitle: TopicTitle,
    val topicContents: List<TopicContent>
)

@Serializable
data class TopicTitle(
    val id: Int,
    val text: String,
    val contentIds: List<Int>
)

@Serializable
data class TopicContent(
    val id: Int,
    val title: String,
    val content: String
)

@Serializable
data class Topics(
    val topics: List<Topic>
)
