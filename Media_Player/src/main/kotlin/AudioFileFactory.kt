//object AudioFileFactory {
//    @Throws(RuntimeException::class)
//    fun createAudioFile(path: String): AudioFile {
//        return when {
//            path.toLowerCase().endsWith(".wav") -> WavFile(path)
//            path.toLowerCase().endsWith(".ogg") || path.toLowerCase().endsWith(".mp3") -> TaggedFile(path)
//            else -> throw RuntimeException("Unknown suffix for AudioFile \"$path\"")
//        }
//    }
//}