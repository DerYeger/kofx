package eu.yeger.kotlin.javafx

import javafx.scene.Node
import javafx.scene.control.Button
import javafx.scene.control.Label
import javafx.scene.control.PasswordField
import javafx.scene.control.TextField
import javafx.scene.layout.HBox
import javafx.scene.layout.VBox

open class Fragment<T: Node>(val builder: @FXMarker Fragment<T>.() -> T) {
    fun instance() = builder()
}

fun <T: Node> fragment(init: @FXMarker Fragment<T>.() -> T) = Fragment(init)

inline fun Fragment<in Button>.button(text: String = "Button", init: @FXMarker Button.() -> Unit = {}) =
    Button(text).apply(init)

inline fun Fragment<in Label>.label(text: String = "Label", init: @FXMarker Label.() -> Unit = {}) =
    Label(text).apply(init)

inline fun Fragment<in TextField>.textField(init: @FXMarker TextField.() -> Unit = {}) =
    TextField().apply(init)

inline fun Fragment<in PasswordField>.passwordField(init: @FXMarker PasswordField.() -> Unit = {}) =
    PasswordField().apply(init)

inline fun Fragment<in HBox>.hBox(init: @FXMarker HBox.() -> Unit = {}) =
    HBox().apply(init)

inline fun Fragment<in VBox>.vBox(init: @FXMarker VBox.() -> Unit = {}): VBox =
    VBox().apply(init)
