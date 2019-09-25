package eu.yeger.kotlin.javafx

import javafx.scene.control.Label

inline fun label(text: String = "", init: Label.() -> Unit = {}): Label {
    val label = Label(text)
    label.init()
    return label
}