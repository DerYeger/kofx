package eu.yeger.kotlin.javafx

import javafx.beans.binding.Bindings
import javafx.beans.property.SimpleBooleanProperty
import javafx.scene.control.Label
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.testfx.framework.junit5.ApplicationTest
import java.util.concurrent.Callable

class ExtensionTests : ApplicationTest() {

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
    inner class VisibilityBindingExtensionTests {

        @Test
        fun testBindingVisibilityToProperty() {
            val property = SimpleBooleanProperty(false)
            val label = Label().apply {
                bindVisibility(property)
            }
            Assertions.assertEquals(property.value, label.isVisible)

            property.flip()
            Assertions.assertEquals(property.value, label.isVisible)

            property.flip()
            Assertions.assertEquals(property.value, label.isVisible)
        }

        @Test
        fun testBindingVisibilityToBinding() {
            val property = SimpleBooleanProperty(false)
            val binding = Bindings.createBooleanBinding(Callable { property.value }, property)
            val label = Label().apply {
                bindVisibility(binding)
            }
            Assertions.assertEquals(property.value, label.isVisible)

            property.flip()
            Assertions.assertEquals(property.value, label.isVisible)

            property.flip()
            Assertions.assertEquals(property.value, label.isVisible)
        }
    }
}
