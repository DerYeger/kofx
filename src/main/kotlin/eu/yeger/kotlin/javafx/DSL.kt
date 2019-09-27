package eu.yeger.kotlin.javafx

import javafx.scene.Node
import javafx.scene.Parent
import javafx.scene.Scene

@DslMarker
@Target(AnnotationTarget.CLASS, AnnotationTarget.TYPE)
annotation class FXMarker

object FragmentScope {
    fun <T: Node> fragment(block: FragmentScope.() -> Fragment<T>) = block()
}

fun scene(init: () -> Fragment<out Parent>) = Scene(init().instance())
