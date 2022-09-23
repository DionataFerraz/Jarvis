object ApplicationId {
    const val id = "br.com.jarvis"
}

object Versions {
    const val compileSdk = 31
    const val minSdk = 21
    const val targetSdk = 31
}

object Releases {
    const val versionCode = 1
    const val versionName = "1.0.0"
}


object GradlePlugin {
    object Versions {
        const val kotlin = "1.5.21"
        const val androidGradlePlugin = "7.0.4"
    }

    const val kotlin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"
    const val androidGradlePlugin = "com.android.tools.build:gradle:${Versions.androidGradlePlugin}"
}