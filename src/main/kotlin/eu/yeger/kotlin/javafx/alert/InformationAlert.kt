package eu.yeger.kotlin.javafx.alert

import eu.yeger.kotlin.javafx.*
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
            label(text)
            withChild(confirmButton)
        }
    }
}

inline fun InformationAlert.onConfirm(crossinline block: (ActionEvent) -> Unit) {
    confirmButton.setOnAction { block(it) }
}

fun informationAlert(init: @FXDSL InformationAlert.() -> Unit) {
    InformationAlert().apply(init).show()
}
