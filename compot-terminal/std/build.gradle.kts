plugins {
    alias(libs.plugins.kotlin.multiplatform)
}

kotlin {
    jvm()
    js {
        nodejs()
    }
    macosX64()
    macosArm64()
    linuxX64()
    linuxArm64()
    mingwX64()

    sourceSets {
        commonMain.dependencies {
            implementation(projects.compotTerminal.compotTerminalApi)
        }
        jvmMain.dependencies {
            implementation(libs.jline.terminal.jni)
        }
        jsMain.dependencies {
            implementation(libs.kotlin.js.wrapper.node)
        }

        val macosX64Main by getting
        val macosArm64Main by getting
        val linuxX64Main by getting
        val linuxArm64Main by getting
        val mingwX64Main by getting

        val unixMain by creating {
            dependsOn(commonMain.get())
        }
        macosArm64Main.dependsOn(unixMain)
        macosX64Main.dependsOn(unixMain)
        linuxArm64Main.dependsOn(unixMain)
        linuxX64Main.dependsOn(unixMain)

        val mingwMain by creating {
            dependsOn(commonMain.get())
        }
        mingwX64Main.dependsOn(mingwMain)
    }
}
