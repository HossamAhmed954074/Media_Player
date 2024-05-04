import studiplayer.basic.WavParamReader
import java.io.File

class WavFile(pathname: String?) : SampledFile(pathname!!) {
    override var duration: Long = 0
        private set

    init {
        readAndSetDurationFromFile()
    }

    @Throws(AssertionError::class)
    fun readAndSetDurationFromFile() {
        duration = if (super.getPathname()?.let { File(it).canRead() } == true) {
            WavParamReader.readParams(super.getPathname())
            val frameRate: Double = WavParamReader.getFrameRate().toDouble()
            val numberOfFrames: Double = WavParamReader.getNumberOfFrames().toDouble()
            computeDuration(numberOfFrames, frameRate)
        } else {
            throw AssertionError()
        }
    }

//    override fun toString(): String {
//        return super.author.trim { it <= ' ' } + " - " + super.title.trim { it <= ' ' } + " - " + timeFormatter(duration)
//    }

    companion object {
        fun computeDuration(frameRate: Double, numberOfFrames: Double): Long {
            return (frameRate / numberOfFrames * 1000000).toLong()
        }
    }
}