package service

import service.output.ProgressBar
import java.nio.file.Files
import java.nio.file.Paths

class MangaStructurizer {

    private val parser = UrlParser()
    private val downloader = ImageDownloader()


    fun createMangaFolder(id: String, outputDir: String, translationLang: String) {
        val mangaChaptersResponse = parser.getChaptersByMangaId(id, translationLang)
        val mangaTitle = parser.getMangaTitle(id)
        val mangaDir = Paths.get("$outputDir/${mangaTitle}")

        val progressBar = ProgressBar()

        if (mangaChaptersResponse.result != "ok") {
            throw Exception("Wrong id")
        }

        if (!Files.exists(mangaDir)) {
            Files.createDirectory(mangaDir)
        }

        mangaChaptersResponse.volumes.forEach { volume ->
            var idx = 1
            val title = "Downloading: ${mangaTitle} volume ${volume.value.volume}}."

            progressBar.updateProgress(title, 0, volume.value.count)
            volume.value.chapters.forEach {chapter ->
                val chapterPath = "$outputDir/${mangaTitle}/${volume.value.volume}/${chapter.value.chapter}"
                val chapterDir = Paths.get(chapterPath)

                if (!Files.exists(chapterDir)) {
                    Files.createDirectories(chapterDir)
                }

                Files.createDirectories(Paths.get(chapterPath))

                downloader.downloadChapter(parser.getChapterById(chapter.value.id), "$chapterPath/")
                progressBar.updateProgress(title, idx++, volume.value.count)
            }
        }
    }
}