package ru.rutmiit.chinafriendly.data

import kotlinx.serialization.json.Json
import ru.rutmiit.chinafriendly.models.Topics

private val json = Json { ignoreUnknownKeys = true }

fun parseTopics(jsonString: String): Topics {
    return json.decodeFromString(Topics.serializer(), jsonString)
}
