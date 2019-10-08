package eu.yeger.kofx

import javafx.beans.binding.Bindings.createBooleanBinding
import javafx.beans.binding.Bindings.createDoubleBinding
import javafx.beans.binding.DoubleBinding
import javafx.beans.property.SimpleBooleanProperty
import javafx.beans.property.SimpleDoubleProperty
import javafx.beans.property.SimpleIntegerProperty
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
        fun `test binding DisabledProperty to property`() {
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
        fun `test binding DisabledProperty to binding`() {
            val property = SimpleBooleanProperty(false)
            val binding = createBooleanBinding(Callable { property.value }, property)
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
    inner class LayoutExtensionTests {

        @Test
        fun `test binding Layout to property`() {
            val propertyX = SimpleDoubleProperty(1.0)
            val propertyY = SimpleDoubleProperty(2.0)
            val label = label {
                bindLayoutX(propertyX)
                bindLayoutY(propertyY)
            }.instance()
            assertEquals(propertyX.value, label.layoutX)
            assertEquals(propertyY.value, label.layoutY)

            propertyX.value = 3.0
            propertyY.value = 4.0

            assertEquals(propertyX.value, label.layoutX)
            assertEquals(propertyY.value, label.layoutY)
        }

        @Test
        fun `test binding Layout to binding`() {
            val propertyX = SimpleDoubleProperty(1.0)
            val propertyY = SimpleDoubleProperty(2.0)
            val bindingX = createDoubleBinding(Callable { propertyX.value }, propertyX)
            val bindingY = createDoubleBinding(Callable { propertyY.value }, propertyY)
            val label = label {
                bindLayoutX(bindingX)
                bindLayoutY(bindingY)
            }.instance()
            assertEquals(propertyX.value, label.layoutX)
            assertEquals(propertyY.value, label.layoutY)

            propertyX.value = 3.0
            propertyY.value = 4.0

            assertEquals(propertyX.value, label.layoutX)
            assertEquals(propertyY.value, label.layoutY)
        }
    }

    @Nested
    inner class OpacityExtensionTests {

        @Test
        fun `test binding Opacity to property`() {
            val property = SimpleDoubleProperty(100.0)
            val label = label {
                bindOpacity(property)
            }.instance()
            assertEquals(property.value, label.opacity)

            property.value = 42.0
            assertEquals(property.value, label.opacity)
        }

        @Test
        fun `test binding Opacity to binding`() {
            val property = SimpleDoubleProperty(100.0)
            val binding = createDoubleBinding(Callable { property.value }, property)
            val label = label {
                bindOpacity(binding)
            }.instance()
            assertEquals(property.value, label.opacity)

            property.value = 42.0
            assertEquals(property.value, label.opacity)
        }
    }

    @Nested
    inner class PickOnBoundsBindingExtensionTests {

        @Test
        fun `test binding PickOnBounds to property`() {
            val property = SimpleBooleanProperty(false)
            val label = Label().apply {
                bindPickOnBounds(property)
            }
            assertEquals(property.value, label.isPickOnBounds)

            property.flip()
            assertEquals(property.value, label.isPickOnBounds)

            property.flip()
            assertEquals(property.value, label.isPickOnBounds)
        }

        @Test
        fun `test binding PickOnBounds to binding`() {
            val property = SimpleBooleanProperty(false)
            val binding = createBooleanBinding(Callable { property.value }, property)
            val label = Label().apply {
                bindPickOnBounds(binding)
            }
            assertEquals(property.value, label.isPickOnBounds)

            property.flip()
            assertEquals(property.value, label.isPickOnBounds)

            property.flip()
            assertEquals(property.value, label.isPickOnBounds)
        }
    }

    @Nested
    inner class RotationExtensionTests {

        @Test
        fun `test binding Rotation to property`() {
            val property = SimpleDoubleProperty(100.0)
            val label = label {
                bindRotation(property)
            }.instance()
            assertEquals(property.value, label.rotate)

            property.value = 42.0
            assertEquals(property.value, label.rotate)
        }

        @Test
        fun `test binding Rotation to binding`() {
            val property = SimpleDoubleProperty(100.0)
            val binding: DoubleBinding = createDoubleBinding(Callable { property.value }, property)
            val label = label {
                bindRotation(binding)
            }.instance()
            assertEquals(property.value, label.rotate)

            property.value = 42.0
            assertEquals(property.value, label.rotate)
        }
    }

    @Nested
    inner class ScaleExtensionTests {

        @Test
        fun `test binding Scale to property`() {
            val propertyX = SimpleDoubleProperty(1.0)
            val propertyY = SimpleDoubleProperty(2.0)
            val propertyZ = SimpleDoubleProperty(2.0)
            val label = label {
                bindScaleX(propertyX)
                bindScaleY(propertyY)
                bindScaleZ(propertyZ)
            }.instance()
            assertEquals(propertyX.value, label.scaleX)
            assertEquals(propertyY.value, label.scaleY)
            assertEquals(propertyZ.value, label.scaleZ)

            propertyX.value = 4.0
            propertyY.value = 5.0
            propertyZ.value = 6.0

            assertEquals(propertyX.value, label.scaleX)
            assertEquals(propertyY.value, label.scaleY)
            assertEquals(propertyZ.value, label.scaleZ)
        }

        @Test
        fun `test binding Scale to binding`() {
            val propertyX = SimpleDoubleProperty(1.0)
            val propertyY = SimpleDoubleProperty(2.0)
            val propertyZ = SimpleDoubleProperty(2.0)
            val bindingX = createDoubleBinding(Callable { propertyX.value }, propertyX)
            val bindingY = createDoubleBinding(Callable { propertyY.value }, propertyY)
            val bindingZ = createDoubleBinding(Callable { propertyZ.value }, propertyZ)
            val label = label {
                bindScaleX(bindingX)
                bindScaleY(bindingY)
                bindScaleZ(bindingZ)
            }.instance()
            assertEquals(propertyX.value, label.scaleX)
            assertEquals(propertyY.value, label.scaleY)
            assertEquals(propertyZ.value, label.scaleZ)

            propertyX.value = 4.0
            propertyY.value = 5.0
            propertyZ.value = 6.0

            assertEquals(propertyX.value, label.scaleX)
            assertEquals(propertyY.value, label.scaleY)
            assertEquals(propertyZ.value, label.scaleZ)
        }
    }

    @Nested
    inner class StyleExtensionTests {

        @Test
        fun `test adding StyleClasses`() {
            val label = label {
                styleClasses("first", "second")
            }.instance()
            assertEquals(listOf("label", "first", "second"), label.styleClass)
        }

        @Test
        fun `test adding StyleSheets`() {
            val label = label {
                styleSheets("first", "second")
            }.instance()
            assertEquals(listOf("first", "second"), label.stylesheets)
        }
    }

    @Nested
    inner class TranslateExtensionTests {

        @Test
        fun `test binding Translation to property`() {
            val propertyX = SimpleDoubleProperty(1.0)
            val propertyY = SimpleDoubleProperty(2.0)
            val propertyZ = SimpleDoubleProperty(2.0)
            val label = label {
                bindTranslateX(propertyX)
                bindTranslateY(propertyY)
                bindTranslateZ(propertyZ)
            }.instance()
            assertEquals(propertyX.value, label.translateX)
            assertEquals(propertyY.value, label.translateY)
            assertEquals(propertyZ.value, label.translateZ)

            propertyX.value = 4.0
            propertyY.value = 5.0
            propertyZ.value = 6.0

            assertEquals(propertyX.value, label.translateX)
            assertEquals(propertyY.value, label.translateY)
            assertEquals(propertyZ.value, label.translateZ)
        }

        @Test
        fun `test binding Translation to binding`() {
            val propertyX = SimpleDoubleProperty(1.0)
            val propertyY = SimpleDoubleProperty(2.0)
            val propertyZ = SimpleDoubleProperty(2.0)
            val bindingX = createDoubleBinding(Callable { propertyX.value }, propertyX)
            val bindingY = createDoubleBinding(Callable { propertyY.value }, propertyY)
            val bindingZ = createDoubleBinding(Callable { propertyZ.value }, propertyZ)
            val label = label {
                bindTranslateX(bindingX)
                bindTranslateY(bindingY)
                bindTranslateZ(bindingZ)
            }.instance()
            assertEquals(propertyX.value, label.translateX)
            assertEquals(propertyY.value, label.translateY)
            assertEquals(propertyZ.value, label.translateZ)

            propertyX.value = 4.0
            propertyY.value = 5.0
            propertyZ.value = 6.0

            assertEquals(propertyX.value, label.translateX)
            assertEquals(propertyY.value, label.translateY)
            assertEquals(propertyZ.value, label.translateZ)
        }
    }

    @Nested
    inner class ViewOrderExtensionTests {

        @Test
        fun `test binding ViewOrder to property`() {
            val property = SimpleIntegerProperty(100)
            val label = label {
                bindViewOrder(property)
            }.instance()
            assertEquals(property.value.toDouble(), label.viewOrder)

            property.value = 42
            assertEquals(property.value.toDouble(), label.viewOrder)
        }

        @Test
        fun `test binding ViewOrder to binding`() {
            val property = SimpleDoubleProperty(100.0)
            val binding: DoubleBinding = createDoubleBinding(Callable { property.value }, property)
            val label = label {
                bindViewOrder(binding)
            }.instance()
            assertEquals(property.value, label.viewOrder)

            property.value = 42.0
            assertEquals(property.value, label.viewOrder)
        }
    }

    @Nested
    inner class VisibleBindingExtensionTests {

        @Test
        fun `test binding VisibleProperty to property`() {
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
        fun `test binding VisibleProperty to binding`() {
            val property = SimpleBooleanProperty(false)
            val binding = createBooleanBinding(Callable { property.value }, property)
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
