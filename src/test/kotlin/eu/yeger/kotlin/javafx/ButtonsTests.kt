package eu.yeger.kotlin.javafx

import org.junit.Assert.assertEquals
import org.junit.Test
import org.testfx.framework.junit.ApplicationTest

class ButtonsTests : ApplicationTest() {

    @Test
    fun testButtonWithText() {
        println("starting")
        val myButton = button("Hello") {}
        println("started")
        assertEquals("Hello", myButton.text)
        println("done")
    }
}