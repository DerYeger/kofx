package eu.yeger.kotlin.javafx

import javafx.beans.value.ObservableValue
import javafx.scene.Node
import javafx.scene.Parent

// ===============================================================
// DisabledProperty

fun <T: Node> T.bindDisabled(observable: ObservableValue<Boolean>) {
    disableProperty().bind(observable)
}

// ===============================================================
// LayoutProperties

fun <T: Node> T.bindLayoutX(observable: ObservableValue<Number>) {
    layoutXProperty().bind(observable)
}

fun <T: Node> T.bindLayoutY(observable: ObservableValue<Number>) {
    layoutYProperty().bind(observable)
}

// ===============================================================
// OpacityProperty

fun <T: Node> T.bindOpacity(observable: ObservableValue<Number>) {
    opacityProperty().bind(observable)
}

// ===============================================================
// PickOnBoundsProperty

fun <T: Node> T.bindPickOnBounds(observable: ObservableValue<Boolean>) {
    pickOnBoundsProperty().bind(observable)
}

// ===============================================================
// RotateProperty

fun <T: Node> T.bindRotation(observable: ObservableValue<Number>) {
    rotateProperty().bind(observable)
}

// ===============================================================
// ScaleProperties

fun <T: Node> T.bindScaleX(observable: ObservableValue<Number>) {
    scaleXProperty().bind(observable)
}

fun <T: Node> T.bindScaleY(observable: ObservableValue<Number>) {
    scaleYProperty().bind(observable)
}

fun <T: Node> T.bindScaleZ(observable: ObservableValue<Number>) {
    scaleZProperty().bind(observable)
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

fun <T: Node> T.bindTranslateX(observable: ObservableValue<Number>) {
    translateXProperty().bind(observable)
}

fun <T: Node> T.bindTranslateY(observable: ObservableValue<Number>) {
    translateYProperty().bind(observable)
}

fun <T: Node> T.bindTranslateZ(observable: ObservableValue<Number>) {
    translateZProperty().bind(observable)
}

// ===============================================================
// ViewOrderProperty

fun <T: Node> T.bindViewOrder(observable: ObservableValue<Number>) {
    viewOrderProperty().bind(observable)
}

// ===============================================================
// VisibleProperty

fun <T: Node> T.bindVisible(observable: ObservableValue<Boolean>) {
    visibleProperty().bind(observable)
}
