package org.example.project

import android.content.res.Resources
import android.graphics.ColorSpace.Model
import android.os.Build
import android.util.Log
import kotlin.math.round

actual class Platform actual constructor() {
    actual val name: String
        get() = "Android"
    actual val osVersion: String
        get() = "${Build.VERSION.SDK_INT}"
    actual val deviceModel: String
        get() = "${Build.MODEL}"
    actual val density: Int
        get() = round(Resources.getSystem().displayMetrics.density).toInt()

    actual fun logSystemInfo() {
        Log.d(
            "Vista",
            "OS Version: $osVersion, Device Model: $deviceModel, Density: $density"
        )
    }
}