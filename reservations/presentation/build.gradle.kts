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

    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = Compose.composeCompilerVersion
    }
}

dependencies {
    implementation(project(Modules.domain))
    implementation(project(Modules.data))

    implementation(Compose.ui)
    implementation(Compose.material)
    implementation(Compose.runtime)
    implementation(Compose.activityCompose)
    implementation(platform(Compose.composeBom))
    implementation(Compose.composeGraphic)
    implementation(Compose.uiToolingPreview)
    implementation(Compose.hiltNavigationCompose)
    implementation(Compose.viewModelCompose)

    implementation(Coil.coilCompose)
    implementation(Coroutines.coroutinesCore)
    implementation(Coroutines.coroutinesAndroid)

}