package eu.yeger.kotlin.javafx

import javafx.beans.property.SimpleIntegerProperty
import javafx.stage.Stage
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
                label {
                    textProperty().bind(context.clickCounter.asString())
                }
                button("My Button") {
                    setOnAction {
                        context.clickCounter.increment()
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
}