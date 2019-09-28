package eu.yeger.kotlin.javafx

import javafx.beans.property.StringProperty
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

class FragmentException(message: String) : Exception(message)

open class Fragment<out T: Node>(private val builder: () -> T) {
    open fun instance() = builder()
}

class SingletonFragment<out T: Node>(private val node: T) : Fragment<T>({ node }) {
    private var consumed = false
    override fun instance() =
        if (!consumed) {
            consumed = true
            node
        } else throw FragmentException("SingletonFragment has already been consumed")
}

fun <T: Node> T.asSingletonFragment() = SingletonFragment(this)

inline fun button(crossinline init: @FXMarker Button.() -> Unit = {}) =
    Fragment { Button().apply(init) }

inline fun button(text: String, crossinline init: @FXMarker Button.() -> Unit = {}) =
    Fragment { Button(text).apply(init) }

inline fun label(crossinline init: @FXMarker Label.() -> Unit = {}) =
    Fragment { Label().apply(init) }

inline fun label(text: String, crossinline init: @FXMarker Label.() -> Unit = {}) =
    Fragment { Label(text).apply(init) }

    inline fun label(binding: StringProperty, crossinline init: @FXMarker Label.() -> Unit = {}) =
        Fragment {
            Label().apply {
                textProperty().bind(binding)
                init()
            }
        }

    inline fun textField(crossinline init: @FXMarker TextField.() -> Unit = {}) =
        Fragment { TextField().apply(init) }

    inline fun passwordField(crossinline init: @FXMarker PasswordField.() -> Unit = {}) =
        Fragment { PasswordField().apply(init) }

    inline fun imageView(crossinline init: @FXMarker ImageView.() -> Unit = {}) =
        Fragment { ImageView().apply(init) }

    inline fun imageView(image: Image, crossinline init: @FXMarker ImageView.() -> Unit = {}) =
        Fragment { ImageView(image).apply(init) }

    inline fun rectangle(crossinline init: @FXMarker Rectangle.() -> Unit = {}) =
        Fragment { Rectangle().apply(init) }

    inline fun hBox(crossinline init: @FXMarker HBox.() -> Unit = {}) =
        Fragment { HBox().apply(init) }

    inline fun vBox(crossinline init: @FXMarker VBox.() -> Unit = {}) =
        Fragment { VBox().apply(init) }

    inline fun gridPane(crossinline init: @FXMarker GridPane.() -> Unit = {}) =
        Fragment { GridPane().apply(init) }

    inline fun stackPane(crossinline init: @FXMarker StackPane.() -> Unit = {}) =
        Fragment { StackPane().apply(init) }
