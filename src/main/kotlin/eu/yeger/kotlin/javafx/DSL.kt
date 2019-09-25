package eu.yeger.kotlin.javafx

import javafx.scene.Node
import javafx.scene.Parent
import javafx.scene.Scene

@DslMarker
@Target(AnnotationTarget.CLASS, AnnotationTarget.TYPE)
annotation class FXDSL

open class ViewBuilder<T>(val context: T) {
    var root: Node? = null
}

inline fun <T> view(context: T, init: @FXDSL ViewBuilder<T>.() -> Node) =
    ViewBuilder(context).apply { root = init() }.root

inline fun <T> scene(context: T, init: @FXDSL ViewBuilder<T>.() -> Parent) =
    Scene(ViewBuilder(context).apply { root = init() }.root as Parent)


