package eu.yeger.kofx.alert

import eu.yeger.kofx.*
import eu.yeger.kofx.fragment.asSingletonFragment
import eu.yeger.kofx.fragment.child
import eu.yeger.kofx.fragment.label
import eu.yeger.kofx.fragment.vBox
import javafx.event.ActionEvent
import javafx.geometry.Insets
import javafx.geometry.Pos
import javafx.scene.control.Button

class InformationAlert : Alert() {
    val confirmButton = Button("Confirm").apply { isDefaultButton = true }

    override fun build() = scene {
        vBox {
            alignment = Pos.CENTER_RIGHT
            padding = Insets(10.0)
            spacing = 10.0
            child { label(text) }
            child { confirmButton.asSingletonFragment() }
        }
    }
}

inline fun InformationAlert.onConfirm(crossinline block: (ActionEvent) -> Unit) {
    confirmButton.setOnAction {
        hide()
        block(it)
    }
}

fun informationAlert(init: @FXMarker InformationAlert.() -> Unit) {
    InformationAlert().apply(init).show()
}
