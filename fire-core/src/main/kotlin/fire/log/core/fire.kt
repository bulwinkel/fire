package fire.log.core

import fire.log.core.Intensity.VERBOSE

enum class Intensity(value: Int) {
  VERBOSE(2),
  DEBUG(3),
  INFO(4),
  WARN(5),
  ERROR(6),
  ASSERT(7)
}

inline fun v(tag: String? = null, t: Throwable? = null, message: ()->String) {
  log(intensity = VERBOSE, tag = tag ?: "", t = t, message = message())
}

fun log(intensity: Intensity, tag:String, t: Throwable? = null, message: String) {
  println("$intensity:$tag: $message")
}