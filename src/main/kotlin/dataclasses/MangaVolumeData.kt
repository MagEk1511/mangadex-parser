package dataclasses

data class MangaVolumeData (
    val volume: String,
    val count: Int,
    val chapters: Map<String, MangaVolumeChapter>
)
