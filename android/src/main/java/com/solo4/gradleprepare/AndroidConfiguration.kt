package com.solo4.gradleprepare

import com.android.build.gradle.BaseExtension
import com.solo4.gradleprepare.extensions.versionCode
import com.solo4.gradleprepare.extensions.versionName
import com.solo4.gradleprepare.extensions.applicationId
import com.solo4.gradleprepare.extensions.buildToolVersion
import com.solo4.gradleprepare.extensions.minSdkVersion
import com.solo4.gradleprepare.extensions.targetSdkVersion
import org.gradle.api.JavaVersion
import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.*
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

internal fun Project.androidConfiguration() {
    val versionCatalog = extensions.getByType<VersionCatalogsExtension>().named("libs")
    this.extensions.getByType<BaseExtension>().run {
        compileSdkVersion(versionCatalog.targetSdkVersion)
        buildToolsVersion = versionCatalog.buildToolVersion
        defaultConfig {
            if (name == "app") {
                applicationId = versionCatalog.applicationId
                versionCode = versionCatalog.versionCode
                versionName = versionCatalog.versionName
            }
            minSdk = versionCatalog.minSdkVersion
            targetSdk = versionCatalog.targetSdkVersion
            consumerProguardFiles("consumer-rules.pro")
        }

        buildTypes {
            getByName("release") {
                isMinifyEnabled = true
                proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
            }
        }

        compileOptions {
            sourceCompatibility = JavaVersion.VERSION_11
            targetCompatibility = JavaVersion.VERSION_11
        }

        tasks.withType(KotlinCompile::class.java).all {
            kotlinOptions {
                jvmTarget = JavaVersion.VERSION_11.toString()
            }
        }
    }
}
