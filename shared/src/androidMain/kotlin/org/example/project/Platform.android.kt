package org.example.project

import android.content.res.Resources
import android.os.Build
import kotlin.math.round

actual class Platform() {
    actual val name: String
        get() = "Android"
    actual val osVersion: String
        get() = "${Build.VERSION.SDK_INT}"
    actual val deviceModel: String
        get() = "${Build.MODEL}"
    actual val density: Int
        get() = round(Resources.getSystem().displayMetrics.density).toInt()

    actual fun logSystemInfo() {
        println("OS Version: $osVersion")
        println("Device Model: $deviceModel")
        println("Density: $density")
    }
}