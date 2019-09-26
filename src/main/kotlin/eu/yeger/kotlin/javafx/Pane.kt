package eu.yeger.kotlin.javafx

import javafx.scene.Node
import javafx.scene.control.Button
import javafx.scene.control.Label
import javafx.scene.control.PasswordField
import javafx.scene.control.TextField
import javafx.scene.layout.HBox
import javafx.scene.layout.Pane
import javafx.scene.layout.VBox

inline fun Pane.button(text: String = "Button", init: @FXMarker Button.() -> Unit = {}) =
    Button(text).apply(init).also { children.add(it) }

inline fun Pane.label(text: String = "Label", init: @FXMarker Label.() -> Unit = {}) =
    Label(text).apply(init).also { children.add(it) }

inline fun Pane.textField(init: @FXMarker TextField.() -> Unit = {}) =
    TextField().apply(init).also { children.add(it) }

inline fun Pane.passwordField(init: @FXMarker PasswordField.() -> Unit = {}) =
    PasswordField().apply(init).also { children.add(it) }

inline fun Pane.hBox(init: @FXMarker HBox.() -> Unit = {}) =
    HBox().apply(init).also { children.add(it) }

inline fun Pane.vBox(init: @FXMarker VBox.() -> Unit = {}): VBox =
    VBox().apply(init).also { children.add(it) }

infix fun Pane.withChild(child: Node) {
    children.add(child)
}

fun <T: Node> Pane.include(fragment: Fragment<T>) {
    children.add(fragment.instance())
}