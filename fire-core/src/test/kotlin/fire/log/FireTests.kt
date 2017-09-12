package fire.log

import fire.log.Intensity.VERBOSE
import org.junit.Before
import org.junit.Test
import kotlin.test.assertTrue

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

  @Test fun `v should call log with correct intensity`() {

    Fire.add { intensity, tag, t, message ->
      assertTrue { intensity == VERBOSE }
    }
    Fire.v { "message" }
  }
}