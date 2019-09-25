package eu.yeger.kotlin.javafx

import javafx.scene.layout.HBox

inline fun hBox(init: HBox.() -> Unit = {}) = HBox().apply { init() }
