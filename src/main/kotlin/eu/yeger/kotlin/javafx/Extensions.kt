package eu.yeger.kotlin.javafx

import javafx.beans.binding.BooleanBinding
import javafx.beans.binding.DoubleBinding
import javafx.beans.property.BooleanProperty
import javafx.beans.property.DoubleProperty
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
// LayoutProperties

fun <T: Node> T.bindLayoutX(property: DoubleProperty) {
    layoutXProperty().bind(property)
}

fun <T: Node> T.bindLayoutX(binding: DoubleBinding) {
    layoutXProperty().bind(binding)
}

fun <T: Node> T.bindLayoutY(property: DoubleProperty) {
    layoutYProperty().bind(property)
}

fun <T: Node> T.bindLayoutY(binding: DoubleBinding) {
    layoutYProperty().bind(binding)
}

// ===============================================================
// OpacityProperty

fun <T: Node> T.bindOpacity(property: DoubleProperty) {
    opacityProperty().bind(property)
}

fun <T: Node> T.bindOpacity(binding: DoubleBinding) {
    opacityProperty().bind(binding)
}

// ===============================================================
// PickOnBoundsProperty

fun <T: Node> T.bindPickOnBounds(property: BooleanProperty) {
    pickOnBoundsProperty().bind(property)
}

fun <T: Node> T.bindPickOnBounds(binding: BooleanBinding) {
    pickOnBoundsProperty().bind(binding)
}

// ===============================================================
// RotateProperty

fun <T: Node> T.bindRotation(property: DoubleProperty) {
    rotateProperty().bind(property)
}

fun <T: Node> T.bindRotation(binding: DoubleBinding) {
    rotateProperty().bind(binding)
}

// ===============================================================
// ScaleProperties

fun <T: Node> T.bindScaleX(property: DoubleProperty) {
    scaleXProperty().bind(property)
}

fun <T: Node> T.bindScaleX(binding: DoubleBinding) {
    scaleXProperty().bind(binding)
}

fun <T: Node> T.bindScaleY(property: DoubleProperty) {
    scaleYProperty().bind(property)
}

fun <T: Node> T.bindScaleY(binding: DoubleBinding) {
    scaleYProperty().bind(binding)
}

fun <T: Node> T.bindScaleZ(property: DoubleProperty) {
    scaleZProperty().bind(property)
}

fun <T: Node> T.bindScaleZ(binding: DoubleBinding) {
    scaleZProperty().bind(binding)
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
// TranslateProperties

fun <T: Node> T.bindTranslateX(property: DoubleProperty) {
    translateXProperty().bind(property)
}

fun <T: Node> T.bindTranslateX(binding: DoubleBinding) {
    translateXProperty().bind(binding)
}

fun <T: Node> T.bindTranslateY(property: DoubleProperty) {
    translateYProperty().bind(property)
}

fun <T: Node> T.bindTranslateY(binding: DoubleBinding) {
    translateYProperty().bind(binding)
}

fun <T: Node> T.bindTranslateZ(property: DoubleProperty) {
    translateZProperty().bind(property)
}

fun <T: Node> T.bindTranslateZ(binding: DoubleBinding) {
    translateZProperty().bind(binding)
}

// ===============================================================
// ViewOrderProperty

fun <T: Node> T.bindViewOrder(property: DoubleProperty) {
    viewOrderProperty().bind(property)
}

fun <T: Node> T.bindViewOrder(binding: DoubleBinding) {
    viewOrderProperty().bind(binding)
}

// ===============================================================
// VisibleProperty

fun <T: Node> T.bindVisible(property: BooleanProperty) {
    visibleProperty().bind(property)
}

fun <T: Node> T.bindVisible(binding: BooleanBinding) {
    visibleProperty().bind(binding)
}
