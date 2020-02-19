plugins {
    java
}

group = "junit5-seljupiter-containers-demo"
version = "0.0.1"

repositories {
    mavenCentral()
    jcenter()
}

val junitVersion = "5.5.2"
val testContainersVersion = "1.12.3"
val lombokVersion = "1.18.10"
val selenideVersion = "5.5.0"
val seleniumVersion = "3.141.59"
val seleniumJupiterVersion = "3.3.2"

dependencies {
    compile("com.codeborne", "selenide", selenideVersion)
    compile("org.seleniumhq.selenium", "selenium-remote-driver", seleniumVersion)
    compile("io.github.bonigarcia", "selenium-jupiter", seleniumJupiterVersion)
    compile("org.junit.jupiter", "junit-jupiter-engine", junitVersion)
    compile("org.junit.jupiter", "junit-jupiter-params", junitVersion)
    compile("org.testcontainers", "testcontainers", testContainersVersion)
    compile("org.testcontainers", "junit-jupiter", testContainersVersion)
    compile("org.testcontainers", "selenium", testContainersVersion)
    compile("org.projectlombok", "lombok", lombokVersion)
    annotationProcessor("org.projectlombok", "lombok", lombokVersion)
}

configure<JavaPluginConvention> {
    sourceCompatibility = JavaVersion.VERSION_1_8
}

tasks.withType(Test::class) {
    useJUnitPlatform()
    testLogging {
        displayGranularity = 5
        showStackTraces = false
        showExceptions = true
        showStandardStreams = false
        events("passed", "failed")
    }
}

tasks.withType(Wrapper::class) {
    gradleVersion = "5.6.4"
}