package service.logging

import java.io.File
import java.nio.file.Files
import java.nio.file.Paths
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class Logger: Observer {
    init {
        Files.createDirectory(Paths.get("./logs"))
    }

    private val logsDir = "./logs"
    private val file = File(logsDir)

    private val dateFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss")

    override fun update(message: String, status: Status) {
        file.appendText("${LocalDateTime.now().format(dateFormat)} $status : $message")
    }
}