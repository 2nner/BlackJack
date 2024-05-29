plugins {
    id("com.inner.blackjack.android.library")
    id("com.inner.blackjack.android.hilt")
}

android {
    namespace = "com.inner.blackjack.core.gameserver"
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.socketIo)
}