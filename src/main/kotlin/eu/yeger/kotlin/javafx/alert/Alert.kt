package eu.yeger.kotlin.javafx.alert

import javafx.scene.Scene
import javafx.stage.Stage

class AlertException(message: String) : Exception(message)

abstract class Alert {
    var title = "Alert"
    var text = ""

    abstract fun build(): Scene

    private var stage: Stage? = null

    fun show() {
        stage?.run { throw AlertException("Alert $this is already active") }
        stage = Stage().apply {
            scene = build()
            title = this@Alert.title
            sizeToScene()
            isResizable = false
            toFront()
            show()
        }
    }

    fun hide() {
        stage?.close()
        stage = null
    }
}
