package eu.yeger.kofx

import javafx.scene.Parent
import javafx.scene.Scene

@DslMarker
@Target(AnnotationTarget.CLASS, AnnotationTarget.TYPE)
annotation class FXMarker

fun scene(init: () -> Fragment<Parent>) = Scene(init().instance())
