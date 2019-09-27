package eu.yeger.kotlin.javafx

import javafx.scene.Node
import javafx.scene.layout.GridPane
import javafx.scene.layout.Pane

infix fun <T: Pane, U: Node> T.withChild(block: @FXMarker FragmentScope.() -> Fragment<U>): U =
    FragmentScope.fragment(block).instance().also { children.add(it) }

fun <T: Pane, U: Node> T.include(fragment: Fragment<U>) =
    fragment.instance().also { children.add(it) }

fun <U: Node> GridPane.withChild(column: Int, row: Int, block: @FXMarker FragmentScope.() -> Fragment<U>): U =
    FragmentScope.fragment(block).instance().also { add(it, column, row) }

fun <T: GridPane, U: Node> T.include(column: Int, row: Int, fragment: Fragment<U>) =
    fragment.instance().also { add(it, column, row) }
