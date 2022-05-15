object Dependencies {

    const val customViews = "com.github.lostankit7:AndroidCustomViews:1.2"

    private const val materialVersion = "1.6.0"
    const val material = "com.google.android.material:material:$materialVersion"

    //androidX
    private const val coreKtxVersion = "1.7.0"
    const val coreKtx = "androidx.core:core-ktx:$coreKtxVersion"

    private const val appCompatVersion = "1.4.0"
    const val appCompat = "androidx.appcompat:appcompat:$appCompatVersion"


    //coroutines
    private const val coroutineVersion = "1.6.0"
    const val coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutineVersion"


    //dagger
    private const val daggerVersion = "2.40.5"
    const val dagger = "com.google.dagger:dagger:$daggerVersion"
    const val daggerCompiler = "com.google.dagger:dagger-compiler:$daggerVersion"


    //retrofit
    private const val retrofitVersion = "2.9.0"
    const val retrofit = "com.squareup.retrofit2:retrofit:$retrofitVersion"
    const val moshiConverter = "com.squareup.retrofit2:converter-moshi:$retrofitVersion"

    private const val okHttpVersion = "5.0.0-alpha.2"
    const val okHttp = "com.squareup.okhttp3:okhttp:$okHttpVersion"
    const val okHttpLoggingInterceptor =
        "com.squareup.okhttp3:logging-interceptor:$okHttpVersion"

    //room
    private const val roomVersion = "2.4.0"
    const val roomRuntime = "androidx.room:room-runtime:$roomVersion"
    const val roomCompiler = "androidx.room:room-compiler:$roomVersion"
    const val roomKtx = "androidx.room:room-ktx:$roomVersion"
}