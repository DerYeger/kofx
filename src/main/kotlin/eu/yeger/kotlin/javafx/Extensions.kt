package eu.yeger.kotlin.javafx

import javafx.beans.binding.BooleanBinding
import javafx.beans.property.BooleanProperty
import javafx.scene.Node
import javafx.scene.Parent

// ===============================================================
// DisabledProperty

fun <T: Node> T.bindDisabled(property: BooleanProperty) {
    disableProperty().bind(property)
}

fun <T: Node> T.bindDisabled(binding: BooleanBinding) {
    disableProperty().bind(binding)
}

// ===============================================================
// StyleClass

fun <T: Node> T.styleClasses(vararg classes: String) {
    styleClass.addAll(classes)
}

fun <T: Parent> T.styleSheets(vararg sheets: String) {
    stylesheets.addAll(sheets)
}

// ===============================================================
// VisibleProperty

fun <T: Node> T.bindVisible(property: BooleanProperty) {
    visibleProperty().bind(property)
}

fun <T: Node> T.bindVisible(binding: BooleanBinding) {
    visibleProperty().bind(binding)
}