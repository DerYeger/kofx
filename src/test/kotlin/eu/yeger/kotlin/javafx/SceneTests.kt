package eu.yeger.kotlin.javafx

import javafx.beans.property.SimpleIntegerProperty
import javafx.stage.Stage
import org.testfx.framework.junit5.ApplicationTest

class SceneTests : ApplicationTest() {

    private fun SimpleIntegerProperty.increment() {
        this.value = this.value + 1
    }

    private class ExampleContextWithCounter {
        val clickCounter = SimpleIntegerProperty(0)
    }

    override fun start(primaryStage: Stage) {
        val scene = scene(ExampleContextWithCounter()) {
            vBox {
                label {
                    textProperty().bind(this@scene.context.clickCounter.asString())
                }
                button("My Button") {
                    setOnAction { this@scene.context.clickCounter.increment() }
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
}