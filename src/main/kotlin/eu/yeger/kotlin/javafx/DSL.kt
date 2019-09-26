package eu.yeger.kotlin.javafx

import javafx.scene.Node
import javafx.scene.Parent
import javafx.scene.Scene

@DslMarker
@Target(AnnotationTarget.CLASS, AnnotationTarget.TYPE)
annotation class FXDSL

open class Fragment<T: Node>(val builder: @FXDSL Fragment<T>.() -> T) {
    fun instance() = builder()
}

fun <T: Node> fragment(init: @FXDSL Fragment<T>.() -> T) = Fragment(init)

fun scene(init: @FXDSL Fragment<in Parent>.() -> Parent) = Scene(Fragment(init).instance())
