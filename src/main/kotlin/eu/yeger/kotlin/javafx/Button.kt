package eu.yeger.kotlin.javafx

import javafx.scene.control.Button

inline fun button(text: String = "Button", init: Button.() -> Unit = {}) =
    Button(text).apply { init() }