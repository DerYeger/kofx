package eu.yeger.kotlin.javafx

import javafx.scene.Node
import javafx.scene.control.Button
import javafx.scene.control.Label
import javafx.scene.control.PasswordField
import javafx.scene.control.TextField
import javafx.scene.layout.GridPane
import javafx.scene.layout.HBox
import javafx.scene.layout.VBox

open class Fragment<T: Node>(private val builder: () -> T) {
    fun instance() = builder()
}

internal fun <T: Node> T.wrapped() = Fragment { this }

inline fun button(text: String = "Button", crossinline init: @FXMarker Button.() -> Unit = {}) =
    Fragment { Button(text).apply(init) }

inline fun label(text: String = "Label", crossinline init: @FXMarker Label.() -> Unit = {}) =
    Fragment { Label(text).apply(init) }

inline fun textField(crossinline init: @FXMarker TextField.() -> Unit = {}) =
    Fragment { TextField().apply(init) }

inline fun passwordField(crossinline init: @FXMarker PasswordField.() -> Unit = {}) =
    Fragment { PasswordField().apply(init) }

inline fun hBox(crossinline init: @FXMarker HBox.() -> Unit = {}) =
    Fragment { HBox().apply(init) }

inline fun vBox(crossinline init: @FXMarker VBox.() -> Unit = {}) =
    Fragment { VBox().apply(init) }

inline fun gridPane(crossinline init: @FXMarker GridPane.() -> Unit = {}) =
    Fragment { GridPane().apply(init) }
