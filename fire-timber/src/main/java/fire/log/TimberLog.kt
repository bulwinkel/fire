package fire.log

import timber.log.Timber

val timberLog : Log get() {
  return { intensity: Intensity, tag: String, t: Throwable?, message: String ->
    if (tag.isNotBlank()) {
      Timber.tag(tag).log(intensity.value, t, message)
    } else {
      Timber.log(intensity.value, t, message)
    }
  }
}