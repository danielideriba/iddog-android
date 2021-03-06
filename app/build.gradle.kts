import org.jetbrains.kotlin.gradle.dsl.KotlinJvmOptions

plugins {
    id(BuildPlugins.androidApplication)
    id(BuildPlugins.kotlinAndroid)
    id(BuildPlugins.kotlinAndroidExtensions)
    id(BuildPlugins.kapt)
//    id(BuildPlugins.firebaseService)
}

android {
    compileSdkVersion(AndroidSdk.compile)
    defaultConfig {
        applicationId = "br.android.iddog"
        minSdkVersion(AndroidSdk.min)
        targetSdkVersion(AndroidSdk.target)
        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunner = "android.support.test.runner.AndroidJUnitRunner"
        multiDexEnabled = true

        buildConfigFields
    }
    kapt {
        correctErrorTypes = false
    }
    buildTypes {
        getByName("debug") {
            isMinifyEnabled = false
            buildConfigField("String", "API_URL", "\"https://dog.ceo/api/\"")
        }
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
            buildConfigField("String", "API_URL", "\"https://dog.ceo/api/\"")
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        val options = this as KotlinJvmOptions
        options.jvmTarget = "1.8"
    }
}

dependencies {
    implementation(Libraries.KOTLINSTDLIB)
    implementation(Libraries.APPCOMPAT)
    implementation(Libraries.KTXCORE)
    implementation(Libraries.VIEWPAGERX)
    implementation(Libraries.MATERIAL)
    implementation(Libraries.CONSTRAINTLAYOUT)
    implementation(Libraries.ANDROID_LIFECYCLE_EX)
    implementation(Libraries.ANDROID_LIFECYCLE_LIVEDATA)
    implementation(Libraries.ANDROID_LIFECYCLE_RUNTIME)
    implementation(Libraries.ANDROID_LIFECYCLE_VIEWMODEL)
    implementation(Libraries.OKHTTP_LOGGER)
    implementation(Libraries.RETROFIT)
    implementation(Libraries.RETROFIT_CONVERTER_GSON)
    implementation(Libraries.GLIDE)
    implementation(Libraries.GLIDE_OKHTTP3)
    implementation(Libraries.TIMBER)

//    implementation(Libraries.FIREBASE_CORE)
    implementation(Libraries.FIREBASE_DATABASE)
    implementation(Libraries.FIREBASE_AUTH)

    implementation(Libraries.STETHO)
    implementation(Libraries.STETHO_OKHTTP)
    implementation(Libraries.RXANDROID)
    implementation(Libraries.RXJAVA)
    implementation(Libraries.RXJAVA_ADAPTER)
    implementation(Libraries.ANDROIDX_LEGACY)

    implementation(Libraries.DAGGER)
    kapt(Libraries.DAGGER_ANDROID_PROCESSOR)
    kapt(Libraries.DAGGER_COMPILER)
    implementation(Libraries.DAGGER_ANDROID)

    implementation(Libraries.MULTIDEX)

    annotationProcessor(Libraries.DAGGER_ANDROID_PROCESSOR)
    annotationProcessor(Libraries.DAGGER_COMPILER)
    annotationProcessor(Libraries.GLIDE_ANNOTATION)

    testImplementation(TestLibraries.JUNIT4)
    androidTestImplementation(TestLibraries.TESTRUNNER)
    androidTestImplementation(TestLibraries.ESPRESSO)
}

apply(mapOf("plugin" to "com.google.gms.google-services"))