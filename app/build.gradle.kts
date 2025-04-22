plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("org.jetbrains.kotlin.plugin.compose") version "2.0.21"
    id("kotlin-kapt")
    id("com.google.gms.google-services")
}

android {
    namespace = "com.example.glory"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.glory"
        minSdk = 21
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "2.0.0" // Ensure compatibility with Compose plugin
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    val compose_version = "1.6.1" // Updated to match Compose 2.0 compatibility

    implementation("androidx.core:core-ktx:1.12.0")

    // Room
    implementation("androidx.room:room-runtime:2.6.1")
    kapt("androidx.room:room-compiler:2.6.1")
    implementation("androidx.room:room-ktx:2.6.1")

    // Navigation
    implementation("androidx.navigation:navigation-compose:2.7.7")

    // Compose core
    implementation("androidx.compose.material3:material3:1.2.1")
    implementation("androidx.activity:activity-compose:1.8.2") // match with Compose 1.6+
    implementation("androidx.compose.ui:ui:$compose_version")
    implementation("androidx.compose.material:material:$compose_version")
    implementation("androidx.compose.ui:ui-tooling-preview:$compose_version")
    debugImplementation("androidx.compose.ui:ui-tooling:$compose_version")

    // WorkManager & Coroutines
    implementation("androidx.work:work-runtime-ktx:2.9.0")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.4")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.6.4")

    // Lifecycle
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.6.2")
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.6.2")

    // Coil for image loading
    implementation("io.coil-kt:coil-compose:2.4.0")

    // Firebase
    implementation("com.google.firebase:firebase-firestore-ktx:24.5.0")
    implementation("com.google.firebase:firebase-auth-ktx:21.0.3")

    // Other dependencies
    implementation("androidx.compose.material:material-icons-extended:1.6.1")
    implementation("androidx.compose.foundation:foundation:1.5.1")
}
