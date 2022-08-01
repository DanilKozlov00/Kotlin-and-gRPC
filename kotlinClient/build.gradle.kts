import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import com.google.protobuf.gradle.*


plugins {
    kotlin("jvm") version "1.6.21"
    application
    id("com.google.protobuf") version "0.8.19"
    java
    idea
    war
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}



sourceSets {
    create("sample") {
        proto {
            srcDir("src/sample/protobuf")
        }
    }
}

dependencies {
    implementation("com.google.protobuf:protobuf-java:3.6.1")
    implementation("io.grpc:grpc-stub:1.15.1")
    implementation("io.grpc:grpc-protobuf:1.15.1")
    if (JavaVersion.current().isJava9Compatible) {
        implementation("javax.annotation:javax.annotation-api:1.3.1")
    }
    testImplementation("junit:junit:4.12")
    implementation("io.grpc:grpc-netty-shaded:1.48.0")

    // https://mvnrepository.com/artifact/io.vertx/vertx-core
    implementation("io.vertx:vertx-core:4.3.2")

    // https://mvnrepository.com/artifact/io.vertx/vertx-web
    implementation("io.vertx:vertx-web:4.3.2")

    // https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-web
    implementation("org.springframework.boot:spring-boot-starter-web:2.7.1")

    // https://mvnrepository.com/artifact/io.vertx/vertx-web-client
    implementation("io.vertx:vertx-web-client:4.3.2.1")

    // https://mvnrepository.com/artifact/com.fasterxml.jackson.module/jackson-module-kotlin
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.13.3")

    // https://mvnrepository.com/artifact/io.vertx/vertx-web-templ-thymeleaf
    implementation("io.vertx:vertx-web-templ-thymeleaf:4.3.2")

    // https://mvnrepository.com/artifact/io.vertx/vertx-auth-oauth2
    implementation("io.vertx:vertx-auth-oauth2:4.3.2")

    // https://mvnrepository.com/artifact/io.vertx/vertx-lang-kotlin-coroutines
    implementation("io.vertx:vertx-lang-kotlin-coroutines:4.3.2")

}

protobuf {
    protoc {
        // The artifact spec for the Protobuf Compiler
        artifact = "com.google.protobuf:protoc:3.6.1"
    }
    plugins {
        // Optional: an artifact spec for a protoc plugin, with "grpc" as
        // the identifier, which can be referred to in the "plugins"
        // container of the "generateProtoTasks" closure.
        id("grpc") {
            artifact = "io.grpc:protoc-gen-grpc-java:1.15.1"
        }
    }
    generateProtoTasks {
        ofSourceSet("main").forEach {
            it.plugins {
                // Apply the "grpc" plugin whose spec is defined above, without options.
                id("grpc")
            }
        }
    }
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}

application {
    mainClass.set("MainKt")
}