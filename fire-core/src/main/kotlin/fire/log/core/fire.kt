package fire.log.core

import fire.log.core.Intensity.ASSERT
import fire.log.core.Intensity.DEBUG
import fire.log.core.Intensity.ERROR
import fire.log.core.Intensity.INFO
import fire.log.core.Intensity.VERBOSE
import fire.log.core.Intensity.WARN

enum class Intensity(value: Int) {
  VERBOSE(2),
  DEBUG(3),
  INFO(4),
  WARN(5),
  ERROR(6),
  ASSERT(7)
}

object Fire {

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
    println("$intensity:$tag: ${message()}")
  }
}