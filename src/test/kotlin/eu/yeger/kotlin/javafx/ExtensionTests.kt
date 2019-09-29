package eu.yeger.kotlin.javafx

import javafx.beans.binding.Bindings
import javafx.beans.property.SimpleBooleanProperty
import javafx.scene.control.Label
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.testfx.framework.junit5.ApplicationTest
import java.util.concurrent.Callable

class ExtensionTests : ApplicationTest() {

    @Nested
    inner class DisabledBindingExtensionTests {

        @Test
        fun testBindingDisabledToProperty() {
            val property = SimpleBooleanProperty(false)
            val label = Label().apply {
                bindDisabled(property)
            }
            assertEquals(property.value, label.isDisabled)

            property.flip()
            assertEquals(property.value, label.isDisabled)

            property.flip()
            assertEquals(property.value, label.isDisabled)
        }

        @Test
        fun testBindingDisabledToBinding() {
            val property = SimpleBooleanProperty(false)
            val binding = Bindings.createBooleanBinding(Callable { property.value }, property)
            val label = Label().apply {
                bindDisabled(binding)
            }
            assertEquals(property.value, label.isDisabled)

            property.flip()
            assertEquals(property.value, label.isDisabled)

            property.flip()
            assertEquals(property.value, label.isDisabled)
        }
    }

    @Nested
    inner class StyleExtensionTests {

        @Test
        fun testStyleClassExtension() {
            val label = label {
                styleClasses("first", "second")
            }.instance()
            assertEquals(listOf("label", "first", "second"), label.styleClass)
        }

        @Test
        fun testStyleSheetExtension() {
            val label = label {
                styleSheets("first", "second")
            }.instance()
            assertEquals(listOf("first", "second"), label.stylesheets)
        }
    }

    @Nested
    inner class VisibleBindingExtensionTests {

        @Test
        fun testBindingVisibleToProperty() {
            val property = SimpleBooleanProperty(false)
            val label = Label().apply {
                bindVisible(property)
            }
            assertEquals(property.value, label.isVisible)

            property.flip()
            assertEquals(property.value, label.isVisible)

            property.flip()
            assertEquals(property.value, label.isVisible)
        }

        @Test
        fun testBindingVisibleToBinding() {
            val property = SimpleBooleanProperty(false)
            val binding = Bindings.createBooleanBinding(Callable { property.value }, property)
            val label = Label().apply {
                bindVisible(binding)
            }
            assertEquals(property.value, label.isVisible)

            property.flip()
            assertEquals(property.value, label.isVisible)

            property.flip()
            assertEquals(property.value, label.isVisible)
        }
    }
}
