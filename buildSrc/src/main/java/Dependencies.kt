object Dependencies {

    const val CUSTOM_VIEWS = "com.github.lostankit7:AndroidCustomViews:1.2"

    //lifecycle
    private const val LIFECYCLE_VERSION = "2.4.1"
    const val VIEW_MODEL = "androidx.lifecycle:lifecycle-viewmodel-ktx:$LIFECYCLE_VERSION"
    const val LIVE_DATA = "androidx.lifecycle:lifecycle-livedata-ktx:$LIFECYCLE_VERSION"
    const val LIFE_CYCLE_COMMON = "androidx.lifecycle:lifecycle-common-java8:$LIFECYCLE_VERSION"


    //navigation component
    //navigation component dep. for navigating fragments w.r.t. to id in menu and graph
    const val NAVIGATION_VERSION = "2.4.2"
    const val NAVIGATION_FRAGMENT =
        "androidx.navigation:navigation-fragment-ktx:$NAVIGATION_VERSION"
    const val NAVIGATION_UI = "androidx.navigation:navigation-ui-ktx:$NAVIGATION_VERSION"


    //google material
    private const val MATERAIL_VERSION = "1.6.0"
    const val MATERIAL = "com.google.android.material:material:$MATERAIL_VERSION"

    //androidX
    private const val CORE_KTX_VERSION = "1.7.0"
    const val CORE_KTX = "androidx.core:core-ktx:$CORE_KTX_VERSION"

    private const val APP_COMPAT_VERSION = "1.4.0"
    const val APP_COMPAT = "androidx.appcompat:appcompat:$APP_COMPAT_VERSION"


    //coroutines
    private const val COROUTINES_VERSION = "1.6.0"
    const val COROUTINES = "org.jetbrains.kotlinx:kotlinx-coroutines-core:$COROUTINES_VERSION"


    //dagger
    private const val DAGGER_VERSION = "2.40.5"
    const val DAGGER = "com.google.dagger:dagger:$DAGGER_VERSION"
    const val DAGGER_COMPILER = "com.google.dagger:dagger-compiler:$DAGGER_VERSION"


    //retrofit
    private const val RETROFIT_VERSION = "2.9.0"
    const val RETROFIT = "com.squareup.retrofit2:retrofit:$RETROFIT_VERSION"
    const val MOSHI_CONVERTOR = "com.squareup.retrofit2:converter-moshi:$RETROFIT_VERSION"

    private const val OKHTTP_VERSION = "5.0.0-alpha.2"
    const val OKHTTP = "com.squareup.okhttp3:okhttp:$OKHTTP_VERSION"
    const val OKHTTP_LOGGING_INTERCEPTOR =
        "com.squareup.okhttp3:logging-interceptor:$OKHTTP_VERSION"


    //room
    private const val ROOM_VERSION = "2.4.0"
    const val ROOM_RUNTIME = "androidx.room:room-runtime:$ROOM_VERSION"
    const val ROOM_COMPILER = "androidx.room:room-compiler:$ROOM_VERSION"
    const val ROOM_KTX = "androidx.room:room-ktx:$ROOM_VERSION"


    //compose version
    private const val COMPOSE_VERSION = "1.0.0"
    const val COMPOSE_UI = "androidx.compose.ui:ui:$COMPOSE_VERSION"
    const val COMPOSE_MATERIAL = "androidx.compose.material:material:$COMPOSE_VERSION"
    const val COMPOSE_TOOL_PREVIEW = "androidx.compose.ui:ui-tooling-preview:$COMPOSE_VERSION"
}