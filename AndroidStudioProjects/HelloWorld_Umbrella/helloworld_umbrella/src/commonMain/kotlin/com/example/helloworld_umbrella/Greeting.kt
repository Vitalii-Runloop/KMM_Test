package com.example.helloworld_umbrella

class Greeting {
    fun greeting(): String {
        return "Hello, ${Platform().platform}!"
    }
}