package eu.yeger.kotlin.javafx

import javafx.scene.control.Button
import javafx.scene.layout.VBox
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.testfx.assertions.api.Assertions.assertThat
import org.testfx.framework.junit5.ApplicationTest

class PaneTests : ApplicationTest() {

    @Test
    fun testInclude() {
        val singleButtonFragment = fragment<Button> {
            button("IncludeButton")
        }
        val container = fragment<VBox> {
            vBox {
                include(singleButtonFragment)
            }
        }
        assertTrue(singleButtonFragment.root in container.root.children)
        assertThat(container.root).hasExactlyNumChildren(1)
    }
}