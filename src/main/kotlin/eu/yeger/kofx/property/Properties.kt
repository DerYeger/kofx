package eu.yeger.kofx.property

import javafx.beans.property.*
import kotlin.reflect.KProperty

// ===============================================================
// Property

fun <T> Property<T>.delegate() = PropertyDelegate(this)

fun <T> objectProperty(initialValue: T) = PropertyDelegate(initialValue)

class PropertyDelegate<T>(delegate: Property<T>) : Property<T> by delegate {

    constructor(initialValue: T? = null) : this(SimpleObjectProperty<T>(initialValue))

    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: T) {
        this.value = value
    }

    operator fun getValue(thisRef: Any?, property: KProperty<*>): T = value
}

// ===============================================================
// BooleanProperty

fun Property<Boolean>.flip() {
    value = value.not()
}

fun Property<Boolean>.flipped(): Boolean {
    value = value.not()
    return value
}

fun booleanProperty(initialValue: Boolean = false) = BooleanPropertyDelegate(initialValue)

class BooleanPropertyDelegate(initialValue: Boolean = false) : SimpleBooleanProperty(initialValue) {

    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: Boolean) {
        this.value = value
    }

    operator fun getValue(thisRef: Any?, property: KProperty<*>): Boolean = value
}

// ===============================================================
// IntegerProperty

fun integerProperty(initialValue: Int = 0) = IntegerPropertyDelegate(initialValue)

class IntegerPropertyDelegate(initialValue: Int = 0) : SimpleIntegerProperty(initialValue) {

    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: Int) {
        this.value = value
    }

    operator fun getValue(thisRef: Any?, property: KProperty<*>): Int = value
}

// ===============================================================
// LongProperty

fun longProperty(initialValue: Long = 0L) = LongPropertyDelegate(initialValue)

class LongPropertyDelegate(initialValue: Long = 0L) : SimpleLongProperty(initialValue) {

    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: Long) {
        this.value = value
    }

    operator fun getValue(thisRef: Any?, property: KProperty<*>): Long = value
}

// ===============================================================
// DoubleProperty

fun doubleProperty(initialValue: Double = 0.0) = DoublePropertyDelegate(initialValue)

class DoublePropertyDelegate(initialValue: Double = 0.0) : SimpleDoubleProperty(initialValue) {

    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: Double) {
        this.value = value
    }

    operator fun getValue(thisRef: Any?, property: KProperty<*>): Double = value
}

// ===============================================================
// FloatProperty

fun floatProperty(initialValue: Float = 0F) = FloatPropertyDelegate(initialValue)

class FloatPropertyDelegate(initialValue: Float = 0F) : SimpleFloatProperty(initialValue) {

    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: Float) {
        this.value = value
    }

    operator fun getValue(thisRef: Any?, property: KProperty<*>): Float = value
}

// ===============================================================
// StringProperty

fun Property<String>.delegate() = StringPropertyDelegate(this)

fun stringProperty(initialValue: String? = null) = StringPropertyDelegate(initialValue)

class StringPropertyDelegate(delegate: Property<String>) : Property<String> by delegate {

    constructor(initialValue: String? = null) : this(SimpleStringProperty(initialValue))

    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: String?) {
        this.value = value
    }

    operator fun getValue(thisRef: Any?, property: KProperty<*>): String? = value
}
