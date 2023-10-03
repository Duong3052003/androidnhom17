plugins {
    id("com.android.application")
    id ("com.google.gms.google-services")
}

android {
    namespace = "com.example.androidnhom17"
    compileSdk = 33

    defaultConfig {
        applicationId = "com.example.androidnhom17"
        minSdk = 28
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    buildFeatures {
        dataBinding=true
    }




}

dependencies {
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.9.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("androidx.room:room-common:2.5.2")
    implementation("androidx.room:room-runtime:2.5.2")
    implementation("com.google.firebase:firebase-storage:20.2.1")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    //thư viện mới thêm//
    implementation ("de.hdodenhof:circleimageview:3.1.0")
    implementation ("com.github.denzcoskun:ImageSlideshow:0.1.2")
    annotationProcessor("androidx.room:room-compiler:2.5.2")
    implementation ("com.github.bumptech.glide:glide:4.12.0")
    annotationProcessor ("com.github.bumptech.glide:compiler:4.12.0")
//o//
//    implementation ("com.google.android.material:material:1.9.0")
//    implementation ("de.hdodenhof:circleimageview:3.1.0")
//
//    def room_version = ("2.4.0")
//
//    implementation ("androidx.room:room-runtime:$room_version")
//    annotationProcessor ("androidx.room:room-compiler:$room_version")
//
//
//    // optional - RxJava2 support for Room
//    implementation ("androidx.room:room-rxjava2:$room_version")
//
//    // optional - RxJava3 support for Room
//    implementation ("androidx.room:room-rxjava3:$room_version")
//
//    // optional - Guava support for Room, including Optional and ListenableFuture
//    implementation ("androidx.room:room-guava:$room_version")
//
//    // optional - Test helpers
//    testImplementation ("androidx.room:room-testing:$room_version")
//
//    // optional - Paging 3 Integration
//    implementation ("androidx.room:room-paging:$room_version")

}