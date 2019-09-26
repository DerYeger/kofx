package eu.yeger.kotlin.javafx

import javafx.scene.control.Button
import javafx.scene.layout.VBox
import org.junit.jupiter.api.Test
import org.testfx.assertions.api.Assertions.assertThat
import org.testfx.framework.junit5.ApplicationTest

class PaneTests : ApplicationTest() {

    @Test
    fun testInclude() {
        val singleButtonFragment = fragment<Button> {
            button("IncludedButton")
        }
        val container = fragment<VBox> {
            vBox {
                include(singleButtonFragment)
            }
        }
        val anotherContainer = fragment<VBox> {
            vBox {
                include(singleButtonFragment)
            }
        }
        assertThat(container.instance().children[0] as Button).hasText("IncludedButton")
        assertThat(anotherContainer.instance().children[0] as Button).hasText("IncludedButton")
    }
}