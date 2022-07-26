package com.example

import com.fasterxml.jackson.module.kotlin.KotlinModule
import io.vertx.core.http.HttpServer
import io.vertx.core.json.jackson.DatabindCodec
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import java.util.logging.Logger
import javax.annotation.PostConstruct

@SpringBootApplication
open class Main(private val server: HttpServer) {

    companion object {

        @JvmStatic
        fun main(args: Array<String>) {
            configureJackson()

            SpringApplication.run(Main::class.java)
        }

        private fun configureJackson() {

            DatabindCodec.mapper().registerModule(
                KotlinModule.Builder().build()
            )
        }
    }

    @PostConstruct
    fun init() {
        server.listen(8081)
    }
}
