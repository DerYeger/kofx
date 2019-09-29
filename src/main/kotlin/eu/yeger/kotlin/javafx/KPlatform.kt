package eu.yeger.kotlin.javafx

import javafx.application.Platform
import java.util.concurrent.CountDownLatch

object KPlatform {

    inline fun runOnFXThread(crossinline block: () -> Unit ) {
        if (Platform.isFxApplicationThread()) {
            block()
        } else {
            Platform.runLater { block() }
        }
    }

    inline fun runAndWait(crossinline block: () -> Unit ) {
        val latch = CountDownLatch(1)
        runOnFXThread {
            try {
                block()
            } finally {
                latch.countDown()
            }
        }
        latch.await()
    }

    inline fun <T> callAndWait(crossinline block: () -> T ): T? {
        val latch = CountDownLatch(1)
        var result: T? = null
        runOnFXThread {
            try {
                result = block()
            } finally {
                latch.countDown()
            }
        }
        latch.await()
        return result
    }
}

