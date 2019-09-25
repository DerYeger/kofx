package eu.yeger.kotlin.javafx

import org.junit.Assert.assertTrue
import org.junit.Test
import org.testfx.assertions.api.Assertions.assertThat
import org.testfx.framework.junit.ApplicationTest

class ButtonTests : ApplicationTest() {

    @Test
    fun testButtonWithoutText() {
        assertThat(button()).hasText("Button")
    }

    @Test
    fun testButtonWithText() {
        assertThat(button("Hello")).hasText("Hello")
    }

    @Test
    fun testButtonWithInitializer() {
        var handled = false
        val button = button {
            text = "Test"
            setOnAction {
                handled = true
            }
        }
        assertThat(button).hasText("Test")
        button.onAction.handle(null)
        assertTrue(handled)
    }
}