package eu.yeger.kotlin.javafx

import javafx.scene.control.Label

inline fun label(text: String = "", init: Label.() -> Unit = {}) =
    Label(text).apply { init() }