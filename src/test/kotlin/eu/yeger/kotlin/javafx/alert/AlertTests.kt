package eu.yeger.kotlin.javafx.alert

import javafx.application.Platform
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.testfx.assertions.api.Assertions.assertThat
import org.testfx.framework.junit5.ApplicationTest
import org.testfx.util.WaitForAsyncUtils

class AlertTests : ApplicationTest() {

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
                        println("Testing")
                        this@informationAlert.hide()
                    }
                }
            }
            WaitForAsyncUtils.waitForFxEvents()
            assertThat(lookup("InformationAlertTest").queryLabeled()).isNotNull
            clickOn(lookup("Confirm").queryButton())
            assertTrue(confirmed)
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
                    onConfirm {
                        confirmed = true
                        this@confirmationAlert.hide()
                    }
                }
            }
            WaitForAsyncUtils.waitForFxEvents()
            assertThat(lookup("ConfirmationAlertTest").queryLabeled()).isNotNull
            clickOn(lookup("Confirm").queryButton())
            assertTrue(confirmed)
        }

        @Test
        fun testCancelButtonClicked() {
            var confirmed = false
            Platform.runLater {
                confirmationAlert {
                    text = "ConfirmationAlertTest"
                    cancelButton.apply {
                        text = "CustomText"
                        onCancel {
                            confirmed = true
                            this@confirmationAlert.hide()
                        }
                    }
                }
            }
            WaitForAsyncUtils.waitForFxEvents()
            assertThat(lookup("ConfirmationAlertTest").queryLabeled()).isNotNull
            clickOn(lookup("CustomText").queryButton())
            assertTrue(confirmed)
        }
    }

}