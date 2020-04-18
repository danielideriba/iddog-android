const val kotlinVersion = "1.3.21"

object BuildPlugins {

    object Versions {
        const val buildToolsVersion = "3.3.1"
    }

    const val androidGradlePlugin = "com.android.tools.build:gradle:${Versions.buildToolsVersion}"
    const val kotlinGradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion"
    const val androidApplication = "com.android.application"
    const val kotlinAndroid = "kotlin-android"
    const val kotlinAndroidExtensions = "kotlin-android-extensions"

}

object AndroidSdk {
    const val min = 16
    const val compile = 28
    const val target = compile
}

object Libraries {
    const val KOTLINSTDLIB                  = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:$kotlinVersion"
    const val APPCOMPAT                     = "androidx.appcompat:appcompat:${Versions.Androidx.APP_COMPAT}"
    const val CONSTRAINTLAYOUT              = "androidx.constraintlayout:constraintlayout:${Versions.Androidx.CONSTRAINTLAYOUT}"
    const val KTXCORE                       = "androidx.core:core-ktx:${Versions.Androidx.CORE_KTX}"
    const val VIEWPAGERX                    = "androidx.viewpager2:viewpager2:${Versions.Androidx.VIEWPAGERX}"
    const val MATERIAL                      = "com.google.android.material:material:${Versions.MATERIAL}"
    const val OKHTTP_LOGGER                 = "com.squareup.okhttp3:logging-interceptor:${Versions.OKHTTP3}"
    const val DAGGER                        = "com.google.dagger:dagger:${Versions.DAGGER2}"
    const val DAGGER_COMPILER               = "com.google.dagger:dagger-compiler:${Versions.DAGGER2}"
    const val DAGGER_ANDROID                = "com.google.dagger:dagger-android-support:${Versions.DAGGER2}"
    const val DAGGER_ANDROID_PROCESSOR      = "com.google.dagger:dagger-android-processor:${Versions.DAGGER2}"
    const val FIREBASE_CORE                 = "com.google.firebase:firebase-core:${Versions.Firebase.CORE}"
    const val RETROFIT                      = "com.squareup.retrofit2:retrofit:${Versions.RETROFIT}"
    const val RETROFIT_CONVERTER_GSON       = "com.squareup.retrofit2:converter-gson:${Versions.RETROFIT}"
    const val ANDROID_LIFECYCLE_RUNTIME     = "androidx.lifecycle:lifecycle-runtime:${Versions.Androidx.LIFECYCLE}"
    const val ANDROID_LIFECYCLE_VIEWMODEL   = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.Androidx.LIFECYCLE}"
    const val ANDROID_LIFECYCLE_EX          = "androidx.lifecycle:lifecycle-extensions:${Versions.Androidx.LIFECYCLE}"
    const val ANDROID_LIFECYCLE_LIVEDATA    = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.Androidx.LIFECYCLE}"

    const val GLIDE                         = "com.github.bumptech.glide:glide:${Versions.GLIDE}"
    const val GLIDE_ANNOTATION              = "com.github.bumptech.glide:compiler:${Versions.GLIDE}"
    const val TIMBER                        = "com.jakewharton.timber:timber:${Versions.TIMBER}"
}

object TestLibraries {
    private object Versions {
        const val JUNIT4 = "4.12"
        const val TESTRUNNER = "1.1.0-alpha4"
        const val ESPRESSO = "3.1.0-alpha4"
    }
    const val JUNIT4     = "junit:junit:${Versions.JUNIT4}"
    const val TESTRUNNER = "androidx.test:runner:${Versions.TESTRUNNER}"
    const val ESPRESSO   = "androidx.test.espresso:espresso-core:${Versions.ESPRESSO}"
}