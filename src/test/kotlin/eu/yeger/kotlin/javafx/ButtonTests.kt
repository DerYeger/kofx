package eu.yeger.kotlin.javafx

import org.junit.Assert.assertEquals
import org.junit.Test
import org.testfx.framework.junit.ApplicationTest

class ButtonTests : ApplicationTest() {

    @Test
    fun testButtonWithText() {
        val myButton = button("Hello") {}
        assertEquals("Hello", myButton.text)
    }
}