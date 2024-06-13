plugins {
    id("com.inner.blackjack.android.application")
    id("com.inner.blackjack.android.application.compose")
    id("com.inner.blackjack.android.hilt")
}

android {
    namespace = "com.inner.blackjack"

    defaultConfig {
        applicationId = "com.inner.blackjack"
        versionCode = 1
        versionName = "1.0.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = true
            isShrinkResources = true
            proguardFiles("proguard-rules.pro")
        }
    }

    buildFeatures {
        buildConfig = true
    }
}

dependencies {
    // core
    implementation(projects.core.navigation)
    implementation(projects.core.designsystem)

    // feature
    implementation(projects.feature.home)
    implementation(projects.feature.ingame)

    implementation(platform(libs.androidx.compose))
    implementation(libs.bundles.composeBundle)
    implementation(libs.androidx.activity.compose)
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.navigation.compose)
    implementation(libs.material)

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}