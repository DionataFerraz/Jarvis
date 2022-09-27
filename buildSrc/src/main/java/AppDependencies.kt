object ApplicationId {
    const val id = "br.com.jarvis"
}

object Versions {
    const val compileSdk = 33
    const val minSdk = 21
    const val targetSdk = 33
    const val kotlinCompiler = "1.3.1"
}

object Releases {
    const val versionCode = 1
    const val versionName = "1.0.0"
}

object GradlePlugin {
    object Versions {
        const val kotlin = "1.7.10"
        const val androidGradlePlugin = "7.2.2"
    }

    const val kotlin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"
    const val androidGradlePlugin = "com.android.tools.build:gradle:${Versions.androidGradlePlugin}"
}