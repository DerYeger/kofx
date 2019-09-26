package eu.yeger.kotlin.javafx

import javafx.scene.Node
import javafx.scene.Parent
import javafx.scene.Scene

@DslMarker
@Target(AnnotationTarget.CLASS, AnnotationTarget.TYPE)
annotation class FXDSL

open class View {
    lateinit var root: Node
}

inline fun view(init: @FXDSL View.() -> Node) =
    View().apply { root = init() }.root

inline fun scene(init: @FXDSL View.() -> Parent) =
    Scene(View().apply { root = init() }.root as Parent)


