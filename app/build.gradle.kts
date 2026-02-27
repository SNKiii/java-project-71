plugins {
    id("application")
    id("org.jetbrains.kotlin.kapt") version "1.9.22"
    id("checkstyle")
    id("org.sonarqube") version "7.1.0.6387"
}

group = "org.example"
version = "1.0-SNAPSHOT"

application{
    mainClass.set("hexlet.code.App")
}

sonar {
    properties {
        property("sonar.projectKey", "SNKiii_java-project-71")
        property("sonar.organization", "snkiii")
        property("sonar.host.url", "https://sonarcloud.io")
    }
}

checkstyle {
    toolVersion = "10.12.4"
}

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
    implementation("info.picocli:picocli:4.7.7")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.19.+")
    implementation("com.fasterxml.jackson.core:jackson-databind:2.15.2")
    implementation("com.fasterxml.jackson.core:jackson-databind:2.13.4.2")
    implementation("com.fasterxml.jackson.core:jackson-annotations:2.12.4")
    implementation("com.fasterxml.jackson.core:jackson-core:2.15.0")
    implementation(group = "com.fasterxml.jackson.dataformat", name = "jackson-dataformat-yaml", version = "2.13.4")
}

kapt {
    arguments {
        arg("project", "${project.group}/${project.name}")
    }
}

tasks.test {
    useJUnitPlatform()
}