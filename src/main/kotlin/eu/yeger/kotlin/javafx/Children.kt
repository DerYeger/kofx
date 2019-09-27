package eu.yeger.kotlin.javafx

import javafx.scene.Node
import javafx.scene.layout.GridPane
import javafx.scene.layout.Pane

inline infix fun <T: Pane, U: Node> T.withChild(block: () -> Fragment<U>): U =
    block().instance().also { children.add(it) }

//infix fun <T: Pane, U: Node> T.withChild(child: U): U =
//    child.also { children.add(it) }

fun <T: Pane, U: Node> T.include(fragment: Fragment<U>) =
    fragment.instance().also { children.add(it) }

inline fun <U: Node> GridPane.withChild(column: Int, row: Int, block: () -> Fragment<U>): U =
    block().instance().also { add(it, column, row) }

fun <T: GridPane, U: Node> T.include(column: Int, row: Int, fragment: Fragment<U>) =
    fragment.instance().also { add(it, column, row) }
