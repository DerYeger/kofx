package eu.yeger.kofx.property

import javafx.beans.property.*
import kotlin.reflect.KProperty

// ===============================================================
// Property

fun <T> Property<T>.delegate() = PropertyDelegate(this.value)

fun <T> objectProperty(initialValue: T) = PropertyDelegate(initialValue)

class PropertyDelegate<T>(
    initialValue: T? = null,
    private val delegate: Property<T> = SimpleObjectProperty<T>(initialValue)
) : Property<T> by delegate {

    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: T) {
        delegate.value = value
    }

    operator fun getValue(thisRef: Any?, property: KProperty<*>): T = delegate.value
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

fun booleanProperty(initialValue: Boolean) = BooleanPropertyDelegate(initialValue)

class BooleanPropertyDelegate(initialValue: Boolean) : SimpleBooleanProperty(initialValue) {

    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: Boolean) {
        this.value = value
    }

    operator fun getValue(thisRef: Any?, property: KProperty<*>): Boolean = value
}

// ===============================================================
// IntegerProperty

fun integerProperty(initialValue: Int) = IntegerPropertyDelegate(initialValue)

class IntegerPropertyDelegate(initialValue: Int) : SimpleIntegerProperty(initialValue) {

    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: Int) {
        this.value = value
    }

    operator fun getValue(thisRef: Any?, property: KProperty<*>): Int = value
}

// ===============================================================
// LongProperty

fun longProperty(initialValue: Long) = LongPropertyDelegate(initialValue)

class LongPropertyDelegate(initialValue: Long) : SimpleLongProperty(initialValue) {

    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: Long) {
        this.value = value
    }

    operator fun getValue(thisRef: Any?, property: KProperty<*>): Long = value
}

// ===============================================================
// DoubleProperty

fun doubleProperty(initialValue: Double) = DoublePropertyDelegate(initialValue)

class DoublePropertyDelegate(initialValue: Double) : SimpleDoubleProperty(initialValue) {

    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: Double) {
        this.value = value
    }

    operator fun getValue(thisRef: Any?, property: KProperty<*>): Double = value
}

// ===============================================================
// FloatProperty

fun floatProperty(initialValue: Float) = FloatPropertyDelegate(initialValue)

class FloatPropertyDelegate(initialValue: Float) : SimpleFloatProperty(initialValue) {

    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: Float) {
        this.value = value
    }

    operator fun getValue(thisRef: Any?, property: KProperty<*>): Float = value
}

// ===============================================================
// StringProperty

fun stringProperty(initialValue: String?) = StringPropertyDelegate(initialValue)

class StringPropertyDelegate(initialValue: String?) : SimpleStringProperty(initialValue) {

    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: String?) {
        this.value = value
    }

    operator fun getValue(thisRef: Any?, property: KProperty<*>): String? = value
}
