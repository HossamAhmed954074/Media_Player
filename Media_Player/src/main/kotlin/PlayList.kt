//import java.io.BufferedReader
//import java.io.FileReader
//import java.io.FileWriter
//import java.io.IOException
//import java.util.LinkedList
//
//class PlayList {
//    private val audioFiles: MutableList<AudioFile> = LinkedList()
//    private var current: Int = 0
//
//    constructor() {
//        // No-arg constructor
//    }
//
//    constructor(path: String) {
//        this
//        loadFromM3U(path)
//    }
//
//    fun getList(): List<AudioFile> {
//        return audioFiles
//    }
//
//    fun add(file: AudioFile) {
//        audioFiles.add(file)
//    }
//
//    fun remove(file: AudioFile) {
//        audioFiles.remove(file)
//    }
//
//    fun size(): Int {
//        return audioFiles.size
//    }
//
//    fun getCurrent(): Int {
//        return current
//    }
//
//    fun setCurrent(position: Int) {
//        current = position
//    }
//
//    fun isEmpty(): Boolean {
//        return audioFiles.isEmpty()
//    }
//
//    fun currentAudioFile(): AudioFile? {
//        return if (audioFiles.isEmpty() || current < 0 || current >= audioFiles.size) {
//            null
//        } else {
//            audioFiles[current]
//        }
//    }
//
//    fun nextSong() {
//        if (audioFiles.isEmpty()) {
//            current = 0
//        } else {
//            current = (current + 1) % audioFiles.size
//        }
//    }
//
//    fun saveAsM3U(pathname: String) {
//        try {
//            FileWriter(pathname).use { writer ->
//                for (file in audioFiles) {
//                    writer.write(file.pathname + "\n")
//                }
//            }
//        } catch (e: IOException) {
//            e.printStackTrace()
//        }
//    }
//
//    fun loadFromM3U(path: String) {
//        audioFiles.clear()
//
//        try {
//            BufferedReader(FileReader(path)).use { reader ->
//                var line: String?
//                while (reader.readLine().also { line = it } != null) {
//                    audioFiles.add(AudioFileFactory.createAudioFile(line!!))
//                }
//            }
//        } catch (e: IOException) {
//            e.printStackTrace()
//        }
//    }
//}