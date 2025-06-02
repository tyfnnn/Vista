package org.example.project

import platform.UIKit.UIDevice
import platform.UIKit.UIScreen
import platform.Foundation.NSLog

actual class Platform actual constructor() {
    actual val name: String
        get() = "iOS"

    actual val osVersion: String
        get() = UIDevice.currentDevice.systemVersion

    actual val deviceModel: String
        get() = UIDevice.currentDevice.model

    actual val density: Int
        get() = UIScreen.mainScreen.scale.toInt()

    actual fun logSystemInfo() {
        NSLog("OS Version: $osVersion, Device Model: $deviceModel, Density: $density")
    }
}