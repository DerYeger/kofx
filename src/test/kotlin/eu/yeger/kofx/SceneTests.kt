package eu.yeger.kofx

import eu.yeger.kofx.fragment.*
import javafx.beans.property.SimpleIntegerProperty
import javafx.scene.control.Button
import javafx.scene.control.Label
import javafx.scene.layout.HBox
import javafx.stage.Stage
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.testfx.assertions.api.Assertions.assertThat
import org.testfx.framework.junit5.ApplicationTest

class SceneTests : ApplicationTest() {

    private fun SimpleIntegerProperty.increment() {
        value += 1
    }

    private class ExampleContextWithCounter {
        val clickCounter = SimpleIntegerProperty(0)
    }

    override fun start(primaryStage: Stage) {
        val context = ExampleContextWithCounter()
        val scene = with(context) {
            scene {
                vBox {
                    child { label(clickCounter.asString()) }
                    child {
                        button("My Button") {
                            setOnAction { clickCounter.increment() }
                        }
                    }
                }
            }
        }
        primaryStage.apply {
            this.scene = scene
            sizeToScene()
        }.apply {
            minHeight = height
            minWidth = width
            toFront()
        }.show()
    }

    @Test
    fun `test ClickCounter example application`() {
        val label = lookup("0").queryLabeled()
        assertThat(label).hasText("0")
        clickOn(lookup("My Button").queryButton())
        assertThat(label).hasText("1")
    }

    @Test
    fun `test simple Scene creation`() {
        val root = scene {
            hBox {
                children(
                    label("First"),
                    button("Second")
                )
            }
        }.root as HBox
        assertThat(root).hasExactlyNumChildren(2)
        assertEquals("First", (root.children[0] as Label).text)
        assertEquals("Second", (root.children[1] as Button).text)
    }
}
