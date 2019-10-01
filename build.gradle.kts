group = "eu.yeger"
version = "0.1.2"

val javaVersion = JavaVersion.VERSION_12

val junit5Version = "5.5.2"
val testFXVersion = "4.0.16-alpha"
val monocleVersion = "jdk-12.0.1+2"
val mockkVersion = "1.9.3"

plugins {
    java
    jacoco
    kotlin("jvm") version "1.3.50"
    id("org.openjfx.javafxplugin") version "0.0.8"
}

java {
    sourceCompatibility = javaVersion
    targetCompatibility = javaVersion
}

javafx {
    version = javaVersion.toString()
    modules = listOf( "javafx.controls" )
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))

    testImplementation("org.junit.jupiter:junit-jupiter-api:$junit5Version")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:$junit5Version")

    testImplementation("org.testfx:testfx-core:$testFXVersion")
    testImplementation("org.testfx:testfx-junit5:$testFXVersion")
    testImplementation("org.testfx:openjfx-monocle:$monocleVersion")

    testImplementation("io.mockk:mockk:$mockkVersion")
}

tasks {
    compileKotlin {
        kotlinOptions.jvmTarget = "12"
    }

    compileTestKotlin {
        kotlinOptions.jvmTarget = "12"
    }

    jacocoTestReport {
        reports {
            xml.isEnabled = true
            html.isEnabled = false
        }
    }

    test {
        useJUnitPlatform()
    }
}