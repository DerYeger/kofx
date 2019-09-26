package eu.yeger.kotlin.javafx.alert

import eu.yeger.kotlin.javafx.*
import javafx.geometry.Insets
import javafx.geometry.Pos
import javafx.scene.control.Button

class ConfirmationAlert : Alert() {
    val confirmButton = Button("Confirm")
    val cancelButton = Button("Cancel")

    override fun build() = scene {
        vBox {
            alignment = Pos.CENTER_RIGHT
            padding = Insets(10.0)
            spacing = 10.0
            label(text)
            hBox {
                alignment = Pos.CENTER_RIGHT
                padding = Insets(10.0)
                spacing = 10.0
                children.add(confirmButton)
                children.add(cancelButton)
            }
        }
    }
}

fun confirmationAlert(init: @FXDSL ConfirmationAlert.() -> Unit) {
    ConfirmationAlert().apply(init).show()
}