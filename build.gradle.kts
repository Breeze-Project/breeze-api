plugins {
    java
    `maven-publish`
}

group = "org.breeze"
version = "1.9.0"

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

val versionParts = project.version.toString().substringBefore("-").split(".")
val versionMajor = versionParts.getOrElse(0) { "0" }
val versionMinor = versionParts.getOrElse(1) { "0" }
val versionPatch = versionParts.getOrElse(2) { "0" }

val generateBreezeVersion by tasks.registering(WriteProperties::class) {
    comment = null
    destinationFile.set(layout.buildDirectory.file("generated/resources/breeze-version/breeze-version.properties"))

    property("api.version", project.version.toString())
    property("api.version.major", versionMajor)
    property("api.version.minor", versionMinor)
    property("api.version.patch", versionPatch)
}

sourceSets {
    main {
        resources {
            srcDir(generateBreezeVersion.map { it.destinationFile.get().asFile.parentFile })
        }
    }
}

tasks {
    withType<JavaCompile> {
        options.encoding = "UTF-8"
    }

    named("publishToMavenLocal") {
        dependsOn("check")
    }
}

publishing {
    publications {
        create<MavenPublication>("mavenJava") {
            from(components["java"])
        }
    }
}
