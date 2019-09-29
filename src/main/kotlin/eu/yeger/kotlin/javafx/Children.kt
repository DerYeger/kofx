package eu.yeger.kotlin.javafx

import javafx.scene.Node
import javafx.scene.layout.GridPane
import javafx.scene.layout.Pane

// ===============================================================
// Child scoping object

object Child {
    internal fun <T: Node> from(block: Child.() -> Fragment<T>) = block(this).instance()
}

// ===============================================================
// Pane

infix fun <T: Pane, U: Node> T.child(block: @FXMarker Child.() -> Fragment<U>): U =
    Child.from(block).also { children.add(it) }

// ===============================================================
// GridPane

fun <U: Node> GridPane.child(column: Int, row: Int, block: @FXMarker Child.() -> Fragment<U>): U =
    Child.from(block).also { add(it, column, row) }
