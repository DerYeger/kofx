package eu.yeger.kotlin.javafx

import javafx.scene.Parent
import javafx.scene.Scene

@DslMarker
@Target(AnnotationTarget.CLASS, AnnotationTarget.TYPE)
annotation class FXMarker

fun scene(init: () -> Fragment<out Parent>) = Scene(init().instance())
