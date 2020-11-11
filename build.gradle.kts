@file:Suppress("PropertyName", "SpellCheckingInspection")

val ktor_version: String by project
val kotlin_version: String by project
val logback_version: String by project
val exposed_version: String by project
val sqlite_version: String by project

plugins {
  application
  kotlin("jvm") version "1.4.10"
}

group = "cl.uchile.dcc"
version = "0.1"

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
