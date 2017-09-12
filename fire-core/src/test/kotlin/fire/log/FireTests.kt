package fire.log

import org.junit.Before
import org.junit.Test
import kotlin.test.*

class FireTests {

  @Before fun removeLogs() {
    Fire.removeAllLogs()
  }

  @Test fun `should add log and remove logs`() {
    assertTrue("logs size should be 0") { Fire.logs.isEmpty() }
    for (i in 1..100) {
      Fire.add(PrintlnLogger())
      assertTrue("logs size doesn't match index") { Fire.logs.size == i }
    }
    Fire.removeAllLogs()
    assertTrue("logs size should be 0") { Fire.logs.isEmpty() }
  }


}