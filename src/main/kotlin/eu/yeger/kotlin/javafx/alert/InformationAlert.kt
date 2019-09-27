package eu.yeger.kotlin.javafx.alert

import eu.yeger.kotlin.javafx.*
import javafx.event.ActionEvent
import javafx.geometry.Insets
import javafx.geometry.Pos
import javafx.scene.Scene
import javafx.scene.control.Button

class InformationAlert : Alert() {
    val confirmButton = Button("Confirm").apply { isDefaultButton = true }

    override fun build(): Scene {
        return scene {
            vBox {
                alignment = Pos.CENTER_RIGHT
                padding = Insets(10.0)
                spacing = 10.0
                withChild { label(text) }
                withChild { confirmButton.wrapped() }
            }
        }
    }
}

inline fun InformationAlert.onConfirm(crossinline block: (ActionEvent) -> Unit) {
    confirmButton.setOnAction { block(it) }
}

fun informationAlert(init: @FXMarker InformationAlert.() -> Unit) {
    InformationAlert().apply(init).show()
}
