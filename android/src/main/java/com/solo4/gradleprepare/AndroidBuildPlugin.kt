package com.solo4.gradleprepare
import org.gradle.api.Project
import org.gradle.api.Plugin

class AndroidBuildPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        target.configurePlugins()
        target.androidConfiguration()
    }
}
