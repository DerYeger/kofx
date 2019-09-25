package eu.yeger.kotlin.javafx

import javafx.scene.control.Button
import javafx.scene.control.Label
import org.junit.Assert.assertEquals
import org.junit.Test
import org.testfx.framework.junit.ApplicationTest

class VBoxTests : ApplicationTest() {

    @Test
    fun testVBoxWithButtonChildren() {
        val vBox = vBox {
            label("First")
            button("Second")
        }
        assertEquals("First", (vBox.children[0] as Label).text)
        assertEquals("Second",(vBox.children[1] as Button).text)
    }
}