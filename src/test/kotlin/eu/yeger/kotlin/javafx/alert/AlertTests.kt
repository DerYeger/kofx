package eu.yeger.kotlin.javafx.alert

import javafx.application.Platform
import javafx.scene.Node
import javafx.scene.Scene
import javafx.scene.control.Label
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.testfx.assertions.api.Assertions.assertThat
import org.testfx.framework.junit5.ApplicationTest
import org.testfx.util.WaitForAsyncUtils

class AlertTests : ApplicationTest() {

    @Nested
    inner class AlertTest {

        @Test
        fun testAlertAlreadyActiveException() {
            val alert = object : Alert() {
                override fun build() = Scene(Label("Alert"))
            }
            Platform.runLater {
                alert.show()
            }
            WaitForAsyncUtils.waitForFxEvents()
            assertThat(lookup("Alert").queryLabeled()).isNotNull

            assertThrows<AlertException> {
                alert.show()
            }
        }
    }

    @Nested
    inner class InformationAlertTests {

        @Test
        fun testConfirmButtonClicked() {
            var confirmed = false
            Platform.runLater {
                informationAlert {
                    text = "InformationAlertTest"
                    onConfirm {
                        confirmed = true
                    }
                }
            }
            WaitForAsyncUtils.waitForFxEvents()
            assertThat(lookup("InformationAlertTest").queryLabeled()).isNotNull
            clickOn(lookup("Confirm").queryButton())
            assertTrue(confirmed)
            assertThat(lookup("ConfirmationAlertTest").tryQuery<Node>()).isEmpty
        }
    }

    @Nested
    inner class ConfirmationAlertTests {

        @Test
        fun testConfirmButtonClicked() {
            var confirmed = false
            Platform.runLater {
                confirmationAlert {
                    text = "ConfirmationAlertTest"
                    onConfirm { confirmed = true }
                }
            }
            WaitForAsyncUtils.waitForFxEvents()
            assertThat(lookup("ConfirmationAlertTest").queryLabeled()).isNotNull
            clickOn(lookup("Confirm").queryButton())
            assertTrue(confirmed)
            assertThat(lookup("ConfirmationAlertTest").tryQuery<Node>()).isEmpty
        }

        @Test
        fun testCancelButtonClicked() {
            var confirmed = false
            Platform.runLater {
                confirmationAlert {
                    text = "ConfirmationAlertTest"
                    cancelButton.apply {
                        text = "CustomText"
                        onCancel { confirmed = true }
                    }
                }
            }
            WaitForAsyncUtils.waitForFxEvents()
            assertThat(lookup("ConfirmationAlertTest").queryLabeled()).isNotNull
            clickOn(lookup("CustomText").queryButton())
            assertTrue(confirmed)
            assertThat(lookup("ConfirmationAlertTest").tryQuery<Node>()).isEmpty
        }
    }

}