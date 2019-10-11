package eu.yeger.kofx.property

import com.sun.javafx.collections.ObservableMapWrapper
import javafx.beans.property.*
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import java.util.concurrent.ThreadLocalRandom

class PropertyDelegateTests {

    private val rand = ThreadLocalRandom.current()

    @Nested
    inner class GenericPropertyDelegateTests {
        private fun <T> testConfiguration(property: Property<T>, first: T, second: T) {
            var delegate by property.delegate()
            assertEquals(property.value, delegate)

            delegate = first
            assertEquals(property.value, delegate)

            property.value = second
            assertEquals(property.value, delegate)
        }

        @Test
        fun `test SimpleStringProperty delegation`() {
            testConfiguration(stringProperty(null), "First", "Second")
        }

        @Test
        fun `test SimpleMapProperty delegation`() {
            testConfiguration(
                SimpleMapProperty<Int, Int>(),
                ObservableMapWrapper(mapOf(0 to 1)),
                ObservableMapWrapper(mapOf(1 to 2))
            )
        }

        @Test
        fun `test SimpleObjectProperty delegation`() {
            testConfiguration(objectProperty<Pair<Int, Int>>(0 to 1), 1 to 2, 2 to 3)
        }

        @Test
        fun `test nullable SimpleObjectProperty delegation`() {
            testConfiguration(objectProperty<Pair<Int, Int>?>(0 to 1), 1 to 2, null)
        }
    }

    @Nested
    inner class BooleanPropertyDelegateTests {
        private fun testConfiguration(property: BooleanProperty, first: Boolean, second: Boolean) {
            var delegate by property.delegate()
            assertEquals(property.value, delegate)

            delegate = first
            assertEquals(property.value, delegate)

            property.value = second
            assertEquals(property.value, delegate)
        }

        @Test
        fun `test SimpleBooleanProperty delegation`() {
            testConfiguration(booleanProperty(false), rand.nextBoolean(), rand.nextBoolean())
        }

        @Test
        fun `test BooleanProperty flip extension`() {
            val property = SimpleBooleanProperty(false)
            val value by property.delegate()
            assertFalse(value)

            property.flip()
            assertTrue(value)

            assertFalse(property.flipped())
        }
    }

    @Nested
    inner class IntegerPropertyDelegateTests {
        private fun testConfiguration(property: IntegerProperty, first: Int, second: Int) {
            var delegate by property.delegate()
            assertEquals(property.value, delegate)

            delegate = first
            assertEquals(property.value, delegate)

            property.value = second
            assertEquals(property.value, delegate)
        }

        @Test
        fun `test SimpleIntegerProperty delegation`() {
            testConfiguration(integerProperty(0), rand.nextInt(), rand.nextInt())
        }
    }

    @Nested
    inner class LongPropertyDelegateTests {
        private fun testConfiguration(property: LongProperty, first: Long, second: Long) {
            var delegate by property.delegate()
            assertEquals(property.value, delegate)

            delegate = first
            assertEquals(property.value, delegate)

            property.value = second
            assertEquals(property.value, delegate)
        }

        @Test
        fun `test SimpleLongProperty delegation`() {
            testConfiguration(longProperty(0), rand.nextLong(), rand.nextLong())
        }
    }

    @Nested
    inner class DoublePropertyDelegateTests {
        private fun testConfiguration(property: DoubleProperty, first: Double, second: Double) {
            var delegate by property.delegate()
            assertEquals(property.value, delegate)

            delegate = first
            assertEquals(property.value, delegate)

            property.value = second
            assertEquals(property.value, delegate)
        }

        @Test
        fun `test SimpleDoubleProperty delegation`() {
            testConfiguration(doubleProperty(0.0), rand.nextDouble(), rand.nextDouble())
        }
    }

    @Nested
    inner class FloatPropertyDelegateTests {
        private fun testConfiguration(property: FloatProperty, first: Float, second: Float) {
            var delegate by property.delegate()
            assertEquals(property.value, delegate)

            delegate = first
            assertEquals(property.value, delegate)

            property.value = second
            assertEquals(property.value, delegate)
        }

        @Test
        fun `test SimpleFloatProperty delegation`() {
            testConfiguration(floatProperty(0F), rand.nextFloat(), rand.nextFloat())
        }
    }
}
