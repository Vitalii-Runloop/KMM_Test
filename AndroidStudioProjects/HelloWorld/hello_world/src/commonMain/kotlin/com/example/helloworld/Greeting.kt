package com.example.helloworld

class Greeting {
    fun greeting(): String {
        return "Hello, ${Platform().platform}!"
    }
}