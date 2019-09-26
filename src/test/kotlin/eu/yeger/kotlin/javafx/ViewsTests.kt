package eu.yeger.kotlin.javafx

import javafx.scene.control.Button
import javafx.scene.control.Label
import javafx.scene.layout.HBox
import javafx.scene.layout.VBox
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.testfx.assertions.api.Assertions.assertThat
import org.testfx.framework.junit5.ApplicationTest

class ViewsTests : ApplicationTest() {

    @Nested
    inner class ButtonTests {

        @Test
        fun testButtonWithoutText() {
            val button = fragment<Button> {
                button()
            }.root
            assertThat(button).hasText("Button")
        }

        @Test
        fun testButtonWithText() {
            val button = fragment<Button> {
                button("Hello")
            }.root
            assertThat(button).hasText("Hello")
        }

        @Test
        fun testButtonWithInitializer() {
            var handled = false
            val button = fragment<Button> {
                button {
                    text = "Test"
                    setOnAction {
                        handled = true
                    }
                }
            }.root
            assertThat(button).hasText("Test")
            button.onAction.handle(null)
            assertTrue(handled)
        }
    }

    @Nested
    inner class LabelTests {

        @Test
        fun testLabelWithoutText() {
            val label = fragment<Label> {
                label()
            }.root
            assertThat(label).hasText("Label")
        }

        @Test
        fun testLabelWithText() {
            val label = fragment<Label> {
                label("Hello")
            }.root
            assertThat(label).hasText("Hello")
        }
    }

    @Nested
    inner class VBoxTests {

        @Test
        fun testVBoxWithButtonChildren() {
            val vBox = fragment<VBox> {
                vBox {
                    label("First")
                    button("Second")
                }
            }.root
            assertThat(vBox).hasExactlyNumChildren(2)
            assertEquals("First", (vBox.children[0] as Label).text)
            assertEquals("Second", (vBox.children[1] as Button).text)
        }
    }

    @Nested
    inner class HBoxTests {

        @Test
        fun testHBoxWithButtonChildren() {
            val hBox = fragment<HBox> {
                hBox {
                    label("First")
                    button("Second")
                }
            }.root
            assertThat(hBox).hasExactlyNumChildren(2)
            assertEquals("First", (hBox.children[0] as Label).text)
            assertEquals("Second", (hBox.children[1] as Button).text)
        }
    }

    @Nested
    inner class SceneTests {

        @Test
        fun testSimpleScene() {
            val root = scene {
                hBox {
                    label("First")
                    button("Second")
                }
            }.root as HBox
            assertThat(root).hasExactlyNumChildren(2)
            assertEquals("First", (root.children[0] as Label).text)
            assertEquals("Second", (root.children[1] as Button).text)
        }
    }
}
