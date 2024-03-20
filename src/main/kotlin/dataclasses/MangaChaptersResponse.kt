package dataclasses

data class MangaChaptersResponse (
    val result: String,
    val volumes: Map<String, MangaVolumeData>
)
