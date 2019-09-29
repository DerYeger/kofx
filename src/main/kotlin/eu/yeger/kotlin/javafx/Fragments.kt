package eu.yeger.kotlin.javafx

import javafx.beans.property.ObjectProperty
import javafx.beans.property.StringProperty
import javafx.beans.value.ObservableValue
import javafx.scene.Node
import javafx.scene.control.Button
import javafx.scene.control.Label
import javafx.scene.control.PasswordField
import javafx.scene.control.TextField
import javafx.scene.image.Image
import javafx.scene.image.ImageView
import javafx.scene.layout.GridPane
import javafx.scene.layout.HBox
import javafx.scene.layout.StackPane
import javafx.scene.layout.VBox
import javafx.scene.shape.Rectangle

// ===============================================================
// Fragment

open class Fragment<out T : Node>(private val builder: () -> T) {
    open fun instance() = builder()
}

class FragmentException(message: String) : Exception(message)

class SingletonFragment<out T : Node>(private val node: T) : Fragment<T>({ node }) {
    private var consumed = false
    override fun instance() =
        if (!consumed) {
            consumed = true
            node
        } else throw FragmentException("SingletonFragment $this has already been consumed")
}

fun <T : Node> T.asSingletonFragment() = SingletonFragment(this)

// ===============================================================
// Button

inline fun button(crossinline init: @FXMarker Button.() -> Unit = {}) =
    Fragment { Button().apply(init) }

inline fun button(text: String, crossinline init: @FXMarker Button.() -> Unit = {}) =
    Fragment { Button(text).apply(init) }

// ===============================================================
// Label

inline fun label(crossinline init: @FXMarker Label.() -> Unit = {}) =
    Fragment { Label().apply(init) }

inline fun label(text: String, crossinline init: @FXMarker Label.() -> Unit = {}) =
    Fragment { Label(text).apply(init) }

inline fun label(property: StringProperty, crossinline init: @FXMarker Label.() -> Unit = {}) =
    Fragment {
        Label().apply {
            textProperty().bind(property)
            init()
        }
    }

inline fun label(observable: ObservableValue<String>, crossinline init: @FXMarker Label.() -> Unit = {}) =
    Fragment {
        Label().apply {
            textProperty().bind(observable)
            init()
        }
    }

// ===============================================================
// TextField

inline fun textField(crossinline init: @FXMarker TextField.() -> Unit = {}) =
    Fragment { TextField().apply(init) }

inline fun textField(property: StringProperty, crossinline init: @FXMarker TextField.() -> Unit = {}) =
    Fragment {
        TextField().apply {
            textProperty().bindBidirectional(property)
            init()
        }
    }

inline fun textField(observable: ObservableValue<String>, crossinline init: @FXMarker TextField.() -> Unit = {}) =
    Fragment {
        TextField().apply {
            textProperty().bind(observable)
            init()
        }
    }

// ===============================================================
// PasswordField

inline fun passwordField(crossinline init: @FXMarker PasswordField.() -> Unit = {}) =
    Fragment { PasswordField().apply(init) }

inline fun passwordField(property: StringProperty, crossinline init: @FXMarker PasswordField.() -> Unit = {}) =
    Fragment {
        PasswordField().apply {
            textProperty().bindBidirectional(property)
            init()
        }
    }

inline fun passwordField(
    observable: ObservableValue<String>,
    crossinline init: @FXMarker PasswordField.() -> Unit = {}
) =
    Fragment {
        PasswordField().apply {
            textProperty().bind(observable)
            init()
        }
    }

// ===============================================================
// ImageView

inline fun imageView(crossinline init: @FXMarker ImageView.() -> Unit = {}) =
    Fragment { ImageView().apply(init) }

inline fun imageView(image: Image, fit: Boolean = false, crossinline init: @FXMarker ImageView.() -> Unit = {}) =
    Fragment {
        ImageView(image).apply {
            if (fit) {
                fitWidth = image.width
                fitHeight = image.height
            }
            init()
        }
    }

inline fun imageView(
    property: ObjectProperty<Image>,
    fit: Boolean = false,
    crossinline init: @FXMarker ImageView.() -> Unit = {}
) =
    Fragment {
        ImageView().apply {
            imageProperty().bind(property)
            if (fit) {
                fitWidth = property.value.width
                fitHeight = property.value.height
            }
            init()
        }
    }

inline fun imageView(
    observable: ObservableValue<Image>,
    fit: Boolean = false,
    crossinline init: @FXMarker ImageView.() -> Unit = {}
) =
    Fragment {
        ImageView().apply {
            imageProperty().bind(observable)
            if (fit) {
                fitWidth = observable.value.width
                fitHeight = observable.value.height
            }
            init()
        }
    }

// ===============================================================
// Rectangle

inline fun rectangle(crossinline init: @FXMarker Rectangle.() -> Unit = {}) =
    Fragment { Rectangle().apply(init) }

inline fun rectangle(width: Double, height: Double, crossinline init: @FXMarker Rectangle.() -> Unit = {}) =
    Fragment { Rectangle(width, height).apply(init) }

inline fun rectangle(size: Double, crossinline init: @FXMarker Rectangle.() -> Unit = {}) = rectangle(size, size, init)

// ===============================================================
// HBox

inline fun hBox(crossinline init: @FXMarker HBox.() -> Unit = {}) =
    Fragment { HBox().apply(init) }

// ===============================================================
// VBox

inline fun vBox(crossinline init: @FXMarker VBox.() -> Unit = {}) =
    Fragment { VBox().apply(init) }

// ===============================================================
// GridPane

inline fun gridPane(crossinline init: @FXMarker GridPane.() -> Unit = {}) =
    Fragment { GridPane().apply(init) }

// ===============================================================
// StackPane

inline fun stackPane(crossinline init: @FXMarker StackPane.() -> Unit = {}) =
    Fragment { StackPane().apply(init) }
