package eu.yeger.kotlin.javafx

import javafx.scene.control.Button
import javafx.scene.control.Label
import javafx.scene.layout.HBox
import javafx.scene.layout.Pane
import javafx.scene.layout.VBox

inline fun <T> ViewBuilder<T>.button(text: String = "Button", init: @FXDSL Button.() -> Unit = {}) =
    Button(text).apply(init)

inline fun <T> ViewBuilder<T>.label(text: String = "Label", init: @FXDSL Label.() -> Unit = {}) =
    Label(text).apply(init)

inline fun <T> ViewBuilder<T>.hBox(init: @FXDSL HBox.() -> Unit = {}) =
    HBox().apply(init)

inline fun <T> ViewBuilder<T>.vBox(init: @FXDSL VBox.() -> Unit = {}): VBox =
    VBox().apply(init)

inline fun Pane.button(text: String = "Button", init: @FXDSL Button.() -> Unit = {}) =
    Button(text).apply(init).also { children.add(it) }


inline fun Pane.label(text: String = "Label", init: @FXDSL Label.() -> Unit = {}) =
    Label(text).apply(init).also { children.add(it) }