package eu.yeger.kotlin.javafx

import org.junit.Test
import org.testfx.assertions.api.Assertions.assertThat
import org.testfx.framework.junit.ApplicationTest

class LabelTests : ApplicationTest() {

    @Test
    fun testLabelWithoutText() {
        assertThat(label()).hasText("Label")
    }

    @Test
    fun testLabelWithText() {
        assertThat(label("Hello")).hasText("Hello")
    }
}