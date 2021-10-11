import org.gradle.api.artifacts.dsl.DependencyHandler

object AppDependencies {
    //std lib
    private const val kotlinStdLibJDK = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:${Versions.kotlin}"
    private const val kotlinStdLib = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlin}"

    //android ui
    private const val appcompat = "androidx.appcompat:appcompat:${Versions.appcompat}"
    private const val fragment = "androidx.fragment:fragment:${Versions.fragment}"
    private const val fragmentKtx = "androidx.fragment:fragment-ktx:${Versions.fragment}"
    private const val coreKtx = "androidx.core:core-ktx:${Versions.coreKtx}"
    private const val constraintLayout =
        "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
    private const val material = "com.google.android.material:material:${Versions.material}"
    private const val koinAndroid = "org.koin:koin-android:${Versions.koin}"
    private const val koinCore = "org.koin:koin-core:${Versions.koin}"
    private const val koinAndroidxScope = "org.koin:koin-androidx-scope:${Versions.koin}"
    private const val koinAndroidxViewModel = "org.koin:koin-androidx-viewmodel:${Versions.koin}"

    // For Kotlin use kapt instead of annotationProcessor
    private const val roomCompiler = "androidx.room:room-compiler:${Versions.room}"

    // optional - Kotlin Extensions and Coroutines support for Room
    private const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    private const val retrofitGson = "com.squareup.retrofit2:converter-gson:${Versions.retrofit}"
    private const val gson = "com.google.code.gson:gson:${Versions.gson}"
    private const val okHttpProfiler =
        "com.itkacher.okhttpprofiler:okhttpprofiler:${Versions.okHttpProfiler}"
    private const val navigationUi = "androidx.navigation:navigation-ui-ktx:${Versions.navigation}"
    private const val navigationFragmentKtx =
        "androidx.navigation:navigation-fragment-ktx:${Versions.navigation}"
    private const val multiDex = "androidx.multidex:multidex:${Versions.multiDex}"
    private const val legacySupport = "androidx.legacy:legacy-support-v4:${Versions.legacySupport}"
    private const val moshi = "com.squareup.moshi:moshi-kotlin:${Versions.moshi}"
    private const val lifecycleRuntimeKtx =
        "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycle}"
    private const val lifecycleViewModelKtx =
        "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycle}"
    private const val lifecycleLiveDataKtx =
        "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.lifecycle}"
    private const val sentry = "io.sentry:sentry-android:${Versions.sentry}"
    private const val coil = "io.coil-kt:coil:${Versions.coil}"

    //test libs
    private const val junit = "junit:junit:${Versions.junit}"
    private const val extJUnit = "androidx.test.ext:junit:${Versions.extJunit}"
    private const val espressoCore = "androidx.test.espresso:espresso-core:${Versions.espresso}"

    val appLibraries = arrayListOf<String>().apply {
        add(multiDex)
        add(kotlinStdLibJDK)
        add(kotlinStdLib)
        add(coreKtx)
        add(fragment)
        add(fragmentKtx)
        add(appcompat)
        add(constraintLayout)
        add(material)
        add(koinAndroid)
        add(koinCore)
        add(koinAndroidxScope)
        add(koinAndroidxViewModel)
        add(retrofit)
        add(retrofitGson)
        add(gson)
        add(okHttpProfiler)
        add(navigationFragmentKtx)
        add(navigationUi)
        add(legacySupport)
        add(moshi)
        add(lifecycleRuntimeKtx)
        add(lifecycleViewModelKtx)
        add(lifecycleLiveDataKtx)
        add(coil)
    }

    val annotationLibraries = arrayListOf<String>().apply {
        add(roomCompiler)
    }

    val androidTestLibraries = arrayListOf<String>().apply {
        add(extJUnit)
        add(espressoCore)
    }

    val testLibraries = arrayListOf<String>().apply {
        add(junit)
    }
}

//util functions for adding the different type dependencies from build.gradle file
fun DependencyHandler.kapt(list: List<String>) {
    list.forEach { dependency ->
        add("kapt", dependency)
    }
}

fun DependencyHandler.implementation(list: List<String>) {
    list.forEach { dependency ->
        add("implementation", dependency)
    }
}

fun DependencyHandler.runTimeOnly(list: List<String>) {
    list.forEach { dependency ->
        add("runtimeOnly", dependency)
    }
}

fun DependencyHandler.androidTestImplementation(list: List<String>) {
    list.forEach { dependency ->
        add("androidTestImplementation", dependency)
    }
}

fun DependencyHandler.testImplementation(list: List<String>) {
    list.forEach { dependency ->
        add("testImplementation", dependency)
    }
}