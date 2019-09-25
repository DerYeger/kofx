package eu.yeger.kotlin.javafx

import javafx.event.Event
import javafx.event.EventHandler
import javafx.scene.control.Button

inline fun button(text: String = "", init: Button.() -> Unit = {}) =
    Button(text).apply { init() }

inline fun Button.setOnAction(crossinline onAction: (Event) -> Unit) {
    this.onAction = EventHandler { onAction.invoke(it) }
}
