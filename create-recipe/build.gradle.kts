plugins {
    id("java")
}

group = "org.openvalue.openrewrite-intro"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(platform("org.openrewrite.recipe:rewrite-recipe-bom:1.19.0"))

    implementation("org.openrewrite:rewrite-java")

    runtimeOnly("org.openrewrite:rewrite-java-8")
    runtimeOnly("org.openrewrite:rewrite-java-11")
    runtimeOnly("org.openrewrite:rewrite-java-17")

    testImplementation("org.openrewrite:rewrite-test")
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.named<JavaCompile>("compileJava") {
    options.release.set(8)
}

tasks.test {
    useJUnitPlatform()
}
