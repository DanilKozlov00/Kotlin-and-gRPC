package com.example

import com.example.com.example.service.KotlinServiceImpl
import io.grpc.ServerBuilder

open class Main {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
           ServerBuilder
                .forPort(8086)
                .addService(KotlinServiceImpl())
                .build()
                .start()
                .awaitTermination()
        }
    }
}