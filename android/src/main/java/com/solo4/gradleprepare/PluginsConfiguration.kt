package com.solo4.gradleprepare

import org.gradle.api.Project

internal fun Project.configurePlugins() {
    if (name == "app") {
        plugins.apply("com.android.application")
    } else {
        plugins.apply("com.android.library")
    }
    plugins.apply("org.jetbrains.kotlin.android")
}
