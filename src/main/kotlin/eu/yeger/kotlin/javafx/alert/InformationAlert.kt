package eu.yeger.kotlin.javafx.alert

import eu.yeger.kotlin.javafx.FXDSL
import eu.yeger.kotlin.javafx.label
import eu.yeger.kotlin.javafx.scene
import eu.yeger.kotlin.javafx.vBox
import javafx.geometry.Insets
import javafx.geometry.Pos
import javafx.scene.control.Button

class InformationAlert : ButtonAlert() {
    lateinit var confirmButton: Button

    override fun build() = scene {
        vBox {
            alignment = Pos.CENTER_RIGHT
            padding = Insets(10.0)
            spacing = 10.0
            label(text)
            children.add(confirmButton)
        }
    }
}

fun informationAlert(init: @FXDSL InformationAlert.() -> Unit) {
    InformationAlert().apply(init).show()
}