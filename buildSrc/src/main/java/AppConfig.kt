//app level config constants
object AppConfig {
    const val applicationId = "com.android.oda"
    const val compileSdk = 30
    const val minSdk = 21
    const val targetSdk = 30
    const val buildToolsVersion = "30.0.3"

    private const val versionMajor = 1
    private const val versionMinor = 0
    private const val versionPatch = 0
    const val buildNumber = 1
    const val versionName = "$versionMajor.$versionMinor.$versionPatch"

    const val androidTestInstrumentation = "androidx.test.runner.AndroidJUnitRunner"
    const val proguardConsumerRules = "consumer-rules.pro"

    const val singConfigName = "oda"
    const val singConfigFile = "../credentials/oda.jks"
}

object Stages {
    const val development = "development"
    const val staging = "staging"
    const val production = "production"
}

object Stores {
    const val playStore = "playStore"
}

object BuildDimensions {
    const val stage = "stage"
    const val store = "store"
}

object ServerUrl {
    const val development = """"http://192.168.0.1/""""
    const val staging = """"http://192.168.0.1/""""
    const val production = """"http://192.168.0.1/""""
}