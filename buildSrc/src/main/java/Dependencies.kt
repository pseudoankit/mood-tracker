object Dependencies {

    const val CUSTOM_VIEWS = "com.github.lostankit7:AndroidCustomViews:1.2"

    //lifecycle
    const val VIEW_MODEL = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.LIFECYCLE}"
    const val LIVE_DATA = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.LIFECYCLE}"
    const val LIFE_CYCLE_COMMON = "androidx.lifecycle:lifecycle-common-java8:${Versions.LIFECYCLE}"


    //navigation component
    //navigation component dep. for navigating fragments w.r.t. to id in menu and graph
    const val NAVIGATION_FRAGMENT =
        "androidx.navigation:navigation-fragment-ktx:${Versions.NAVIGATION}"
    const val NAVIGATION_UI = "androidx.navigation:navigation-ui-ktx:${Versions.NAVIGATION}"


    //google material
    const val MATERIAL = "com.google.android.material:material:${Versions.MATERIAL}"

    //androidX
    const val CORE_KTX = "androidx.core:core-ktx:${Versions.CORE_KTX}"

    const val APP_COMPAT = "androidx.appcompat:appcompat:${Versions.APP_COMPAT}"


    //coroutines
    const val COROUTINES = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.COROUTINES}"


    //dagger
    const val DAGGER = "com.google.dagger:dagger:${Versions.DAGGER}"
    const val DAGGER_COMPILER = "com.google.dagger:dagger-compiler:${Versions.DAGGER}"


    //retrofit
    const val RETROFIT = "com.squareup.retrofit2:retrofit:${Versions.RETROFIT}"
    const val MOSHI_CONVERTOR = "com.squareup.retrofit2:converter-moshi:${Versions.RETROFIT}"

    const val OKHTTP = "com.squareup.okhttp3:okhttp:${Versions.OKHTTP}"
    const val OKHTTP_LOGGING_INTERCEPTOR =
        "com.squareup.okhttp3:logging-interceptor:${Versions.OKHTTP}"


    //room
    const val ROOM_RUNTIME = "androidx.room:room-runtime:${Versions.ROOM}"
    const val ROOM_COMPILER = "androidx.room:room-compiler:${Versions.ROOM}"
    const val ROOM_KTX = "androidx.room:room-ktx:${Versions.ROOM}"


    //compose
    const val COMPOSE_FONT_AWESOME = "com.github.lazycoder-21:ComposeFontAwesomeLibrary:v1.0.0"
    const val COMPOSE_UI = "androidx.compose.ui:ui:${Versions.COMPOSE}"
    const val COMPOSE_RUNTIME = "androidx.compose.runtime:runtime:${Versions.COMPOSE}"
    const val COMPOSE_COMPILER = "androidx.compose.compiler:compiler:${Versions.COMPOSE}"
    const val COMPOSE_MATERIAL = "androidx.compose.material:material:${Versions.COMPOSE}"
    const val COMPOSE_TOOL_PREVIEW = "androidx.compose.ui:ui-tooling-preview:${Versions.COMPOSE}"
    const val COMPOSE_CONSTRAINT =
        "androidx.constraintlayout:constraintlayout-compose:${Versions.COMPOSE_CONSTRAINE}"

}