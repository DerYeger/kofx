package eu.yeger.kotlin.javafx

import javafx.event.ActionEvent
import javafx.event.EventHandler
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test
import org.testfx.framework.junit.ApplicationTest

class ButtonTests : ApplicationTest() {

    @Test
    fun testButtonWithoutText() {
        val myButton = button()
        assertEquals("", myButton.text)
    }

    @Test
    fun testButtonWithText() {
        val myButton = button("Hello")
        assertEquals("Hello", myButton.text)
    }

    @Test
    fun testButtonWithInitializer() {
        var handled = false
        val myButton = button {
            text = "Hello"
            setOnAction {
                handled = true
            }

        }
        myButton.onAction.handle(null)
        assertTrue(handled)
    }
}