package eu.yeger.kofx.property

import javafx.beans.property.*
import kotlin.reflect.KProperty

// ===============================================================
// Property

fun <T> objectProperty(initialValue: T) = SimpleObjectProperty<T>(initialValue)
fun <T> objectPropertyDelegate(initialValue: T) = SimpleObjectProperty<T>(initialValue).delegate()

fun <T> Property<T>.delegate() = PropertyDelegate(this)

class PropertyDelegate<T>(private val property: Property<T>) {

    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: T) {
        this.property.value = value
    }

    operator fun getValue(thisRef: Any?, property: KProperty<*>): T = this.property.value
}

// ===============================================================
// BooleanProperty

fun booleanProperty(initialValue: Boolean) = SimpleBooleanProperty(initialValue)
fun booleanPropertyDelegate(initialValue: Boolean) = SimpleBooleanProperty(initialValue).delegate()

fun BooleanProperty.flip() {
    value = value.not()
}

fun BooleanProperty.flipped(): Boolean {
    value = value.not()
    return value
}

fun BooleanProperty.delegate() = BooleanPropertyDelegate(this)

class BooleanPropertyDelegate(private val property: BooleanProperty) {

    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: Boolean) {
        this.property.value = value
    }

    operator fun getValue(thisRef: Any?, property: KProperty<*>): Boolean = this.property.value
}

// ===============================================================
// IntegerProperty

fun integerProperty(initialValue: Int) = SimpleIntegerProperty(initialValue)
fun integerPropertyDelegate(initialValue: Int) = SimpleIntegerProperty(initialValue).delegate()

fun IntegerProperty.delegate() = IntegerPropertyDelegate(this)

class IntegerPropertyDelegate(private val property: IntegerProperty) {

    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: Int) {
        this.property.value = value
    }

    operator fun getValue(thisRef: Any?, property: KProperty<*>): Int = this.property.value
}

// ===============================================================
// LongProperty

fun longProperty(initialValue: Long) = SimpleLongProperty(initialValue)
fun longPropertyDelegate(initialValue: Long) = SimpleLongProperty(initialValue).delegate()

fun LongProperty.delegate() = LongPropertyDelegate(this)

class LongPropertyDelegate(private val property: LongProperty) {

    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: Long) {
        this.property.value = value
    }

    operator fun getValue(thisRef: Any?, property: KProperty<*>): Long = this.property.value
}

// ===============================================================
// DoubleProperty

fun doubleProperty(initialValue: Double) = SimpleDoubleProperty(initialValue)
fun doublePropertyDelegate(initialValue: Double) = SimpleDoubleProperty(initialValue).delegate()

fun DoubleProperty.delegate() = DoublePropertyDelegate(this)

class DoublePropertyDelegate(private val property: DoubleProperty) {

    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: Double) {
        this.property.value = value
    }

    operator fun getValue(thisRef: Any?, property: KProperty<*>): Double = this.property.value
}

// ===============================================================
// FloatProperty

fun floatProperty(initialValue: Float) = SimpleFloatProperty(initialValue)
fun floatPropertyDelegate(initialValue: Float) = SimpleFloatProperty(initialValue).delegate()

fun FloatProperty.delegate() = FloatPropertyDelegate(this)

class FloatPropertyDelegate(private val property: FloatProperty) {

    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: Float) {
        this.property.value = value
    }

    operator fun getValue(thisRef: Any?, property: KProperty<*>): Float = this.property.value
}

// ===============================================================
// StringProperty

fun stringProperty(initialValue: String?) = SimpleStringProperty(initialValue)
fun stringPropertyDelegate(initialValue: String) = SimpleStringProperty(initialValue).delegate()
