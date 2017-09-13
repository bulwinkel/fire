package fire.log

import fire.log.Intensity.ASSERT
import fire.log.Intensity.DEBUG
import fire.log.Intensity.ERROR
import fire.log.Intensity.INFO
import fire.log.Intensity.VERBOSE
import fire.log.Intensity.WARN
import org.junit.Before
import org.junit.Test
import kotlin.test.assertTrue

fun Fire.assertCorrectIntensity(correctIntensity: Intensity) {
  add { intensity, _, _, _ ->
    println("correctIntensity = ${correctIntensity}, intensity = ${intensity}")
    assertTrue { intensity == correctIntensity }
  }
}

class FireTests {

  @Before fun removeLogs() {
    Fire.removeAllLogs()
  }

  @Test fun `should add log and remove logs`() {
    assertTrue("logs size should be 0") { Fire.logs.isEmpty() }
    for (i in 1..100) {
      Fire.add(printLnLog)
      assertTrue("logs size doesn't match index") { Fire.logs.size == i }
    }
    Fire.removeAllLogs()
    assertTrue("logs size should be 0") { Fire.logs.isEmpty() }
  }

  //region: valid intensity

  @Test fun `v should call log with correct intensity`() {
    Fire.assertCorrectIntensity(VERBOSE)
    Fire.v { "ignored" }
  }

  @Test fun `d should call log with correct intensity`() {
    Fire.assertCorrectIntensity(DEBUG)
    Fire.d { "ignored" }
  }

  @Test fun `i should call log with correct intensity`() {
    Fire.assertCorrectIntensity(INFO)
    Fire.i { "ignored" }
  }

  @Test fun `w should call log with correct intensity`() {
    Fire.assertCorrectIntensity(WARN)
    Fire.w { "ignored" }
  }

  @Test fun `e should call log with correct intensity`() {
    Fire.assertCorrectIntensity(ERROR)
    Fire.e { "ignored" }
  }

  @Test fun `wtf should call log with correct intensity`() {
    Fire.assertCorrectIntensity(ASSERT)
    Fire.wtf { "ignored" }
  }

  //endregion


}