package eu.yeger.kotlin.javafx

import javafx.beans.property.SimpleIntegerProperty
import javafx.scene.control.Button
import javafx.scene.control.Label
import javafx.scene.layout.HBox
import javafx.stage.Stage
import org.junit.jupiter.api.Assertions
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
        val scene = scene {
            vBox {
                child {
                    label {
                        textProperty().bind(context.clickCounter.asString())
                    }
                }
                child {
                    button("My Button") {
                        setOnAction {
                            context.clickCounter.increment()
                        }
                    }
                }
            }
        }
        primaryStage.apply{
            this.scene = scene
            sizeToScene()
        }.apply {
            minHeight = height
            minWidth = width
        }.show()
    }

    @Test
    fun testClickCounter() {
        val label = lookup("0").queryLabeled()
        assertThat(label).hasText("0")
        clickOn(lookup("My Button").queryButton())
        assertThat(label).hasText("1")
    }

    @Test
    fun testSimpleScene() {
        val root = scene {
            hBox {
                child { label("First") }
                child { button("Second") }
            }
        }.root as HBox
        assertThat(root).hasExactlyNumChildren(2)
        Assertions.assertEquals("First", (root.children[0] as Label).text)
        Assertions.assertEquals("Second", (root.children[1] as Button).text)
    }
}