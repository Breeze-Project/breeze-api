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

val versionMajor = project.version.toString().substringBefore(".")
val versionMinor = project.version.toString().substringAfter(".").substringBefore(".")
val versionPatch = project.version.toString().substringAfterLast(".")

tasks.withType<JavaCompile> {
    options.encoding = "UTF-8"
    options.release.set(21)
}

val generatedVersionDir = layout.buildDirectory.dir("generated/breeze-version").get().asFile
generatedVersionDir.mkdirs()
file("${generatedVersionDir}/breeze-version.properties").writeText(
    "api.version=${project.version}\n" +
    "api.version.major=${versionMajor}\n" +
    "api.version.minor=${versionMinor}\n" +
    "api.version.patch=${versionPatch}\n"
)
sourceSets.main.configure {
    output.dir(generatedVersionDir)
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

