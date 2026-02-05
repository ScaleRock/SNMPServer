plugins {
    java
    id("com.github.johnrengelman.shadow") version "8.1.1"
}

group = "com.github.scalerock.snmp"
version = libs.versions.project.get()

repositories {
    mavenCentral()
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(libs.versions.java.get()))
    }
}

dependencies {
    implementation(project(":core"))
}


subprojects {
    apply(plugin = "java")
    repositories {
        mavenCentral()
    }


    tasks.test {
        maxParallelForks = Runtime.getRuntime().availableProcessors()
        useJUnitPlatform()
        testLogging {
            events("passed", "skipped", "failed")
            exceptionFormat = org.gradle.api.tasks.testing.logging.TestExceptionFormat.FULL
        }
        reports {
            html.required.set(true)
            junitXml.required.set(true)
        }

    }
}

tasks.shadowJar {
    manifest {
        attributes["Main-Class"] = "com.github.scalerock.snmp.Main"
    }
}