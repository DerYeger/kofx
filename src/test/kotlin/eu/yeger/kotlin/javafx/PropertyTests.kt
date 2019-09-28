package eu.yeger.kotlin.javafx

import com.sun.javafx.collections.ObservableMapWrapper
import javafx.beans.property.*
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import java.util.concurrent.ThreadLocalRandom

class PropertyTests {

    private val rand = ThreadLocalRandom.current()

    @Nested
    inner class GenericPropertyTests {
        private fun <T> testConfiguration(property: Property<T>, first: T, second: T) {
            var delegate by property
            assertEquals(property.value, delegate)

            delegate = first
            assertEquals(property.value, delegate)

            property.value = second
            assertEquals(property.value, delegate)
        }

        @Test
        fun testSimpleStringProperty() {
            testConfiguration(SimpleStringProperty(), "First", "Second")
        }

        @Test
        fun testSimpleMapProperty() {
            testConfiguration(SimpleMapProperty<Int, Int>(), ObservableMapWrapper(mapOf(0 to 1)), ObservableMapWrapper(mapOf(1 to 2)))
        }

        @Test
        fun testSimpleObjectProperty() {
            testConfiguration(SimpleObjectProperty<Pair<Int, Int>>(), 0 to 1, 1 to 2)
        }

        @Test
        fun testSimpleObjectPropertyWithNullValues() {
            testConfiguration(SimpleObjectProperty<Pair<Int, Int>>(), 0 to 1, null)
        }
    }

    @Nested
    inner class BooleanPropertyTests {
        private fun testConfiguration(property: BooleanProperty, first: Boolean, second: Boolean) {
            var delegate by property
            assertEquals(property.value, delegate)

            delegate = first
            assertEquals(property.value, delegate)

            property.value = second
            assertEquals(property.value, delegate)
        }

        @Test
        fun testSimpleBooleanProperty() {
            testConfiguration(SimpleBooleanProperty(), rand.nextBoolean(), rand.nextBoolean())
        }
    }

    @Nested
    inner class IntegerPropertyTests {
        private fun testConfiguration(property: IntegerProperty, first: Int, second: Int) {
            var delegate by property
            assertEquals(property.value, delegate)

            delegate = first
            assertEquals(property.value, delegate)

            property.value = second
            assertEquals(property.value, delegate)
        }

        @Test
        fun testSimpleIntegerProperty() {
            testConfiguration(SimpleIntegerProperty(), rand.nextInt(), rand.nextInt())
        }
    }

    @Nested
    inner class LongPropertyTests {
        private fun testConfiguration(property: LongProperty, first: Long, second: Long) {
            var delegate by property
            assertEquals(property.value, delegate)

            delegate = first
            assertEquals(property.value, delegate)

            property.value = second
            assertEquals(property.value, delegate)
        }

        @Test
        fun testSimpleLongProperty() {
            testConfiguration(SimpleLongProperty(), rand.nextLong(), rand.nextLong())
        }
    }

    @Nested
    inner class DoublePropertyTests {
        private fun testConfiguration(property: DoubleProperty, first: Double, second: Double) {
            var delegate by property
            assertEquals(property.value, delegate)

            delegate = first
            assertEquals(property.value, delegate)

            property.value = second
            assertEquals(property.value, delegate)
        }

        @Test
        fun testSimpleDoubleProperty() {
            testConfiguration(SimpleDoubleProperty(), rand.nextDouble(), rand.nextDouble())
        }
    }

    @Nested
    inner class FloatPropertyTests {
        private fun testConfiguration(property: FloatProperty, first: Float, second: Float) {
            var delegate by property
            assertEquals(property.value, delegate)

            delegate = first
            assertEquals(property.value, delegate)

            property.value = second
            assertEquals(property.value, delegate)
        }

        @Test
        fun testSimpleFloatProperty() {
            testConfiguration(SimpleFloatProperty(), rand.nextFloat(), rand.nextFloat())
        }
    }
}