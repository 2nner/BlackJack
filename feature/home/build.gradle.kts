plugins {
    id("com.inner.blackjack.android.feature")
}

android {
    namespace = "com.inner.blackjack.feature.home"
}

dependencies {
    implementation(platform(libs.androidx.compose))
    implementation(libs.bundles.composeBundle)

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
}