package eu.yeger.kotlin.javafx

import javafx.scene.control.Button

inline fun button(text: String, init: Button.() -> Unit): Button {
    val button = Button(text)
    button.init()
    return button
}