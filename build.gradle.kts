plugins {
    kotlin("jvm") version "1.9.21"
    id("io.github.magek1511") version "1.0.0"

    application
}


group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("com.google.code.gson:gson:2.10.1")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.5.2")
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(8)
}

infoConf {
    dirs = arrayOf("src")
    outputDir = "build"
}

application {
    mainClass.set("MainKt")
}
