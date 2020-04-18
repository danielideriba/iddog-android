import org.jetbrains.kotlin.gradle.dsl.KotlinJvmOptions

plugins {
        id(BuildPlugins.androidApplication)
        id(BuildPlugins.kotlinAndroid)
        id(BuildPlugins.kotlinAndroidExtensions)
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
        }
        buildTypes {
                getByName("release") {
                        isMinifyEnabled = false
                        proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
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
        implementation(Libraries.DAGGER)
        implementation(Libraries.DAGGER_ANDROID)
        implementation(Libraries.FIREBASE_CORE)
        implementation(Libraries.OKHTTP_LOGGER)
        implementation(Libraries.RETROFIT)
        implementation(Libraries.RETROFIT_CONVERTER_GSON)
        implementation(Libraries.GLIDE)
        implementation(Libraries.TIMBER)

        annotationProcessor(Libraries.DAGGER_ANDROID_PROCESSOR)
        annotationProcessor(Libraries.DAGGER_COMPILER)
        annotationProcessor(Libraries.GLIDE_ANNOTATION)

        testImplementation (TestLibraries.JUNIT4)
        androidTestImplementation (TestLibraries.TESTRUNNER)
        androidTestImplementation (TestLibraries.ESPRESSO)
}