package service

import com.google.gson.Gson
import dataclasses.ChapterResponse
import dataclasses.MangaChaptersResponse
import dataclasses.MangaResponse
import java.net.URL


class UrlParser {
    private var baseUrl: String = "https://api.mangadex.org/"
    private var gsonManager = Gson()

    fun getChapterById(id: String): ChapterResponse {
        return gsonManager.fromJson(URL("${baseUrl}at-home/server/$id").readText(), ChapterResponse::class.java)
    }

    fun getChaptersByMangaId(id: String, lang: String): MangaChaptersResponse {
        return gsonManager.fromJson(
            URL("$baseUrl/manga/$id/aggregate?translatedLanguage%5B%5D=$lang").readText(), MangaChaptersResponse::class.java
        )
    }

    fun getMangaById(id: String): MangaResponse {
        return gsonManager.fromJson(URL("$baseUrl/manga/$id").readText(), MangaResponse::class.java)
    }

    fun getMangaTitle(id: String): String {
        val response = getMangaById(id)
        return response.data.attributes.title.en
    }
}