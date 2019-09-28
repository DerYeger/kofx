package eu.yeger.kotlin.javafx

import javafx.scene.Node
import javafx.scene.layout.GridPane
import javafx.scene.layout.Pane

object Child {
    fun <T: Node> from(block: Child.() -> Fragment<T>) = block.invoke(this).instance()
}

infix fun <T: Pane, U: Node> T.child(block: @FXMarker Child.() -> Fragment<U>): U =
    Child.from(block).also { children.add(it) }

fun <U: Node> GridPane.child(column: Int, row: Int, block: @FXMarker Child.() -> Fragment<U>): U =
    Child.from(block).also { add(it, column, row) }
