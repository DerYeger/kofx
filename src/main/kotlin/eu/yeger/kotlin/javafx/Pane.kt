package eu.yeger.kotlin.javafx

import javafx.scene.control.Button
import javafx.scene.control.Label
import javafx.scene.layout.Pane

inline fun Pane.button(text: String = "Button", init: Button.() -> Unit = {}) =
    eu.yeger.kotlin.javafx.button(text, init).also { children.add(it) }


inline fun Pane.label(text: String = "Label", init: Label.() -> Unit = {}) =
    eu.yeger.kotlin.javafx.label(text, init).also { children.add(it) }
