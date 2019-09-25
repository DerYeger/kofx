package eu.yeger.kotlin.javafx

import javafx.scene.control.Button
import javafx.scene.control.Label
import javafx.scene.layout.HBox

inline fun hBox(init: HBox.() -> Unit = {}) =
    HBox().apply { init() }

inline fun HBox.button(text: String = "", init: Button.() -> Unit = {}) {
    children.add(eu.yeger.kotlin.javafx.button(text, init))
}

inline fun HBox.label(text: String = "", init: Label.() -> Unit = {}) {
    children.add(eu.yeger.kotlin.javafx.label(text, init))
}
