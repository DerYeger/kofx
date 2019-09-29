package eu.yeger.kotlin.javafx

import javafx.beans.binding.BooleanBinding
import javafx.beans.property.BooleanProperty
import javafx.scene.Node
import javafx.scene.Parent

// ===============================================================
// StyleClass

fun <T: Node> T.styleClasses(vararg classes: String) {
    styleClass.addAll(classes)
}

fun <T: Parent> T.styleSheets(vararg sheets: String) {
    stylesheets.addAll(sheets)
}

// ===============================================================
// Visibility

fun <T: Node> T.bindVisibility(property: BooleanProperty) {
    visibleProperty().bind(property)
}

fun <T: Node> T.bindVisibility(binding: BooleanBinding) {
    visibleProperty().bind(binding)
}