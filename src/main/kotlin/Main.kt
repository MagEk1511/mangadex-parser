import kotlinx.coroutines.runBlocking
import service.ImageDownloader
import service.MangaStructurizer
//import service.MangaStructurizer
import service.UrlParser
import service.output.ProgressBar

fun main(args: Array<String>) {
    val structurizer = MangaStructurizer()

    structurizer.createMangaFolder(args[0], args[1], args[2])
}