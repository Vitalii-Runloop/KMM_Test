package com.example.helloworldcore

class Greeting {
    fun greeting(): String {
        return "Hello, ${Platform().platform}!"
    }
}