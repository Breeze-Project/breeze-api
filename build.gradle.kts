plugins {
    java
    `maven-publish`
}

group = "org.breeze"
version = "1.7.0"

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(21))
    }
    withSourcesJar()
    withJavadocJar()
}

repositories {
    mavenCentral()
    maven("https://repo.papermc.io/repository/maven-public/")
    maven("https://maven.canvasmc.io/snapshots")
    maven("https://maven.canvasmc.io/public")
}

dependencies {
    compileOnly(libs.canvas.api)
    compileOnly(libs.annotations)
}

tasks.withType<JavaCompile> {
    options.encoding = "UTF-8"
    options.release.set(21)
}

publishing {
    publications {
        create<MavenPublication>("mavenJava") {
            from(components["java"])
            groupId = project.group.toString()
            artifactId = project.name
            version = project.version.toString()
        }
    }
}

tasks.named("publishToMavenLocal") {
    dependsOn("build")
}

