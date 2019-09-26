package eu.yeger.kotlin.javafx.alert

import javafx.scene.Scene
import javafx.stage.Stage

abstract class Alert {
    var title = "Alert"
    var text = ""

    abstract fun build(): Scene

    private var stage: Stage? = null

    fun show() {
        stage = Stage().apply {
            scene = build()
            title = this@Alert.title
            sizeToScene()
            show()
            toFront()
        }
    }

    fun hide() {
        stage?.close()
    }
}
