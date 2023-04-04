plugins {
    `kotlin-dsl`
    `java-gradle-plugin`
    `java-library`
}

group = "com.solo4.gradleprepare"

gradlePlugin {
    plugins {
        create("gradle-prepare-android") {
            id = "gradle-prepare-android"
            implementationClass = "com.solo4.gradleprepare.AndroidBuildPlugin"
        }
    }
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>().configureEach {
    kotlinOptions {
        jvmTarget = "11"
    }
}

dependencies {
    implementation(libs.android.gradlePlugin)
    implementation(libs.kotlin.gradlePlugin)
    implementation(gradleApi())
    implementation(localGroovy())
}
