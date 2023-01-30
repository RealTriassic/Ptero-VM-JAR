plugins {
    java
    id("com.github.johnrengelman.shadow") version "7.1.2"
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.yaml:snakeyaml:1.33")
}

java {
    toolchain.languageVersion.set(JavaLanguageVersion.of(project.extra["java_version"].toString()))
}

tasks.shadowJar {
    dependencies {
        include(dependency("org.yaml:snakeyaml:1.33"))
    }
}

tasks.withType<Jar> {
    manifest {
        attributes("Main-Class" to "com.triassic.pterovm.Main")
    }
}
