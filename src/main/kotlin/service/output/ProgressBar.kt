package service.output

class ProgressBar {
    fun updateProgress(title: String, progress: Int, total: Int) {
        clearScreen()

        val width = 50
        val percent = (progress * 100.0 / total).toInt()
        val numChars = (width * (progress / total.toDouble())).toInt()
        val bar = StringBuilder()

        val progressString = progress.toString()
        val totalString = total.toString()
        val formattedProgress = progressString.padStart(2) + "/" + totalString.padEnd(2)

        bar.append("$formattedProgress [")
        for (i in 0..<width) {
            if (i < numChars) {
                bar.append("=")
            } else if (i == numChars) {
                bar.append(">")
            } else {
                bar.append(" ")
            }
        }
        bar.append("] $percent%")
        print("\n$title\n")
        print("\r$bar")
        if (progress == total) {
            println()
        }
    }

    private fun clearScreen() {
        print("\u001b[H\u001b[2J")
    }
}