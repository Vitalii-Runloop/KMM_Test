pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
    }
}

rootProject.name = "Hello_World_Feature_1"
include(":hello_world_feature_1")

include(":hello_world_core")
project(":hello_world_core").projectDir=file("../HelloWorld_Core/hello_world_core")