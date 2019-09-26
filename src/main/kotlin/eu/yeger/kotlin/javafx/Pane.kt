package eu.yeger.kotlin.javafx

import javafx.scene.control.Button
import javafx.scene.control.Label
import javafx.scene.control.PasswordField
import javafx.scene.control.TextField
import javafx.scene.layout.HBox
import javafx.scene.layout.Pane
import javafx.scene.layout.VBox

inline fun Pane.button(text: String = "Button", init: @FXDSL Button.() -> Unit = {}) =
    Button(text).apply(init).also { children.add(it) }

inline fun Pane.label(text: String = "Label", init: @FXDSL Label.() -> Unit = {}) =
    Label(text).apply(init).also { children.add(it) }

inline fun Pane.textField(init: @FXDSL TextField.() -> Unit = {}) =
    TextField().apply(init).also { children.add(it) }

inline fun Pane.passwordField(init: @FXDSL PasswordField.() -> Unit = {}) =
    PasswordField().apply(init).also { children.add(it) }

inline fun Pane.hBox(init: @FXDSL HBox.() -> Unit = {}) =
    HBox().apply(init).also { children.add(it) }

inline fun Pane.vBox(init: @FXDSL VBox.() -> Unit = {}): VBox =
    VBox().apply(init).also { children.add(it) }