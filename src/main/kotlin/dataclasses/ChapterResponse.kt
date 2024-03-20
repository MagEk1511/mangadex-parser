package dataclasses

data class ChapterResponse(
    val result: String,
    val baseUrl: String,
    val chapter: Chapter,
)