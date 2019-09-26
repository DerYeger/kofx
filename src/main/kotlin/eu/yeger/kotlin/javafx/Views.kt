package eu.yeger.kotlin.javafx

import javafx.scene.Node
import javafx.scene.control.Button
import javafx.scene.control.Label
import javafx.scene.control.PasswordField
import javafx.scene.control.TextField
import javafx.scene.layout.HBox
import javafx.scene.layout.VBox

inline fun Fragment<Node>.button(text: String = "Button", init: @FXDSL Button.() -> Unit = {}) =
    Button(text).apply(init)

inline fun Fragment<Node>.label(text: String = "Label", init: @FXDSL Label.() -> Unit = {}) =
    Label(text).apply(init)

inline fun Fragment<Node>.textField(init: @FXDSL TextField.() -> Unit = {}) =
    TextField().apply(init)

inline fun Fragment<Node>.passwordField(init: @FXDSL PasswordField.() -> Unit = {}) =
    PasswordField().apply(init)

inline fun Fragment<Node>.hBox(init: @FXDSL HBox.() -> Unit = {}) =
    HBox().apply(init)

inline fun Fragment<Node>.vBox(init: @FXDSL VBox.() -> Unit = {}): VBox =
    VBox().apply(init)
