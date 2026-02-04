plugins {
    java
    application
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

application {
    mainClass.set("com.github.scalerock.snmp.Main")
}

tasks.jar {
    manifest {
        attributes["Main-Class"] = application.mainClass.get()
    }
}
