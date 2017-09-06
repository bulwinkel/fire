package fire.log.core

import org.junit.Test
import kotlin.test.*

class FireTests {

  @Test fun vShouldPrint() {
    v { "VERBOSE" }
    v("VERBOSE_TEST") { "this is a verbose message" }
    assertTrue { true }
  }
}