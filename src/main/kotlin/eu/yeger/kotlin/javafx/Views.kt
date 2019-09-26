package eu.yeger.kotlin.javafx

import javafx.scene.control.Button
import javafx.scene.control.Label
import javafx.scene.control.PasswordField
import javafx.scene.control.TextField
import javafx.scene.layout.HBox
import javafx.scene.layout.VBox

inline fun View.button(text: String = "Button", init: @FXDSL Button.() -> Unit = {}) =
    Button(text).apply(init)

inline fun View.label(text: String = "Label", init: @FXDSL Label.() -> Unit = {}) =
    Label(text).apply(init)

inline fun View.textField(init: @FXDSL TextField.() -> Unit = {}) =
    TextField().apply(init)

inline fun View.passwordField(init: @FXDSL PasswordField.() -> Unit = {}) =
    PasswordField().apply(init)

inline fun View.hBox(init: @FXDSL HBox.() -> Unit = {}) =
    HBox().apply(init)

inline fun View.vBox(init: @FXDSL VBox.() -> Unit = {}): VBox =
    VBox().apply(init)
