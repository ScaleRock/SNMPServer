plugins {
    java
}
repositories {
    mavenCentral()
}

dependencies {
    implementation(libs.gjson)
    implementation(libs.jetbrains.annotations)
    implementation(libs.apache.mina)
    implementation(libs.bouncycastle)

    testImplementation(libs.junit.api)
    testRuntimeOnly(libs.junit.engine)
    testRuntimeOnly(libs.junit.launch)
}