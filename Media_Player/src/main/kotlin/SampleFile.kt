import studiplayer.basic.BasicPlayer

abstract class SampledFile(path: String = "") : AudioFile(path) {

    override fun play() {
        BasicPlayer.play(getPathname())
    }

    override fun togglePause() {
        BasicPlayer.togglePause()
    }

    override fun stop() {
        BasicPlayer.stop()
    }

    override fun formatDuration(): String {
        return timeFormatter(duration) ?: ""
    }

    override fun formatPosition(): String {
        return "00:00"
    }

    open val duration: Long
        get() = clip?.microsecondLength ?: 0
}