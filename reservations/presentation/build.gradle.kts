plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

apply(from = "$rootDir/base-module.gradle")


android {
    namespace = "com.quandoo.presentation"

    packaging {
        resources {
            excludes += "/META-INF/*"
        }
    }
}

dependencies {


}