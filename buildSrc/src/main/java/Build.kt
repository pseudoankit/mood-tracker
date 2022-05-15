object Build {
    private const val androidBuildToolsVersion = "7.0.4"
    const val androidBuildTools = "com.android.tools.build:gradle:$androidBuildToolsVersion"

    const val kotlinVersion = "1.6.0"
    const val kotlinGradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${kotlinVersion}"

    private const val navigationVersion = "2.4.2"
    const val navigationSafeArgs =
        "androidx.navigation:navigation-safe-args-gradle-plugin:$navigationVersion"
}