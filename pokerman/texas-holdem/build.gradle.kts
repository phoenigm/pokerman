plugins {
    kotlin("jvm")
}

repositories {
    mavenCentral()
    jcenter()
}

dependencies {
    implementation(Libs.kotlinStdlib)
    implementation(Libs.kotlinJdk8)

    implementation(project(":pokerman:core"))

    testImplementation(Libs.junitApi)
    testImplementation(Libs.junitEngine)
    testImplementation(Libs.junitParams)
}
