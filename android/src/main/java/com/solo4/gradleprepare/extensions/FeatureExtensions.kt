package com.solo4.gradleprepare.extensions

import com.android.build.gradle.BaseExtension
import org.gradle.api.Project
import org.gradle.kotlin.dsl.getByType

fun Project.enableCompose() { extensions.getByType<BaseExtension>().buildFeatures.compose = true }
fun Project.enableViewBinding() { extensions.getByType<BaseExtension>().buildFeatures.viewBinding = true }
