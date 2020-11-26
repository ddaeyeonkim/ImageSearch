object Versions {
    const val gradle = "4.1.1"
    const val ktLint = "9.4.0"

    const val compileSdk = 30
    const val minSdk = 23
    const val targetSdk = 30

    const val kotlin = "1.4.10"
    const val coroutine = "1.4.1"

    const val appcompat = "1.2.0"
    const val material = "1.2.1"
    const val constraintLayout = "1.1.3"
    const val swiperefreshlayout = "1.1.0"
    const val coreKtx = "1.1.0"
    const val activityKtx = "1.1.0"

    const val paging = "3.0.0-alpha09"
    const val coroutinesReactive = "1.4.1"
    const val coroutinesRx = "1.4.1"

    const val lifecycleExt = "2.2.0"

    const val room = "2.2.5"

    const val retrofit = "2.9.0"
    const val gson = "2.8.6"
    const val loggingInterceptor = "4.2.0"

    const val rxJava = "2.2.12"
    const val rxKotlin = "2.4.0"
    const val rxAndroid = "2.1.1"

    const val glide = "4.9.0"

    const val junit = "4.13.1"
    const val androidJunit = "1.1.1"
    const val espresso = "3.2.0"
    const val mockk = "1.10.2"

    const val dagger2 = "2.30"

    const val timber = "4.7.1"
    const val threeTenABP = "1.3.0"

    const val shimmer = "0.5.0"
}

object Libraries {
    //kotlin
    const val kotlin = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlin}"
    const val coroutine = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutine}"
    const val coroutineAndroid = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutine}"
    const val coroutineTest = "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.coroutine}"

    // android
    const val appcompat = "androidx.appcompat:appcompat:${Versions.appcompat}"
    const val material = "com.google.android.material:material:${Versions.material}"
    const val constraintLayout = "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
    const val swiperefreshlayout = "androidx.swiperefreshlayout:swiperefreshlayout:${Versions.swiperefreshlayout}"
    const val coreKtx = "androidx.core:core-ktx:${Versions.coreKtx}"
    const val activityKtx = "androidx.activity:activity-ktx:${Versions.activityKtx}"
    const val liveDataTesting = "androidx.arch.core:core-testing:2.1.0"

    // paging
    const val pagingRuntime = "androidx.paging:paging-runtime:${Versions.paging}"
    const val pagingTest = "androidx.paging:paging-common:${Versions.paging}"
    const val pagingRx = "androidx.paging:paging-rxjava2:${Versions.paging}"
    const val coroutinesReactive = "org.jetbrains.kotlinx:kotlinx-coroutines-reactive:${Versions.coroutinesReactive}"
    const val coroutinesRx = "org.jetbrains.kotlinx:kotlinx-coroutines-rx2:${Versions.coroutinesRx}"

    // lifecycle
    const val viewmodelLifecycle = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycleExt}"
    const val runtimeLifecycle = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycleExt}"
    const val livedataLifecycle = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.lifecycleExt}"

    // room
    const val room = "androidx.room:room-runtime:$${Versions.room}"
    const val roomKtx = "androidx.room:room-ktx:${Versions.room}"
    const val roomCompiler = "androidx.room:room-compiler:${Versions.room}"
    const val roomRxJava = "androidx.room:room-rxjava2:${Versions.room}"
    const val roomTest = "androidx.room:room-testing:${Versions.room}"

    // network
    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    const val gson = "com.google.code.gson:gson:${Versions.gson}"
    const val gsonConverter = "com.squareup.retrofit2:converter-gson:${Versions.retrofit}"
    const val rxJavaAdapter = "com.squareup.retrofit2:adapter-rxjava2:${Versions.retrofit}"
    const val loggingInterceptor = "com.squareup.okhttp3:logging-interceptor:${Versions.loggingInterceptor}"

    // rx
    const val rxJava = "io.reactivex.rxjava2:rxjava:${Versions.rxJava}"
    const val rxKotlin = "io.reactivex.rxjava2:rxkotlin:${Versions.rxKotlin}"
    const val rxAndroid = "io.reactivex.rxjava2:rxandroid:${Versions.rxAndroid}"

    // image
    const val glide = "com.github.bumptech.glide:glide:${Versions.glide}"
    const val glideCompiler = "com.github.bumptech.glide:compiler:${Versions.glide}"

    // test
    const val junit4 = "junit:junit:${Versions.junit}"
    const val androidJunit = "androidx.test.ext:junit:${Versions.androidJunit}"
    const val espresso = "androidx.test.espresso:espresso-core:${Versions.espresso}"
    const val mockk = "io.mockk:mockk:${Versions.mockk}"

    // di
    const val dagger2 = "com.google.dagger:dagger:${Versions.dagger2}"
    const val dagger2Compiler = "com.google.dagger:dagger-compiler:${Versions.dagger2}"

    // logger
    const val timber = "com.jakewharton.timber:timber:${Versions.timber}"

    // java date
    const val threeTenABP = "com.jakewharton.threetenabp:threetenabp:${Versions.threeTenABP}"

    // shimmer
    const val shimmer = "com.facebook.shimmer:shimmer:${Versions.shimmer}"
}

object BuildPlugins {
    const val androidGradlePlugin = "com.android.tools.build:gradle:${Versions.gradle}"
    const val kotlinGradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"
    const val ktLintGradle = "org.jlleitschuh.gradle:ktlint-gradle:${Versions.ktLint}"

    const val androidApplication = "com.android.application"
    const val kotlin = "kotlin"
    const val kotlinAndroid = "kotlin-android"
    const val kotlinKapt = "kotlin-kapt"
    const val ktLint = "org.jlleitschuh.gradle.ktlint"
    const val ktLintIdea = "org.jlleitschuh.gradle.ktlint-idea"
}