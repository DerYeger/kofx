package eu.yeger.kofx

import eu.yeger.kofx.KPlatform.callAndWait
import eu.yeger.kofx.KPlatform.runAndWait
import eu.yeger.kofx.KPlatform.runOnFXThread
import javafx.application.Platform
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.testfx.framework.junit5.ApplicationTest
import org.testfx.util.WaitForAsyncUtils

class KPlatformTests : ApplicationTest() {

    @Nested
    inner class RunOnFXThreadTests {

        @Test
        fun `test runOnFXThread on non-FX-thread`() {
            var ran = false
            assertFalse(Platform.isFxApplicationThread())
            runOnFXThread {
                assertTrue(Platform.isFxApplicationThread())
                sleep(100)
                ran = true
            }
            WaitForAsyncUtils.waitForFxEvents()
            assertTrue(ran)
        }

        @Test
        fun `test runOnFXThread on FX-thread`() {
            Platform.runLater {
                var ran = false
                assertTrue(Platform.isFxApplicationThread())
                runOnFXThread {
                    assertTrue(Platform.isFxApplicationThread())
                    sleep(100)
                    ran = true
                }
                assertTrue(ran)
            }
            WaitForAsyncUtils.waitForFxEvents()
        }
    }

    @Nested
    inner class RunAndWaitTests {

        @Test
        fun `test runAndWait on non-FX-thread`() {
            var ran = false
            assertFalse(Platform.isFxApplicationThread())
            runAndWait {
                assertTrue(Platform.isFxApplicationThread())
                sleep(100)
                ran = true
            }
            assertTrue(ran)
        }

        @Test
        fun `test runAndWait on FX-thread`() {
            Platform.runLater {
                var ran = false
                assertTrue(Platform.isFxApplicationThread())
                runAndWait {
                    assertTrue(Platform.isFxApplicationThread())
                    sleep(100)
                    ran = true
                }
                assertTrue(ran)
            }
            WaitForAsyncUtils.waitForFxEvents()
        }
    }

    @Nested
    inner class CallAndWaitTests {

        @Test
        fun `test callAndWait on non-FX-thread`() {
            assertFalse(Platform.isFxApplicationThread())
            val ran: Boolean? = callAndWait {
                assertTrue(Platform.isFxApplicationThread())
                sleep(100)
                true
            }
            assertTrue(ran!!)
        }

        @Test
        fun `test callAndWait on FX-thread`() {
            Platform.runLater {
                assertTrue(Platform.isFxApplicationThread())
                val ran: Boolean? = callAndWait {
                    assertTrue(Platform.isFxApplicationThread())
                    sleep(100)
                    true
                }
                assertTrue(ran!!)
            }
            WaitForAsyncUtils.waitForFxEvents()
        }
    }
}