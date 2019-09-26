package eu.yeger.kotlin.javafx

import javafx.scene.Node
import javafx.scene.Parent
import javafx.scene.Scene

@DslMarker
@Target(AnnotationTarget.CLASS, AnnotationTarget.TYPE)
annotation class FXDSL

open class ViewBuilder {
    lateinit var root: Node
}

inline fun view(init: @FXDSL ViewBuilder.() -> Node) =
    ViewBuilder().apply { root = init() }.root

inline fun scene(init: @FXDSL ViewBuilder.() -> Parent) =
    Scene(ViewBuilder().apply { root = init() }.root as Parent)


