package eu.yeger.kofx

import io.mockk.mockk
import javafx.beans.binding.Bindings.createObjectBinding
import javafx.beans.property.SimpleIntegerProperty
import javafx.beans.property.SimpleObjectProperty
import javafx.beans.property.SimpleStringProperty
import javafx.scene.control.Button
import javafx.scene.control.Label
import javafx.scene.image.Image
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.testfx.assertions.api.Assertions.assertThat
import org.testfx.framework.junit5.ApplicationTest

class FragmentTests : ApplicationTest() {

    @Nested
    inner class ButtonTests {

        @Test
        fun `test simple Button`() {
            val button = button().instance()
            assertThat(button).hasText("")
        }

        @Test
        fun `test Button with text`() {
            val button = button("Hello").instance()
            assertThat(button).hasText("Hello")
        }

        @Test
        fun `test Button with initializer`() {
            var handled = false
            val button = button {
                text = "Test"
                setOnAction {
                    handled = true
                }
            }.instance()
            assertThat(button).hasText("Test")
            button.onAction.handle(null)
            assertTrue(handled)
        }
    }

    @Nested
    inner class LabelTests {

        @Test
        fun `test simple Label`() {
            val label = label().instance()
            assertThat(label).hasText("")
        }

        @Test
        fun `test Label with text`() {
            val label = label("Hello").instance()
            assertThat(label).hasText("Hello")
        }

        @Test
        fun `test Label with property binding`() {
            val property = SimpleStringProperty("First")
            val label = label(property).instance()
            assertThat(label).hasText("First")
            property.value = "Second"
            assertThat(label).hasText("Second")
        }

        @Test
        fun `test Label with binding`() {
            val property = SimpleIntegerProperty(0)
            val label = label(property.asString()).instance()
            assertEquals(property.value.toString(), label.text)

            property.value = 1
            assertEquals(property.value.toString(), label.text)
        }
    }

    @Nested
    inner class TextFieldTests {

        @Test
        fun `test simple TextField`() {
            val textField = textField {
                text = "This is a test"
            }.instance()
            assertThat(textField).hasText("This is a test")
        }

        @Test
        fun `test TextField with property binding`() {
            val property = SimpleStringProperty("First")
            val textField = textField(property).instance()
            assertEquals(property.value, textField.text)

            property.value = "Second"
            assertEquals(property.value, textField.text)

            textField.text = "Third"
            assertEquals(property.value, textField.text)
        }

        @Test
        fun `test TextField with binding`() {
            val property = SimpleIntegerProperty(0)
            val textField = textField(property.asString()).instance()
            assertEquals(property.value.toString(), textField.text)

            property.value = 1
            assertEquals(property.value.toString(), textField.text)
        }
    }

    @Nested
    inner class PasswordFieldTests {

        @Test
        fun `test simple PasswordField`() {
            val passwordField = passwordField {
                text = "12345"
            }.instance()
            assertThat(passwordField).hasText("12345")
        }

        @Test
        fun `test PasswordField with property binding`() {
            val property = SimpleStringProperty("First")
            val passwordField = passwordField(property).instance()
            assertEquals(property.value, passwordField.text)

            property.value = "Second"
            assertEquals(property.value, passwordField.text)

            passwordField.text = "Third"
            assertEquals(property.value, passwordField.text)
        }

        @Test
        fun `test PasswordField with binding`() {
            val property = SimpleIntegerProperty(0)
            val passwordField = passwordField(property.asString()).instance()
            assertEquals(property.value.toString(), passwordField.text)

            property.value = 1
            assertEquals(property.value.toString(), passwordField.text)
        }
    }

    @Nested
    inner class ImageViewTests {

        private val mockImage = mockk<Image>(relaxed = true)

        @Test
        fun `test simple ImageView`() {
            val imageView = imageView {
                image = mockImage
            }.instance()
            assertEquals(mockImage, imageView.image)
        }

        @Test
        fun `test ImageView with param`() {
            val imageView = imageView(mockImage).instance()
            assertEquals(mockImage, imageView.image)
        }

        @Test
        fun `test ImageView with property binding`() {
            val property = SimpleObjectProperty<Image>(mockImage)
            val imageView = imageView(property).instance()
            assertEquals(mockImage, imageView.image)
        }

        @Test
        fun `test ImageView with binding`() {
            val binding = createObjectBinding({ mockImage }, null)
            val imageView = imageView(binding).instance()
            assertEquals(mockImage, imageView.image)
        }
    }

