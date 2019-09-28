package eu.yeger.kotlin.javafx

import javafx.scene.Node
import javafx.scene.layout.GridPane
import javafx.scene.layout.Pane
import javafx.scene.layout.StackPane

infix fun <T: Pane, U: Node> T.child(block: @FXMarker FragmentScope.() -> Fragment<U>): U =
    FragmentScope.fragment(block).instance().also { children.add(it) }

fun <U: Node> GridPane.child(column: Int, row: Int, block: @FXMarker FragmentScope.() -> Fragment<U>): U =
    FragmentScope.fragment(block).instance().also { add(it, column, row) }
