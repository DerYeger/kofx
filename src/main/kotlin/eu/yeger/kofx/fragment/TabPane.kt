package eu.yeger.kofx.fragment

import eu.yeger.kofx.FXMarker
import javafx.geometry.Insets
import javafx.geometry.Side
import javafx.scene.Node
import javafx.scene.control.Tab
import javafx.scene.control.TabPane
import javafx.scene.layout.StackPane

inline fun tabPane(crossinline init: @FXMarker TabPane.() -> Unit = {}) =
    Fragment { TabPane().apply(init) }

fun TabPane.centerTabs() {
    val region = lookup(".headers-region") as StackPane
    val regionTop = when (side!!) {
        Side.TOP -> lookup(".tab-pane:top *.tab-header-area")
        Side.RIGHT -> lookup(".tab-pane:right *.tab-header-area")
        Side.BOTTOM -> lookup(".tab-pane:bottom *.tab-header-area")
        Side.LEFT -> lookup(".tab-pane:left *.tab-header-area")
    } as StackPane
    val insets = regionTop.padding
    regionTop.padding = when (side!!) {
        Side.TOP, Side.BOTTOM -> Insets(
            insets.top,
            insets.right,
            insets.bottom,
            regionTop.width / 2 - region.width / 2
        )
        Side.LEFT, Side.RIGHT -> Insets(
            regionTop.height / 2 - region.height / 2,
            insets.right,
            insets.bottom,
            insets.left
        )
    }
}

inline fun TabPane.tab(init: @FXMarker Tab.() -> Unit) {
    tabs += Tab().apply(init)
}

fun TabPane.tabs(blocks: List<@FXMarker Tab.() -> Unit>) {
    blocks.map { tab(it) }
}

inline fun <T : Node> Tab.content(block: @FXMarker Child.() -> Fragment<T>) {
    content = block(Child).instance()
}
