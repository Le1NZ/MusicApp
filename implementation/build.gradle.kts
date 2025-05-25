plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.jetbrains.kotlin.android)
    alias(libs.plugins.compose.compiler)
}

android {
    namespace = "ru.pokrovskii.implementation"
    compileSdk = 34

    defaultConfig {
        minSdk = 26

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {

    implementation(project(":auth"))
    implementation(project(":database"))
    implementation(project(":design"))
    implementation(project(":likes-control"))
    implementation(project(":model"))
    implementation(project(":navigation"))
    implementation(project(":network"))
    implementation(project(":screens:account-screen"))
    implementation(project(":screens:artist-screen"))
    implementation(project(":screens:artist-songs-screen"))
    implementation(project(":screens:favorites-screen"))
    implementation(project(":screens:main-screen"))
    implementation(project(":screens:search-screen"))
    implementation(project(":screens:song-item"))
    implementation(project(":screens:log-in-screen"))
    implementation(project(":screens:sign-up-screen"))
    implementation(project(":screens:song-screen"))
    implementation(project(":storage"))

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.runtime)

    // Di
    implementation(libs.koin.android)
}