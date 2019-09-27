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
            withChild { label(text) }
            withChild {
                hBox {
                    alignment = Pos.CENTER_RIGHT
                    padding = Insets(10.0)
                    spacing = 10.0
                    withChild { confirmButton.wrapped() }
                    withChild { cancelButton.wrapped() }
                }
            }
        }
    }
}

inline fun ConfirmationAlert.onConfirm(crossinline block: (ActionEvent) -> Unit) {
    confirmButton.setOnAction { block(it) }
}

inline fun ConfirmationAlert.onCancel(crossinline block: (ActionEvent) -> Unit) {
    cancelButton.setOnAction { block(it) }
}

fun confirmationAlert(init: @FXMarker ConfirmationAlert.() -> Unit) {
    ConfirmationAlert().apply(init).show()
}
