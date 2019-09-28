package eu.yeger.kotlin.javafx

import javafx.beans.property.SimpleStringProperty
import javafx.scene.control.Button
import javafx.scene.control.Label
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Assertions.fail
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.testfx.assertions.api.Assertions.assertThat
import org.testfx.framework.junit5.ApplicationTest

class FragmentTests : ApplicationTest() {

    @Nested
    inner class ButtonTests {

        @Test
        fun testButtonWithoutText() {
            val button = button().instance()
            assertThat(button).hasText("")
        }

        @Test
        fun testButtonWithText() {
            val button = button("Hello").instance()
            assertThat(button).hasText("Hello")
        }

        @Test
        fun testButtonWithInitializer() {
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
        fun testLabelWithoutText() {
            val label = label().instance()
            assertThat(label).hasText("")
        }

        @Test
        fun testLabelWithText() {
            val label = label("Hello").instance()
            assertThat(label).hasText("Hello")
        }

        @Test
        fun testLabelWithBinding() {
            val property = SimpleStringProperty("First")
            val label = label(property).instance()
            assertThat(label).hasText("First")
            property.value = "Second"
            assertThat(label).hasText("Second")
        }
    }

    @Nested
    inner class TextFieldTests {

        @Test
        fun testTextField() {
            val textField = textField {
                text = "This is a test"
            }.instance()
            assertThat(textField).hasText("This is a test")
        }
    }

    @Nested
    inner class PasswordFieldTests {

        @Test
        fun testTextField() {
            val passwordField = passwordField {
                text = "12345"
            }.instance()
            assertThat(passwordField).hasText("12345")
        }
    }

    @Nested
    inner class VBoxTests {

        @Test
        fun testVBoxWithButtonChildren() {
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
        fun testHBoxWithButtonChildren() {
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
        fun testAddingChildrenWithoutCoordinates() {
            val gridPane = gridPane {
                child { label("First") }
                child { button("Second") }
            }.instance()
            assertThat(gridPane).hasExactlyNumChildren(2)
            assertThat(gridPane.children[0] as Label).hasText("First")
            assertThat(gridPane.children[1] as Button).hasText("Second")
        }

        @Test
        fun testAddingChildrenWithCoordinates() {
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
        fun testStackPaneWithIndices() {
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
        fun testMultipleInstanceCreations() {
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
        fun testSingletonFragmentException() {
            val singleButtonFragment =Button("IncludedButton").asSingletonFragment()
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
