@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    `java-library`
    `maven-publish`
    alias(gradlePlugins.plugins.io.freefair.lombok)
}

dependencies {
    implementation(platform(platforms.spring.boot.dependencies))
    implementation(platform(platforms.spring.cloud.dependencies))
    implementation(platform(platforms.spring.cloud.alibaba.dependencies)) {
        exclude("com.alibaba", "fastjson")
    }
    implementation(libs.spring.boot.starter.web)
}