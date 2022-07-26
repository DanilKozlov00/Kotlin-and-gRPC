package com.example.com.example.config

import com.example.KotlinServiceGrpc
import io.grpc.ManagedChannelBuilder
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.ApplicationContext
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.core.annotation.Order
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer


@Configuration
@Order(1)
@ComponentScan("com.example")
open class SpringConfig : WebMvcConfigurer {
    lateinit var applicationContext: ApplicationContext

    @Autowired
    fun SpringConfiguration(applicationContext: ApplicationContext) {
        this.applicationContext = applicationContext
    }

    @Bean
    open fun getStub(): KotlinServiceGrpc.KotlinServiceBlockingStub =
        KotlinServiceGrpc.newBlockingStub(ManagedChannelBuilder.forTarget("localhost:8086").usePlaintext().build())

}