import org.jetbrains.kotlin.gradle.ExperimentalWasmDsl

plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.multiplatform)
}

@OptIn(ExperimentalWasmDsl::class)
kotlin {
    androidTarget()
    jvm()

    wasmJs {
        browser()
        nodejs()
        d8()
    }
    wasmWasi {
        nodejs()
    }
    js {
        browser()
        nodejs()
    }

    macosX64()
    macosArm64()
    linuxX64()
    linuxArm64()
    mingwX64()

    androidNativeArm32()
    androidNativeArm64()
    androidNativeX86()
    androidNativeX64()
    iosSimulatorArm64()
    iosX64()
    iosArm64()
    watchosSimulatorArm64()
    watchosX64()
    watchosArm32()
    watchosArm64()
    watchosDeviceArm64()
    tvosSimulatorArm64()
    tvosX64()
    tvosArm64()
}

android {
    namespace = "vip.cdms.compot.terminal.api"
}
