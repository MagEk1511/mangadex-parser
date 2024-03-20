package service

import dataclasses.ChapterResponse
import java.net.URL
import java.nio.file.Files
import java.nio.file.Paths
import java.nio.file.StandardCopyOption

class ImageDownloader {


    fun downloadChapter(chapter: ChapterResponse, dest: String) {
        val urls = makeDownloadUrl(chapter)
        urls.forEachIndexed { idx, url ->
            val imagePath = Paths.get("$dest/$idx.png")
            if (!Files.exists(imagePath)) {
                Files.copy(URL(url).openStream(), imagePath, StandardCopyOption.REPLACE_EXISTING)
            }
        }
    }

    private fun makeDownloadUrl(chapterResponse: ChapterResponse): Array<String> {
        val result = Array(chapterResponse.chapter.data.size) { "" }
        chapterResponse.chapter.data.forEachIndexed { idx, element ->
            result[idx] = chapterResponse.baseUrl + "/data/" + chapterResponse.chapter.hash + "/" + element
        }
        return result
    }
}