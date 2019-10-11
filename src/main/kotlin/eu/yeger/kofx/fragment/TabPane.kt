package eu.yeger.kofx.fragment

import eu.yeger.kofx.FXMarker
import javafx.scene.Node
import javafx.scene.control.Tab
import javafx.scene.control.TabPane

inline fun tabPane(crossinline init: @FXMarker TabPane.() -> Unit = {}) =
    Fragment { TabPane().apply(init) }

fun TabPane.tab(init: @FXMarker Tab.() -> Unit) {
    tabs += Tab().apply(init)
}

fun TabPane.tabs(blocks: List<@FXMarker Tab.() -> Unit>) {
    blocks.map { tab(it) }
}

fun <T : Node> Tab.content(block: @FXMarker Child.() -> Fragment<T>) {
    content = block(Child).instance()
}
