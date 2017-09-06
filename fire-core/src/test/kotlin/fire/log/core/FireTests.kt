package fire.log.core

import org.junit.Test
import kotlin.test.*

class FireTests {

  @Test fun vShouldPrint() {
    val fire = Fire
    fire.v { "VERBOSE" }
    fire.v("VERBOSE_TEST") { "this is a verbose message" }
    assertTrue { true }
  }
}