@file:Suppress("SpellCheckingInspection")

plugins {
  java
}

group = "uchile.dcc.cc3002"
version = "1.0-B.1"

repositories {
  mavenCentral()
}

dependencies {
  implementation(group = "org.jetbrains", name = "annotations", version = "19.0.0")
  testImplementation(group = "org.junit.jupiter", name = "junit-jupiter-api", version = "5.7.0")
  testRuntimeOnly(group = "org.junit.jupiter", name = "junit-jupiter-engine", version = "5.7.0")
}

tasks.named<Test>("test") {
  useJUnitPlatform()
}
