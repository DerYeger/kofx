package eu.yeger.kotlin.javafx

import javafx.application.Platform
import java.lang.Exception
import java.util.concurrent.CountDownLatch

object KPlatform {

    inline fun runAndWait(crossinline block: () -> Unit ) {
        if (Platform.isFxApplicationThread()) {
            block()
        } else {
            val latch = CountDownLatch(1)
            Platform.runLater {
                try {
                    block()
                } finally {
                    latch.countDown()
                }
            }
            try {
                latch.await()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    inline fun <T> callAndWait(crossinline block: () -> T ): T? {
        if (Platform.isFxApplicationThread()) {
            return block()
        } else {
            val latch = CountDownLatch(1)
            var result: T? = null
            Platform.runLater {
                try {
                    result = block()
                } finally {
                    latch.countDown()
                }
            }
            try {
                latch.await()
            } catch (e: Exception) {
                e.printStackTrace()
            }
            return result
        }
    }
}

