package eu.yeger.kotlin.javafx.alert

import eu.yeger.kotlin.javafx.*
import javafx.event.ActionEvent
import javafx.geometry.Insets
import javafx.geometry.Pos
import javafx.scene.control.Button

class ConfirmationAlert : Alert() {
    val confirmButton = Button("Confirm").apply { isDefaultButton = true }
    val cancelButton = Button("Cancel").apply { isCancelButton = true }

    override fun build() = scene {
        vBox {
            alignment = Pos.CENTER_RIGHT
            padding = Insets(10.0)
            spacing = 10.0
            child { label(text) }
            child {
                hBox {
                    alignment = Pos.CENTER_RIGHT
                    padding = Insets(10.0)
                    spacing = 10.0
                    child { confirmButton.asFragment() }
                    child { cancelButton.asFragment() }
                }
            }
        }
    }
}

inline fun ConfirmationAlert.onConfirm(crossinline block: (ActionEvent) -> Unit) {
    confirmButton.setOnAction {
        hide()
        block(it)
    }
}

inline fun ConfirmationAlert.onCancel(crossinline block: (ActionEvent) -> Unit) {
    cancelButton.setOnAction {
        hide()
        block(it)
    }
}

fun confirmationAlert(init: @FXMarker ConfirmationAlert.() -> Unit) {
    ConfirmationAlert().apply(init).show()
}
