package eu.yeger.kotlin.javafx

import org.junit.Assert
import org.junit.Test
import org.testfx.framework.junit.ApplicationTest

class LabelTests : ApplicationTest() {

    @Test
    fun testLabelWithoutText() {
        val label = label()
        Assert.assertEquals("", label.text)
    }

    @Test
    fun testLabelWithText() {
        val label = button("Hello")
        Assert.assertEquals("Hello", label.text)
    }
}