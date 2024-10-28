rootProject.name = "CompoT"
enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

pluginManagement {
    @Suppress("UnstableApiUsage")
    repositories {
        google {
            mavenContent {
                includeGroupAndSubgroups("androidx")
                includeGroupAndSubgroups("com.android")
                includeGroupAndSubgroups("com.google")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}

dependencyResolutionManagement {
    @Suppress("UnstableApiUsage")
    repositories {
        google {
            mavenContent {
                includeGroupAndSubgroups("androidx")
                includeGroupAndSubgroups("com.android")
                includeGroupAndSubgroups("com.google")
            }
        }
        mavenCentral()
    }
}

listOf("api", "std").forEach {
    val path = ":compot-terminal:$it"
    include(path)
    project(path).name = "compot-terminal-$it"
}
include(":compot-chalk")
include(":compot-ui")

listOf(
    "showcase",
    "terminal-android",
    "terminal-web",
).forEach { include(":examples:$it") }
