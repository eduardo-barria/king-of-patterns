@file:Suppress("PropertyName", "SpellCheckingInspection")

plugins {
  kotlin("jvm") version "1.4.10"
  java
}

group = "cl.uchile.dcc"
version = "1.0.3.1"

repositories {
  mavenCentral()
  jcenter()
}

dependencies {
  implementation(kotlin("stdlib"))
  implementation(group = "org.jetbrains", name = "annotations", version = "19.0.0")
  // JUnit
  testImplementation(group = "org.junit.jupiter", name = "junit-jupiter-api", version = "5.7.0")
  testRuntimeOnly(group = "org.junit.jupiter", name = "junit-jupiter-engine", version = "5.7.0")
}

tasks {
  test {
    useJUnitPlatform()
  }
}
