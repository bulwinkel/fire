package fire.log

import fire.log.Intensity.ASSERT
import fire.log.Intensity.DEBUG
import fire.log.Intensity.ERROR
import fire.log.Intensity.INFO
import fire.log.Intensity.VERBOSE
import fire.log.Intensity.WARN

enum class Intensity(val value: Int) {
  VERBOSE(2),
  DEBUG(3),
  INFO(4),
  WARN(5),
  ERROR(6),
  ASSERT(7)
}

//interface Log {
//  fun log(intensity: Intensity, tag:String, t: Throwable? = null, message: String)
//}

typealias Log = (intensity: Intensity, tag:String, t: Throwable?, message: String) -> Unit

private val logLevelSuffix: Map<Intensity, String> = mapOf(
    VERBOSE to "V",
    DEBUG to "D",
    INFO to "I",
    WARN to "W",
    ERROR to "E",
    ASSERT to "WFT"
)

val printLnLog : Log get() {
  return { intensity, tag, t, message ->
    //todo do something with the throwable
    println("${logLevelSuffix[intensity]}/$tag: $message")
  }
}

object Fire {

  var logs: List<Log> = emptyList()
    private set

  fun add(log: Log) {
    logs += log
  }

  fun removeAllLogs() {
    logs = emptyList()
  }

  inline fun v(tag: String? = null, t: Throwable? = null, message: ()->String) {
    log(intensity = VERBOSE, tag = tag ?: "", t = t, message = message)
  }

  inline fun d(tag: String? = null, t: Throwable? = null, message: ()->String) {
    log(intensity = DEBUG, tag = tag ?: "", t = t, message = message)
  }

  inline fun i(tag: String? = null, t: Throwable? = null, message: ()->String) {
    log(intensity = INFO, tag = tag ?: "", t = t, message = message)
  }

  inline fun w(tag: String? = null, t: Throwable? = null, message: ()->String) {
    log(intensity = WARN, tag = tag ?: "", t = t, message = message)
  }

  inline fun e(tag: String? = null, t: Throwable? = null, message: ()->String) {
    log(intensity = ERROR, tag = tag ?: "", t = t, message = message)
  }

  inline fun wtf(tag: String? = null, t: Throwable? = null, message: ()->String) {
    log(intensity = ASSERT, tag = tag ?: "", t = t, message = message)
  }

  inline fun log(intensity: Intensity, tag:String, t: Throwable? = null, message: ()->String) {
    if (logs.isNotEmpty()) {
      val msg = message()
      logs.forEach { it(intensity, tag, t, msg) }
    }
  }
}