
import javax.sound.sampled.Clip
import studiplayer.basic.TagReader

class TaggedFile(path: String) : SampledFile(path) {
    private var album: String? = null
   // override var duration: Long = 0

    private val tagMap: MutableMap<String, Any>? = TagReader.readTags(getPathname())

    init {
       // readAndStoreTags()
    }

//    private fun readAndStoreTags() {
//        tagMap.let {
//            if (it != null) {
//                title = (it.getOrDefault("title", null) as String?).toString()
//            }
//            if (it != null) {
//                author = (it.getOrDefault("author", null) as String?).toString()
//            }
//            if (it != null) {
//                clip = it.getOrDefault("clip", null) as Clip?
//            }
//            if (it != null) {
//                album = it.getOrDefault("album", null) as String?
//            }
//            duration = it?.get("duration") as Long
//            timeFormatter(duration)
//        }
//    }

    fun getAlbum(): String? {
        return album?.trim()
    }

//    fun getDuration(): Long {
//        return duration
//    }

    override fun toString(): String {
        return "${super.toString().trim()} - ${getAlbum()?.trim()} - ${timeFormatter(tagMap?.get("duration") as Long)}"
    }
}