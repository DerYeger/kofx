package eu.yeger.kotlin.javafx

import javafx.scene.control.Label

inline fun label(text: String = "Label", init: Label.() -> Unit = {}) = Label(text).apply { init() }