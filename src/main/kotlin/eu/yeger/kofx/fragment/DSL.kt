package eu.yeger.kofx.fragment

import eu.yeger.kofx.fragment.Fragment
import javafx.scene.Parent
import javafx.scene.Scene

@DslMarker
@Target(AnnotationTarget.CLASS, AnnotationTarget.TYPE)
annotation class FXMarker

fun scene(init: () -> Fragment<Parent>) = Scene(init().instance())
