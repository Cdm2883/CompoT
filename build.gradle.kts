plugins {
    // this is necessary to avoid the plugins to be loaded multiple times
    // in each subproject's classloader
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.android.library) apply false
    alias(libs.plugins.jetbrains.compose) apply false
    alias(libs.plugins.compose.compiler) apply false
    alias(libs.plugins.kotlin.jvm) apply false
    alias(libs.plugins.kotlin.multiplatform) apply false
    alias(libs.plugins.adamko.dokkatoo.html)
}

subprojects {
    if (project.parent?.name != "examples")
        plugins.apply(rootProject.libs.plugins.adamko.dokkatoo.html.get().pluginId)
}

dependencies {
    dokkatoo(projects.compotTerminal.compotTerminalApi)
    dokkatoo(projects.compotTerminal.compotTerminalStd)
    dokkatoo(projects.compotChalk)
    dokkatoo(projects.compotUi)
}
