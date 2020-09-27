group = "eu.yeger"
version = "0.3.0"

val javaVersion = JavaVersion.VERSION_12

val junit5Version = "5.7.0"
val testFXVersion = "4.0.16-alpha"
val monocleVersion = "1.8.0_20"
val mockkVersion = "1.10.1"

plugins {
    java
    jacoco
    maven
    kotlin("jvm") version "1.3.50"
    id("org.openjfx.javafxplugin") version "0.0.9"
}

java {
    sourceCompatibility = javaVersion
    targetCompatibility = javaVersion
}

javafx {
    version = javaVersion.toString()
    modules = listOf("javafx.controls")
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))

    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:$junit5Version")
    testImplementation("org.junit.jupiter:junit-jupiter-api:$junit5Version")

    testImplementation("org.testfx:testfx-core:$testFXVersion")
    testImplementation("org.testfx:testfx-junit5:$testFXVersion")
    testImplementation("org.testfx:openjfx-monocle:$monocleVersion")

    testImplementation("io.mockk:mockk:$mockkVersion")
}

tasks {
    compileKotlin {
        kotlinOptions.jvmTarget = javaVersion.toString()
    }

    compileTestKotlin {
        kotlinOptions.jvmTarget = javaVersion.toString()
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
