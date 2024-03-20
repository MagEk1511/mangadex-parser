package dataclasses

data class MangaResponse(
    val result: String,
    val response: String,
    val data: MangaData,
)
