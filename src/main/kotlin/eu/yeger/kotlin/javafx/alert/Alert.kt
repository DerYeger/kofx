package eu.yeger.kotlin.javafx.alert

import eu.yeger.kotlin.javafx.FXDSL
import javafx.scene.Scene
import javafx.scene.control.Button
import javafx.stage.Stage

abstract class Alert {
    var title = "Alert"
    lateinit var text: String

    abstract fun build(): Scene

    private var stage: Stage? = null

    fun show() {
        stage = Stage().apply {
            scene = build()
            this.title = title
            sizeToScene()
            show()
        }
    }

    fun hide() {
        stage?.close()
    }
}

abstract class ButtonAlert : Alert()

inline fun ButtonAlert.button(text: String = "Confirm", init: @FXDSL Button.() -> Unit = {}) =
    Button(text).apply(init)