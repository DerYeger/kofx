package eu.yeger.kotlin.javafx

import javafx.beans.property.*
import kotlin.reflect.KProperty

fun <T> Property<T>.delegation() = Delegate(this)

class Delegate<T>(private val property: Property<T>) {

    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: T) {
        this.property.value = value
    }

    operator fun getValue(thisRef: Any?, property: KProperty<*>): T = this.property.value
}

fun BooleanProperty.delegation() = BooleanDelegate(this)

class BooleanDelegate(private val property: BooleanProperty) {

    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: Boolean) {
        this.property.value = value
    }

    operator fun getValue(thisRef: Any?, property: KProperty<*>): Boolean = this.property.value
}

fun IntegerProperty.delegation() = IntegerDelegate(this)

class IntegerDelegate(private val property: IntegerProperty) {

    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: Int) {
        this.property.value = value
    }

    operator fun getValue(thisRef: Any?, property: KProperty<*>): Int = this.property.value
}

fun LongProperty.delegation() = LongDelegate(this)

class LongDelegate(private val property: LongProperty) {

    operator fun setValue(thisRef: Any?, property: KProperty<*>, value:  Long) {
        this.property.value = value
    }

    operator fun getValue(thisRef: Any?, property: KProperty<*>):  Long = this.property.value
}

fun DoubleProperty.delegation() = DoubleDelegate(this)

class DoubleDelegate(private val property: DoubleProperty) {

    operator fun setValue(thisRef: Any?, property: KProperty<*>, value:  Double) {
        this.property.value = value
    }

    operator fun getValue(thisRef: Any?, property: KProperty<*>):  Double = this.property.value
}

fun FloatProperty.delegation() = FloatDelegate(this)

class FloatDelegate(private val property: FloatProperty) {

    operator fun setValue(thisRef: Any?, property: KProperty<*>, value:  Float) {
        this.property.value = value
    }

    operator fun getValue(thisRef: Any?, property: KProperty<*>):  Float = this.property.value
}
