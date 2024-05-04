import java.io.File
import javax.sound.sampled.Clip

abstract class AudioFile {
    private var pathname = ""
    private var filename: String = ""
    private var author: String = ""
    private var title: String = ""
    protected var clip: Clip? = null

    constructor() {
        this.pathname = ""
        this.filename = ""
        this.author = ""
        this.title = ""
    }

    private fun isWindows(): Boolean {
        return System.getProperty("os.name").toLowerCase().contains("win")
    }

    constructor(path: String) {
        parsePathname(path)
        parseFilename(this.filename)
    }

    fun getPathname(): String? {
        return if (File(pathname).canRead()) {
            File(pathname).toPath().toString()
        } else {
            null
        }
    }

    fun getFilename(): String {
        return filename
    }

    fun parseFilename(filename: String) {
        val separatorIndex = filename.indexOf(" - ")

        if (separatorIndex != -1) {
            author = filename.substring(0, separatorIndex).trim()

            val extensionIndex = filename.lastIndexOf('.')
            if (extensionIndex != -1) {
                title = filename.substring(separatorIndex + 3, extensionIndex).trim()
            } else {
                title = filename.substring(separatorIndex + 3).trim()
            }
        } else {
            val extensionIndex = filename.lastIndexOf('.')

            if (extensionIndex != -1) {
                title = filename.substring(0, extensionIndex).trim()
            } else {
                title = filename.trim()
            }
            author = ""
        }
    }

    fun getAuthor(): String {
        return author
    }

    fun getTitle(): String {
        return title
    }

    override fun toString(): String {
        return "$author - $title"
    }

    fun parsePathname(path: String) {
        val separat = if (isWindows()) "\\\\" else "/"
        this.pathname = path.trim().replace("[\\\\/]+".toRegex(), separat)
        val lastIndex = this.pathname.lastIndexOf(if (isWindows()) "\\" else "/")
        if (lastIndex != -1) {
            filename = this.pathname.substring(lastIndex + 1).trim()
        } else {
            filename = this.pathname.trim()
        }
    }

    companion object {
        fun timeFormatter(timeInMicroSeconds: Long): String {
            val totalSecond = (timeInMicroSeconds / 1000) / 1000
            val seconds = totalSecond % 60
            val totalMinute = totalSecond / 60
            val minutes = totalMinute % 60
            return String.format("%02d:%02d", minutes, seconds)
        }
    }

    abstract fun play()
    abstract fun togglePause()
    abstract fun stop()
    abstract fun formatDuration(): String
    abstract fun formatPosition(): String
}