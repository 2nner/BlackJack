plugins {
    id("com.inner.blackjack.android.library")
    id("com.inner.blackjack.android.library.compose")
}

android {
    namespace = "com.inner.blackjack.core.navigation"
}

dependencies {
    implementation(libs.androidx.core.ktx)
    api(libs.androidx.navigation.compose)
}