package com.solo4.gradleprepare.extensions

import org.gradle.api.artifacts.VersionCatalog

internal val VersionCatalog.minSdkVersion: Int get() = this.findVersion("minSdk").get().toString().toInt()
internal val VersionCatalog.targetSdkVersion: Int get() = this.findVersion("targetSdk").get().toString().toInt()
internal val VersionCatalog.buildToolVersion: String get() = this.findVersion("buildTool").get().toString()
internal val VersionCatalog.versionCode: Int get() = this.findVersion("appVersionCode").get().toString().toInt()
internal val VersionCatalog.versionName: String get() = this.findVersion("appVersionName").get().toString()
internal val VersionCatalog.applicationId: String get() = this.findVersion("appVersionName").get().toString()
