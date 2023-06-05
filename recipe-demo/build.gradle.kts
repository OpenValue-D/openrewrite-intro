plugins {
    id("java")
    id("org.openrewrite.rewrite") version("5.40.4")
}

group = "org.openvalue.openrewrite-intro"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

rewrite {
    activeRecipes = listOf("org.openvalue.AddLicenseHeaderExample", "org.openrewrite.java.RemoveUnusedImports")
}

tasks.named<JavaCompile>("compileJava") {
    options.release.set(8)
}

tasks.test {
    useJUnitPlatform()
}
