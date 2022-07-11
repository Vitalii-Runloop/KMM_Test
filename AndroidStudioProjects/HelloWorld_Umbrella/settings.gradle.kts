pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
    }
}

rootProject.name = "HelloWorld_Umbrella"
include(":helloworld_umbrella")

include(":hello_world_core")
project(":hello_world_core").projectDir=file("../HelloWorld_Core/hello_world_core")

include( ":hello_world_feature_1")
project(":hello_world_feature_1").projectDir=file("../HelloWorld_Feature1/hello_world_feature_1")

include( ":hello_world_feature_2")
project(":hello_world_feature_2").projectDir=file("../HelloWorld_Feature2/hello_world_feature_2")