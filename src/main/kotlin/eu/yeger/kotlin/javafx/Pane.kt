package eu.yeger.kotlin.javafx

import javafx.scene.Node
import javafx.scene.control.Button
import javafx.scene.control.Label
import javafx.scene.control.PasswordField
import javafx.scene.control.TextField
import javafx.scene.layout.HBox
import javafx.scene.layout.Pane
import javafx.scene.layout.VBox

inline fun <T: Pane> T.button(text: String = "Button", init: @FXMarker Button.() -> Unit = {}) =
    Button(text).apply(init).also { children.add(it) }

inline fun <T: Pane> T.label(text: String = "Label", init: @FXMarker Label.() -> Unit = {}) =
    Label(text).apply(init).also { children.add(it) }

inline fun <T: Pane> T.textField(init: @FXMarker TextField.() -> Unit = {}) =
    TextField().apply(init).also { children.add(it) }

inline fun <T: Pane> T.passwordField(init: @FXMarker PasswordField.() -> Unit = {}) =
    PasswordField().apply(init).also { children.add(it) }

inline fun <T: Pane> T.hBox(init: @FXMarker HBox.() -> Unit = {}) =
    HBox().apply(init).also { children.add(it) }

inline fun <T: Pane> T.vBox(init: @FXMarker VBox.() -> Unit = {}): VBox =
    VBox().apply(init).also { children.add(it) }

infix fun <T: Pane> T.withChild(child: Node) {
    children.add(child)
}

fun <T: Pane, U: Node> T.include(fragment: Fragment<U>) {
    children.add(fragment.instance())
}
