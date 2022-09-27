object Libs {
    object Versions {
        const val composeUi = "1.2.1"
        const val composeMaterial = "1.2.1"
        const val composeMaterial3 = "1.0.0-beta02"

        const val androidxCoreKtx = "1.9.0"
        const val androidxActivity = "1.5.1"
        const val navigation = "2.5.2"
        const val junit = "4.13.2"
        const val androidxJunit = "1.1.3"
        const val androidxEspresso = "3.4.0"
    }

    // Implementation
    const val composeUi = "androidx.compose.ui:ui:${Versions.composeUi}"
    const val composeUiToolingPreview = "androidx.compose.ui:ui-tooling-preview:${Versions.composeUi}"
    const val composeMaterial = "androidx.compose.material:material:${Versions.composeMaterial}"
    const val composeMaterial3 = "androidx.compose.material3:material3:${Versions.composeMaterial3}"
    const val androidxActivityCompose = "androidx.activity:activity-compose:${Versions.androidxActivity}"
    const val androidxKtx = "androidx.core:core-ktx:${Versions.androidxCoreKtx}"

    // Test
    const val composeUiTest = "androidx.compose.ui:ui-test-junit4:${Versions.composeUi}"
    const val junitCore = "junit:junit:${Versions.junit}"
    const val androidxTestExt = "androidx.test.ext:junit:${Versions.androidxJunit}"
    const val androidxTestEspresso = "androidx.test.espresso:espresso-core:${Versions.androidxEspresso}"

    // Debug
    const val composeUiTooling = "androidx.compose.ui:ui-tooling:${Versions.composeUi}" // to preview
    const val composeUiTestManifest = "androidx.compose.ui:ui-test-manifest:${Versions.composeUi}"

    const val navigationUiKtx = "androidx.navigation:navigation-ui-ktx:${Versions.navigation}"
    const val navigationCompose = "androidx.navigation:navigation-compose:${Versions.navigation}"
    const val navigationFragmentKtx = "androidx.navigation:navigation-fragment-ktx:${Versions.navigation}"


}