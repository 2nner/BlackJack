plugins {
    id("com.inner.blackjack.android.feature")
    id("com.inner.blackjack.android.hilt")
}

android {
    namespace = "com.inner.blackjack.feature.home"
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
}