package eu.yeger.kotlin.javafx.alert

import eu.yeger.kotlin.javafx.KPlatform.runAndWait
import javafx.scene.Node
import javafx.scene.Scene
import javafx.scene.control.Label
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.testfx.assertions.api.Assertions.assertThat
import org.testfx.framework.junit5.ApplicationTest

class AlertTests : ApplicationTest() {

    @Nested
    inner class AlertTest {

        @Test
        fun `test AlertAlreadyActive Exception`() {
            val alert = object : Alert() {
                override fun build() = Scene(Label("Alert"))
            }
            runAndWait {
                alert.show()
            }
            assertThat(lookup("Alert").queryLabeled()).isNotNull

            assertThrows<AlertException> {
                alert.show()
            }
        }
    }

    @Nested
    inner class InformationAlertTests {

        @Test
        fun `test ConfirmButton clicked`() {
            var confirmed = false
            runAndWait {
                informationAlert {
                    text = "InformationAlertTest"
                    onConfirm {
                        confirmed = true
                    }
                }
            }
            assertThat(lookup("InformationAlertTest").queryLabeled()).isNotNull
            clickOn(lookup("Confirm").queryButton())
            assertTrue(confirmed)
            assertThat(lookup("ConfirmationAlertTest").tryQuery<Node>()).isEmpty
        }
    }

    @Nested
    inner class ConfirmationAlertTests {

        @Test
        fun `test ConfirmButton clicked`() {
            var confirmed = false
            runAndWait {
                confirmationAlert {
                    text = "ConfirmationAlertTest"
                    onConfirm { confirmed = true }
                }
            }
            assertThat(lookup("ConfirmationAlertTest").queryLabeled()).isNotNull
            clickOn(lookup("Confirm").queryButton())
            assertTrue(confirmed)
            assertThat(lookup("ConfirmationAlertTest").tryQuery<Node>()).isEmpty
        }

        @Test
        fun `test CancelButton clicked`() {
            var confirmed = false
            runAndWait {
                confirmationAlert {
                    text = "ConfirmationAlertTest"
                    cancelButton.apply {
                        text = "CustomText"
                        onCancel { confirmed = true }
                    }
                }
            }
            assertThat(lookup("ConfirmationAlertTest").queryLabeled()).isNotNull
            clickOn(lookup("CustomText").queryButton())
            assertTrue(confirmed)
            assertThat(lookup("ConfirmationAlertTest").tryQuery<Node>()).isEmpty
        }
    }
}
