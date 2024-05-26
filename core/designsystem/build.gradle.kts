plugins {
    id("com.inner.blackjack.android.library")
    id("com.inner.blackjack.android.library.compose")
}

android {
    namespace = "com.inner.blackjack.designsystem"
}

dependencies {
    api(platform(libs.androidx.compose))
    api(libs.bundles.composeBundle)
}