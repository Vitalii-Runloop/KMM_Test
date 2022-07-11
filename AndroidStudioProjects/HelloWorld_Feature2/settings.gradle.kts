pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
    }
}

rootProject.name = "HelloWorld_Feature_2"
include(":hello_world_feature_2")

include(":hello_world_core")
project(":hello_world_core").projectDir=file("../HelloWorld_Core/hello_world_core")