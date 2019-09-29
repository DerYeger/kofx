package eu.yeger.kotlin.javafx

import eu.yeger.kotlin.javafx.KPlatform.callAndWait
import eu.yeger.kotlin.javafx.KPlatform.runAndWait
import javafx.application.Platform
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.testfx.framework.junit5.ApplicationTest

class KPlatformTests : ApplicationTest() {

    @Nested
    inner class RunAndWaitTest {
        @Test
        fun testRunAndWaitOnWorkerThread() {
            var ran = false
            assertFalse(Platform.isFxApplicationThread())
            runAndWait {
                assertTrue(Platform.isFxApplicationThread())
                ran = true
            }
            assertTrue(ran)
        }

        @Test
        fun testRunAndWaitOnFXThread() {
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
        fun testCallAndWaitOnWorkerThread() {
            assertFalse(Platform.isFxApplicationThread())
            val ran: Boolean? = callAndWait {
                assertTrue(Platform.isFxApplicationThread())
                true
            }
            assertTrue(ran!!)
        }

        @Test
        fun testCallAndWaitOnFXThread() {
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