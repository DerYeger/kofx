package eu.yeger.kotlin.javafx

import javafx.beans.property.*
import kotlin.reflect.KProperty

operator fun <T> Property<T>.setValue(thisRef: Any?, property: KProperty<*>, value: T) {
    this.value = value
}

operator fun <T> Property<T>.getValue(thisRef: Any?, property: KProperty<*>): T = value

operator fun IntegerProperty.setValue(thisRef: Any?, property: KProperty<*>, value: Int) {
    this.value = value
}

operator fun IntegerProperty.getValue(thisRef: Any?, property: KProperty<*>): Int = value

operator fun LongProperty.setValue(thisRef: Any?, property: KProperty<*>, value: Long) {
    this.value = value
}

operator fun LongProperty.getValue(thisRef: Any?, property: KProperty<*>): Long = value

operator fun DoubleProperty.setValue(thisRef: Any?, property: KProperty<*>, value: Double) {
    this.value = value
}

operator fun DoubleProperty.getValue(thisRef: Any?, property: KProperty<*>): Double = value

operator fun FloatProperty.setValue(thisRef: Any?, property: KProperty<*>, value: Float) {
    this.value = value
}

operator fun FloatProperty.getValue(thisRef: Any?, property: KProperty<*>): Float = value
