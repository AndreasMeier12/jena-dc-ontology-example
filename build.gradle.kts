plugins {
    id("java")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {

    implementation("org.apache.jena:apache-jena-libs:5.2.0")// https://mvnrepository.com/artifact/org.apache.jena/jena-ontapi
    implementation("org.apache.jena:jena-ontapi:5.2.0")


    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}