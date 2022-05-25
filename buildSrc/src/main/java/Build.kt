object Build {
    private const val ANDROID_BUILD_TOOLS_VERSION = "7.0.4"
    const val ANDROID_BUILD_TOOLS = "com.android.tools.build:gradle:$ANDROID_BUILD_TOOLS_VERSION"

    const val KOTLIN_VERSION = "1.6.10"
    const val KOTLIN_GRADLE_PLUGIN = "org.jetbrains.kotlin:kotlin-gradle-plugin:${KOTLIN_VERSION}"

    const val NAVIGATION_SAGE_ARGS =
        "androidx.navigation:navigation-safe-args-gradle-plugin:${Dependencies.NAVIGATION_VERSION}"
}