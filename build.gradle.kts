import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

// https://youtrack.jetbrains.com/issue/KTIJ-19369
// 抑制与 DSL（领域特定语言）作用域违规相关的警告
@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    alias(gradlePlugins.plugins.kotlin.jvm)
    alias(gradlePlugins.plugins.org.sonarqube)
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

allprojects {
    group = "org.dj"
    version = "0.0.0.1"
    description = "dj投资通知"
    repositories {
        mavenLocal()
        maven(url = "https://maven.geotoolkit.org")
        maven(url = "https://maven.aliyun.com/nexus/content/groups/public")
        maven(url = "https://maven.aliyun.com/repository/gradle-plugin")
        maven(url = "https://maven.aliyun.com/repository/central")
        maven(url = "https://maven.aliyun.com/repository/jcenter")
        maven(url = "https://maven.aliyun.com/repository/google")
        maven(url = "https://repo.osgeo.org/repository/release")
    }
    tasks.withType<KotlinCompile> {
        kotlinOptions {
            freeCompilerArgs = listOf("-Xjsr305=strict")
            jvmTarget = "17"
        }
    }
}

subprojects {
    apply(plugin = "org.jetbrains.kotlin.jvm")
}