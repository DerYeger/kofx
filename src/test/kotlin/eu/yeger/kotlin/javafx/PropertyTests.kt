package eu.yeger.kotlin.javafx

import com.sun.javafx.collections.ObservableMapWrapper
import javafx.beans.property.*
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class PropertyTests {

    @Test
    fun testSimpleBooleanProperty() {
        val booleanProperty = SimpleBooleanProperty()
        var delegatedBoolean by booleanProperty
        assertFalse(booleanProperty.value)
        assertFalse(delegatedBoolean)

        delegatedBoolean = true
        assertTrue(booleanProperty.value)
        assertTrue(delegatedBoolean)

        booleanProperty.value = false
        assertFalse(booleanProperty.value)
        assertFalse(delegatedBoolean)
    }

    @Test
    fun testSimpleIntegerProperty() {
        val integerProperty = SimpleIntegerProperty()
        var delegatedInteger by integerProperty
        assertEquals(0, integerProperty.value)
        assertEquals(0, delegatedInteger)

        delegatedInteger = 1
        assertEquals(1, integerProperty.value)
        assertEquals(1, delegatedInteger)

        integerProperty.value = 2
        assertEquals(2, integerProperty.value)
        assertEquals(2, delegatedInteger)
    }

    @Test
    fun testSimpleDoubleProperty() {
        val doubleProperty = SimpleDoubleProperty()
        var delegatedDouble by doubleProperty
        assertEquals(0.0, doubleProperty.value)
        assertEquals(0.0, delegatedDouble)

        delegatedDouble = 1.0
        assertEquals(1.0, doubleProperty.value)
        assertEquals(1.0, delegatedDouble)

        doubleProperty.value = 2.0
        assertEquals(2.0, doubleProperty.value)
        assertEquals(2.0, delegatedDouble)
    }

    @Test
    fun testSimpleStringProperty() {
        val stringProperty = SimpleStringProperty()
        var delegatedString by stringProperty
        assertEquals(null, stringProperty.value)
        assertEquals(null, delegatedString)

        delegatedString = "First"
        assertEquals("First", stringProperty.value)
        assertEquals("First", delegatedString)

        stringProperty.value = "Second"
        assertEquals("Second", stringProperty.value)
        assertEquals("Second", delegatedString)
    }

    @Test
    fun testSimpleMapProperty() {
        val mapProperty = SimpleMapProperty<Int, Int>(ObservableMapWrapper(HashMap<Int, Int>()))
        val delegatedMap by mapProperty
        assertTrue(mapProperty.value.isEmpty())
        assertTrue(delegatedMap.isEmpty())

        delegatedMap[0] = 1
        assertEquals( 1, mapProperty.value[0])
        assertEquals(1, delegatedMap[0])

        mapProperty.value[1] = 2
        assertEquals( 2, mapProperty.value[1])
        assertEquals(2, delegatedMap[1])
    }

    @Test
    fun testSimpleObjectProperty() {
        val objectProperty = SimpleObjectProperty<Pair<Int, Int>>()
        var delegatedObject by objectProperty
        assertEquals( null, objectProperty.value)
        assertEquals(null, delegatedObject)

        delegatedObject = 1 to 2
        assertEquals( 1 to 2, objectProperty.value)
        assertEquals(1 to 2, delegatedObject)

        objectProperty.value = 2 to 3
        assertEquals( 2 to 3, objectProperty.value)
        assertEquals(2 to 3, delegatedObject)
    }
}