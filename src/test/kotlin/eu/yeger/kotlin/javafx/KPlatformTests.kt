package eu.yeger.kotlin.javafx

import eu.yeger.kotlin.javafx.KPlatform.callAndWait
import eu.yeger.kotlin.javafx.KPlatform.runAndWait
import eu.yeger.kotlin.javafx.KPlatform.runOnFXThread
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
                    ran = true
                }
                assertTrue(ran)
            }
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
                    ran = true
                }
                assertTrue(ran)
            }
        }
    }

    @Nested
    inner class CallAndWaitTests {

        @Test
        fun `test callAndWait on non-FX-thread`() {
            assertFalse(Platform.isFxApplicationThread())
            val ran: Boolean? = callAndWait {
                assertTrue(Platform.isFxApplicationThread())
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
                    true
                }
                assertTrue(ran!!)
            }
        }
    }
}