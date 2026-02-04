plugins {
    java
    application
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(project(":snmpv1"))
    implementation(project(":snmpv2c"))
    implementation(project(":snmpv3"))

    implementation(libs.gjson)
    implementation(libs.jetbrains.annotations)

    testImplementation(libs.junit.api)
    testRuntimeOnly(libs.junit.engine)
    testRuntimeOnly(libs.junit.launch)
}
application {
    mainClass.set("com.github.scalerock.snmp.Main")
}