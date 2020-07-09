plugins {
  java
  id("application")
  id("org.openjfx.javafxplugin") version "0.0.8"
}

group = "com.github.c3002"
version = "1.0"

repositories {
  mavenCentral()
}

dependencies {
  implementation(group = "org.jetbrains", name = "annotations", version = "19.0.0")
  implementation(group = "org.openjfx", name = "javafx-controls", version = "15-ea+7")
}

application {
  mainClassName = "$moduleName/com.github.cc3002.yugi.gui.KingOfPatterns"
}

javafx {
  version = "15-ea+7"
  modules = listOf("javafx.controls")
}

configure<JavaPluginConvention> {
  sourceCompatibility = JavaVersion.VERSION_HIGHER
}