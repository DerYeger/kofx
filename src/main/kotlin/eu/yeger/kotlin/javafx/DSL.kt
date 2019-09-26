package eu.yeger.kotlin.javafx

import javafx.scene.Node
import javafx.scene.Parent
import javafx.scene.Scene

@DslMarker
@Target(AnnotationTarget.CLASS, AnnotationTarget.TYPE)
annotation class FXDSL

open class Fragment<out T: Node>(initializer: @FXDSL Fragment<T>.() -> T) {
    val root = initializer()
}

fun <T: Node> fragment(init: @FXDSL Fragment<T>.() -> T) = Fragment(init)

fun scene(init: @FXDSL Fragment<Parent>.() -> Parent) = Scene(Fragment(init).root)
