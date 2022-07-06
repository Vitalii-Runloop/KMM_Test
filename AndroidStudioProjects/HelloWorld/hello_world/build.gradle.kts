plugins {
    kotlin("multiplatform")
    kotlin("native.cocoapods")
    id("com.android.library")

    kotlin("plugin.serialization") version "1.7.0"

    id("com.rickclephas.kmp.nativecoroutines") version "0.12.5"
    id("com.squareup.sqldelight")
}

version = "1.0"

kotlin {
    android()
    iosX64()
    iosArm64()
    iosSimulatorArm64()

    cocoapods {
        summary = "Hello World using KMM"
        homepage = "--"
        ios.deploymentTarget = "14.1"
        framework {
            baseName = "hello_world"
        }

        xcodeConfigurationToNativeBuildType["Staging"] = org.jetbrains.kotlin.gradle.plugin.mpp.NativeBuildType.DEBUG
    }
    
    sourceSets {
        val ktorVersion = "2.0.2"
        val sqldelightVersion = "1.5.3"

        val commonMain by getting {
            dependencies {
                //Network
                implementation("io.ktor:ktor-client-core:$ktorVersion")
                implementation("io.ktor:ktor-client-content-negotiation:$ktorVersion")
                implementation("io.ktor:ktor-serialization-kotlinx-json:$ktorVersion")

                implementation("com.squareup.sqldelight:coroutines-extensions:$sqldelightVersion")
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }
        val androidMain by getting {
            dependencies {
                implementation("io.ktor:ktor-client-okhttp:$ktorVersion")
                implementation("com.squareup.sqldelight:android-driver:$sqldelightVersion")
            }
        }
        val androidTest by getting
        val iosX64Main by getting
        val iosArm64Main by getting
        val iosSimulatorArm64Main by getting
        val iosMain by creating {
            dependsOn(commonMain)
            iosX64Main.dependsOn(this)
            iosArm64Main.dependsOn(this)
            iosSimulatorArm64Main.dependsOn(this)
            dependencies {
                implementation("io.ktor:ktor-client-darwin:$ktorVersion")
                implementation("com.squareup.sqldelight:native-driver:$sqldelightVersion")
            }
        }
        val iosX64Test by getting
        val iosArm64Test by getting
        val iosSimulatorArm64Test by getting
        val iosTest by creating {
            dependsOn(commonTest)
            iosX64Test.dependsOn(this)
            iosArm64Test.dependsOn(this)
            iosSimulatorArm64Test.dependsOn(this)
        }
    }
}

android {
    compileSdk = 32
    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
    defaultConfig {
        minSdk = 26
        targetSdk = 32
    }
}

nativeCoroutines {
    suffix = "Swift"
}

sqldelight {
    database("HWDatabase") {
        packageName = "com.example.helloworld"
        verifyMigrations = true
        linkSqlite = true
    }
}