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
}

kapt {
    arguments {
        arg("project", "${project.group}/${project.name}")
    }
}

tasks.test {
    useJUnitPlatform()
}