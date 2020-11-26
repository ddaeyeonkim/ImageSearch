import org.jetbrains.kotlin.konan.properties.loadProperties

plugins {
    id(BuildPlugins.androidApplication)
    id(BuildPlugins.kotlinAndroid)
    id(BuildPlugins.kotlinKapt)
    id(BuildPlugins.ktLint)
}

android {
    compileSdkVersion(Versions.compileSdk)

    defaultConfig {
        applicationId = "com.improve777.imagesearch"
        minSdkVersion(Versions.minSdk)
        targetSdkVersion(Versions.targetSdk)
        versionCode = 1
        versionName = "1.0.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

        val properties = loadProperties("key.properties")
        buildConfigField("String", "KAKAO_API_KEY", "\"${properties["KAKAO_API_KEY"]}\"")
        buildConfigField("String", "KAKAO_API_URL", "\"${properties["KAKAO_API_URL"]}\"")
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    compileOptions.apply {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }

    buildFeatures {
        dataBinding = true
    }
}

dependencies {
    implementation(Libraries.kotlin)

    implementation(Libraries.appcompat)
    implementation(Libraries.material)
    implementation(Libraries.constraintLayout)
    implementation(Libraries.swiperefreshlayout)
    implementation(Libraries.coreKtx)
    implementation(Libraries.activityKtx)

    implementation(Libraries.pagingRuntime)
    testImplementation(Libraries.pagingTest)
    implementation(Libraries.pagingRx)
    implementation(Libraries.coroutinesReactive)
    implementation(Libraries.coroutinesRx)

    implementation(Libraries.viewmodelLifecycle)
    implementation(Libraries.runtimeLifecycle)
    implementation(Libraries.livedataLifecycle)

    implementation(Libraries.retrofit)
    implementation(Libraries.gson)
    implementation(Libraries.gsonConverter)
    implementation(Libraries.rxJavaAdapter)
    implementation(Libraries.loggingInterceptor)

    implementation(Libraries.rxJava)
    implementation(Libraries.rxKotlin)
    implementation(Libraries.rxAndroid)

    testImplementation(Libraries.junit4)
    testImplementation(Libraries.mockk)
    androidTestImplementation(Libraries.androidJunit)
    androidTestImplementation(Libraries.espresso)

    implementation(Libraries.dagger2)
    kapt(Libraries.dagger2Compiler)

    implementation(Libraries.timber)

    implementation(Libraries.threeTenABP)

    implementation(Libraries.glide)
    kapt(Libraries.glideCompiler)
}