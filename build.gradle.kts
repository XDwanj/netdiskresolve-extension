import org.jetbrains.compose.compose
import org.jetbrains.compose.desktop.application.dsl.TargetFormat
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
  id("org.springframework.boot") version "2.7.0"
  id("io.spring.dependency-management") version "1.0.11.RELEASE"
  id("org.jetbrains.compose") version "1.0.0"
  kotlin("jvm") version "1.5.31"
  kotlin("plugin.spring") version "1.5.31"
}

group = "cn.xdwanj"
version = "1.0"
java.sourceCompatibility = JavaVersion.VERSION_11

repositories {
  maven { url = uri("https://maven.aliyun.com/repository/central") }
  maven { url = uri("https://maven.aliyun.com/repository/public") }
  maven { url = uri("https://maven.aliyun.com/repository/gradle-plugin") }
  google()
  mavenCentral()
  maven { url = uri("https://maven.pkg.jetbrains.space/public/p/compose/dev") }
}

val springVersion = "5.3.20"
val springBootVersion = "2.7.0"

dependencies {
  implementation(compose.desktop.currentOs)
  implementation("com.squareup.okhttp3:okhttp:4.10.0-RC1")
  implementation("com.google.code.gson:gson:2.9.0")
  implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.1-native-mt")

  implementation("org.springframework.boot:spring-boot-starter")
  implementation("org.springframework.boot:spring-boot-starter-web")
  implementation("com.fasterxml.jackson.module:jackson-module-kotlin")

  testImplementation("org.springframework.boot:spring-boot-starter-test")
  testImplementation("junit:junit:4.13.2")
}

tasks.withType<KotlinCompile>() {
  kotlinOptions.jvmTarget = "11"
}

compose.desktop {
  application {
    mainClass = "MainKt"
    nativeDistributions {
      targetFormats(TargetFormat.Dmg, TargetFormat.Msi, TargetFormat.Deb)
      packageName = "netdiskresolve-extension"
      packageVersion = "1.0.0"
    }
  }
}