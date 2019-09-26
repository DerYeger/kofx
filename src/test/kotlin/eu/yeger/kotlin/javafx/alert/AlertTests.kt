package eu.yeger.kotlin.javafx.alert

import javafx.application.Platform
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.testfx.assertions.api.Assertions.assertThat
import org.testfx.framework.junit5.ApplicationTest
import org.testfx.util.WaitForAsyncUtils

class AlertTests : ApplicationTest() {

    @Test
    fun testInformationAlert() {
        var confirmed = false
        Platform.runLater {
            informationAlert {
                title = "TestAlert"
                text = "AlertText"
                confirmButton.setOnAction {
                        confirmed = true
                        this@informationAlert.hide()
                }
            }
        }
        WaitForAsyncUtils.waitForFxEvents()
        assertThat(lookup("AlertText").queryLabeled()).isNotNull
        clickOn(lookup("Confirm").queryButton())
        assertTrue(confirmed)
    }
}