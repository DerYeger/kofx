package eu.yeger.kotlin.javafx

import javafx.beans.binding.BooleanBinding
import javafx.beans.property.*
import javafx.scene.Node
import kotlin.reflect.KProperty

// ===============================================================
// Property

fun <T> Property<T>.delegation() = Delegate(this)

class Delegate<T>(private val property: Property<T>) {

    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: T) {
        this.property.value = value
    }

    operator fun getValue(thisRef: Any?, property: KProperty<*>): T = this.property.value
}

// ===============================================================
// BooleanProperty

fun BooleanProperty.flip() {
    value = value.not()
}

fun BooleanProperty.flipped(): Boolean {
    value = value.not()
    return value
}

fun BooleanProperty.delegation() = BooleanDelegate(this)

class BooleanDelegate(private val property: BooleanProperty) {

    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: Boolean) {
        this.property.value = value
    }

    operator fun getValue(thisRef: Any?, property: KProperty<*>): Boolean = this.property.value
}

fun <T: Node> T.bindVisibility(property: BooleanProperty) {
    visibleProperty().bind(property)
}

fun <T: Node> T.bindVisibility(binding: BooleanBinding) {
    visibleProperty().bind(binding)
}

// ===============================================================
// IntegerProperty

fun IntegerProperty.delegation() = IntegerDelegate(this)

class IntegerDelegate(private val property: IntegerProperty) {

    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: Int) {
        this.property.value = value
    }

    operator fun getValue(thisRef: Any?, property: KProperty<*>): Int = this.property.value
}

// ===============================================================
// LongProperty

fun LongProperty.delegation() = LongDelegate(this)

class LongDelegate(private val property: LongProperty) {

    operator fun setValue(thisRef: Any?, property: KProperty<*>, value:  Long) {
        this.property.value = value
    }

    operator fun getValue(thisRef: Any?, property: KProperty<*>):  Long = this.property.value
}

// ===============================================================
// DoubleProperty

fun DoubleProperty.delegation() = DoubleDelegate(this)

class DoubleDelegate(private val property: DoubleProperty) {

    operator fun setValue(thisRef: Any?, property: KProperty<*>, value:  Double) {
        this.property.value = value
    }

    operator fun getValue(thisRef: Any?, property: KProperty<*>):  Double = this.property.value
}

// ===============================================================
// FloatProperty

fun FloatProperty.delegation() = FloatDelegate(this)

class FloatDelegate(private val property: FloatProperty) {

    operator fun setValue(thisRef: Any?, property: KProperty<*>, value:  Float) {
        this.property.value = value
    }

    operator fun getValue(thisRef: Any?, property: KProperty<*>):  Float = this.property.value
}
