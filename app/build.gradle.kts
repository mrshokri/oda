plugins {
    id("com.android.application")
    kotlin("android")
    id("kotlin-parcelize")
    id("kotlin-android")
    id("androidx.navigation.safeargs.kotlin")
    kotlin("kapt")
}

android {
    compileSdkVersion(AppConfig.compileSdk)
    buildToolsVersion(AppConfig.buildToolsVersion)

    defaultConfig {
        applicationId = AppConfig.applicationId
        minSdkVersion(AppConfig.minSdk)
        targetSdkVersion(AppConfig.targetSdk)
        versionCode = AppConfig.buildNumber
        versionName = AppConfig.versionName
        multiDexEnabled = true
        vectorDrawables.useSupportLibrary = true
        testInstrumentationRunner = AppConfig.androidTestInstrumentation
        setProperty("archivesBaseName", "Oda-v${versionName}(${versionCode})")
    }

    signingConfigs {
        create(AppConfig.singConfigName) {
            storeFile = file(AppConfig.singConfigFile)
            keyAlias = "oda"
            keyPassword = "1234567"
            storePassword = "1234567"
            isV2SigningEnabled = true
            isV1SigningEnabled = true
        }
    }

    packagingOptions {
        exclude("META-INF/DEPENDENCIES")
        exclude("META-INF/LICENSE")
        exclude("META-INF/LICENSE.txt")
        exclude("META-INF/license.txt")
        exclude("META-INF/NOTICE")
        exclude("META-INF/NOTICE.txt")
        exclude("META-INF/notice.txt")
        exclude("META-INF/ASL2.0")
        exclude("org/apache/http/version.properties")
        exclude("org/apache/http/client/version.properties")
        exclude("META-INF/services/javax.annotation.processing.Processor")
    }

    buildTypes {
        getByName(BuildType.DEBUG) {
            isMinifyEnabled = false
            isDebuggable = true
            versionNameSuffix = "D"
            buildConfigField("String", "PREFERENCES", Constants.DEBUG_PREFERENCES)
            buildConfigField("boolean", "IGNORE_SECURITY", Constants.DEBUG_IGNORE_SECURITY)
            buildConfigField(
                "int",
                "SERVICE_TIME_OUT_MILLI_SEC",
                Constants.DEBUG_SERVICE_TIME_OUT_MILLI_SEC
            )
            buildConfigField("String", "VERSION_NAME", """"${AppConfig.versionName}"""")
            buildConfigField("int", "BUILD_NUMBER", AppConfig.buildNumber.toString())
        }
        getByName(BuildType.RELEASE) {
            signingConfig = android.signingConfigs.getByName(AppConfig.singConfigName)
            isMinifyEnabled = true
            isDebuggable = false
            versionNameSuffix = "R"
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            buildConfigField("String", "PREFERENCES", Constants.RELEASE_PREFERENCES)
            buildConfigField("boolean", "IGNORE_SECURITY", Constants.RELEASE_IGNORE_SECURITY)
            buildConfigField(
                "int",
                "SERVICE_TIME_OUT_MILLI_SEC",
                Constants.RELEASE_SERVICE_TIME_OUT_MILLI_SEC
            )
            buildConfigField("String", "VERSION_NAME", """"${AppConfig.versionName}"""")
            buildConfigField("int", "BUILD_NUMBER", AppConfig.buildNumber.toString())
        }
    }
    flavorDimensions(BuildDimensions.stage, BuildDimensions.store)

    productFlavors {
        create(Stages.development) {
            dimension = BuildDimensions.stage
            applicationIdSuffix = ".development"
            buildConfigField("String", "API_BASE_URL", ServerUrl.development)
            manifestPlaceholders ["appIcon"] = "@mipmap/ic_launcher"
            manifestPlaceholders ["appIconRound"] = "@mipmap/ic_launcher_round"
        }

        create(Stages.staging) {
            dimension = BuildDimensions.stage
            applicationIdSuffix = ".staging"
            buildConfigField("String", "API_BASE_URL", ServerUrl.staging)
            manifestPlaceholders ["appIcon"] = "@mipmap/ic_launcher"
            manifestPlaceholders ["appIconRound"] = "@mipmap/ic_launcher_round"
        }

        create(Stages.production) {
            dimension = BuildDimensions.stage
            applicationIdSuffix = ".production"
            buildConfigField("String", "API_BASE_URL", ServerUrl.production)
            manifestPlaceholders ["appIcon"] = "@mipmap/ic_launcher"
            manifestPlaceholders ["appIconRound"] = "@mipmap/ic_launcher_round"
        }

        // Store dimension is used to port for different stores

        create(Stores.playStore) {
            dimension = BuildDimensions.store
        }
    }
    buildFeatures {
        viewBinding = true
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
    //std lib
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    //app libs
    implementation(AppDependencies.appLibraries)
    runtimeOnly("androidx.lifecycle:lifecycle-viewmodel-savedstate:2.3.1")
    kapt(AppDependencies.annotationLibraries)
    //test libs
    testImplementation(AppDependencies.testLibraries)
    androidTestImplementation(AppDependencies.androidTestLibraries)
}

configurations {
    all {
        exclude("org.apache.httpcomponents")
        exclude("commons-logging", "commons-logging")
    }
}