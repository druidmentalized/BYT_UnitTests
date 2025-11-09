plugins {
    id("java")
}

group = "org.project"
version = "1.0-SNAPSHOT"

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(25))
    }
}

tasks.compileJava {
    options.compilerArgs.addAll(listOf("--enable-preview", "--release", "25"))
}

tasks.compileTestJava {
    options.compilerArgs.addAll(listOf("--enable-preview", "--release", "25"))
}

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

tasks.test {
    useJUnitPlatform()
}