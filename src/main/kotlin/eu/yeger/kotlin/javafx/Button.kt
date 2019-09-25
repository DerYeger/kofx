package eu.yeger.kotlin.javafx

import javafx.event.Event
import javafx.event.EventHandler
import javafx.scene.control.Button

inline fun button(text: String = "", init: Button.() -> Unit = {}): Button {
    val button = Button(text)
    button.init()
    return button
}

inline fun Button.setOnAction(crossinline onAction: (Event) -> Unit) {
    this.onAction = EventHandler { onAction.invoke(it) }
}
