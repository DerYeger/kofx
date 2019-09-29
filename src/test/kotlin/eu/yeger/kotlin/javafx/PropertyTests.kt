package eu.yeger.kotlin.javafx

import com.sun.javafx.collections.ObservableMapWrapper
import javafx.beans.binding.Bindings.createBooleanBinding
import javafx.beans.property.*
import javafx.scene.control.Label
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.testfx.framework.junit5.ApplicationTest
import java.util.concurrent.Callable
import java.util.concurrent.ThreadLocalRandom

class PropertyTests {

    private val rand = ThreadLocalRandom.current()

    @Nested
    inner class GenericPropertyTests {
        private fun <T> testConfiguration(property: Property<T>, first: T, second: T) {
            var delegate by property.delegation()
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
    inner class BooleanPropertyTests : ApplicationTest() {
        private fun testConfiguration(property: BooleanProperty, first: Boolean, second: Boolean) {
            var delegate by property.delegation()
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

        @Test
        fun testFlipExtension() {
            val property = SimpleBooleanProperty(false)
            val value by property.delegation()
            assertFalse(value)

            property.flip()
            assertTrue(value)

            assertFalse(property.flipped())
        }

        @Test
        fun testBindingVisibilityToProperty() {
            val property = SimpleBooleanProperty(false)
            val label = Label().apply {
                bindVisibility(property)
            }
            assertEquals(property.value, label.isVisible)

            property.flip()
            assertEquals(property.value, label.isVisible)

            property.flip()
            assertEquals(property.value, label.isVisible)
        }

        @Test
        fun testBindingVisibilityToBinding() {
            val property = SimpleBooleanProperty(false)
            val binding = createBooleanBinding(Callable { property.value }, property)
            val label = Label().apply {
                bindVisibility(binding)
            }
            assertEquals(property.value, label.isVisible)

            property.flip()
            assertEquals(property.value, label.isVisible)

            property.flip()
            assertEquals(property.value, label.isVisible)
        }
    }

    @Nested
    inner class IntegerPropertyTests {
        private fun testConfiguration(property: IntegerProperty, first: Int, second: Int) {
            var delegate by property.delegation()
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
            var delegate by property.delegation()
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
            var delegate by property.delegation()
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
            var delegate by property.delegation()
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