    @Nested
    inner class RectangleTests {

        @Test
        fun `test simple Rectangle`() {
            val rec = rectangle {
                width = 100.0
                height = 50.0
            }.instance()
            assertEquals(100.0, rec.width)
            assertEquals(50.0, rec.height)
        }

        @Test
        fun `test Rectangle with params`() {
            val rec = rectangle(100.0, 50.0).instance()
            assertEquals(100.0, rec.width)
            assertEquals(50.0, rec.height)
        }

        @Test
        fun `test square Rectangle with param`() {
            val rec = rectangle(100.0).instance()
            assertEquals(100.0, rec.width)
            assertEquals(100.0, rec.height)
        }
    }

    @Nested
    inner class VBoxTests {

        @Test
        fun `test VBox with ordered children`() {
            val vBox = vBox {
                child { label("First") }
                child { button("Second") }
            }.instance()
            assertThat(vBox).hasExactlyNumChildren(2)
            assertThat(vBox.children[0] as Label).hasText("First")
            assertThat(vBox.children[1] as Button).hasText("Second")
        }
    }

    @Nested
    inner class HBoxTests {

        @Test
        fun `test HBox with ordered children`() {
            val hBox = hBox {
                child { label("First") }
                child { button("Second") }
            }.instance()
            assertThat(hBox).hasExactlyNumChildren(2)
            assertThat(hBox.children[0] as Label).hasText("First")
            assertThat(hBox.children[1] as Button).hasText("Second")
        }
    }

    @Nested
    inner class GridPaneTests {

        @Test
        fun `test GridPane with ordered children`() {
            val gridPane = gridPane {
                child { label("First") }
                child { button("Second") }
            }.instance()
            assertThat(gridPane).hasExactlyNumChildren(2)
            assertThat(gridPane.children[0] as Label).hasText("First")
            assertThat(gridPane.children[1] as Button).hasText("Second")
        }

        @Test
        fun `test GridPane with indexed children`() {
            val gridPane = gridPane {
                child(0, 0) {
                    label("First")
                }
                child(1, 1) {
                    button("Second")
                }
            }.instance()
            assertThat(gridPane).hasExactlyNumChildren(2)
            assertThat(gridPane.children[0] as Label).hasText("First")
            assertThat(gridPane.children[1] as Button).hasText("Second")
        }
    }

    @Nested
    inner class StackPaneTests {

        @Test
        fun `test StackPane with ordered children`() {
            val stackPane = stackPane {
                child { label("First") }
                child { button("Second") }
            }.instance()
            assertThat(stackPane).hasExactlyNumChildren(2)
            assertThat(stackPane.children[0] as Label).hasText("First")
            assertThat(stackPane.children[1] as Button).hasText("Second")
        }
    }

    @Nested
    inner class FragmentInclusionTests {
        @Test
        fun `test creating multiple instances of Fragment`() {
            val singleButtonFragment = button("IncludedButton")
            val container = vBox {
                child { singleButtonFragment }
            }.instance()
            val anotherContainer = vBox {
                child { singleButtonFragment }
            }.instance()
            assertThat(container.children[0] as Button).hasText("IncludedButton")
            assertThat(anotherContainer.children[0] as Button).hasText("IncludedButton")
        }

        @Test
        fun `test FragmentException when creating multiple instances of SingletonFragment`() {
            val singleButtonFragment = Button("IncludedButton").asSingletonFragment()
            val container = vBox {
                child { singleButtonFragment }
            }.instance()
            assertThat(container.children[0] as Button).hasText("IncludedButton")
            try {
                vBox {
                    child { singleButtonFragment }
                }.instance()
            } catch (e: FragmentException) {
                return
            }
            fail<String>("Exception should have been thrown")
        }
    }
}
