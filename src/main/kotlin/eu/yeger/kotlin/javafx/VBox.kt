package eu.yeger.kotlin.javafx

import javafx.scene.control.Button
import javafx.scene.control.Label
import javafx.scene.layout.VBox

inline fun vBox(init: VBox.() -> Unit = {}) =
    VBox().apply {
        init()
    }

inline fun VBox.button(text: String = "", init: Button.() -> Unit = {}) {
    children.add(eu.yeger.kotlin.javafx.button(text, init))
}

inline fun VBox.label(text: String = "", init: Label.() -> Unit = {}) {
    children.add(eu.yeger.kotlin.javafx.label(text, init))
}
