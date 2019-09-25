package eu.yeger.kotlin.javafx

import javafx.scene.layout.VBox

inline fun vBox(init: VBox.() -> Unit = {}) = VBox().apply { init() }

