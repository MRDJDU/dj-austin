rootProject.name = "dj-austin"

include(":dj-austin-web")
include(":dj-austin-common")
include(":dj-austin-message")

dependencyResolutionManagement {
    versionCatalogs {
        val kotlin = "1.8.0"
        val sonarqube = "3.5.0.2730"
        val ioFreefairLombok = "6.6.1"
        val springboot = "2.5.14"
        val springbootDependencymanagement = "1.1.0"
        val springCloud = "2020.0.6"
        val springCloudAlibaba = "2021.1"
        val postgisJdbc = "2.5.1"
        val postgresql = "42.5.0"
        val hutoolAll = "5.7.15"
        val guava = "31.0.1-jre"
        val okhttp = "4.9.2"
        val fastjson2 = "2.0.53"
        val mail = "1.6.2"
        val apmToolkitLogback1X = "8.12.0"
        val apmToolkitTrace = "8.12.0"
        val logstashLogbackEncoder = "7.4"
        create("gradlePlugins") {
            // 该插件为 Gradle 提供对 Kotlin 编程语言的支持，包括编译、测试和运行 Kotlin 代码的能力。它允许开发者在 Gradle 项目中无缝集成 Kotlin 代码，自动配置 Kotlin 编译器，并支持 Kotlin DSL 编写构建脚本
            plugin("kotlin-jvm", "org.jetbrains.kotlin.jvm").version(kotlin)
            // SonarQube 插件用于在 Gradle 构建过程中集成 SonarQube 进行代码质量分析。它可以检查代码中的潜在问题，并生成报告以帮助开发者提高代码质量
            plugin("org.sonarqube", "org.sonarqube").version(sonarqube)
            // Lombok 插件用于简化 Java 代码的编写，减少样板代码。通过注解的方式，Lombok 可以自动生成 getter、setter、构造函数等常用方法，从而提高开发效率
            plugin("io-freefair-lombok", "io.freefair.lombok").version(ioFreefairLombok)
            // Spring Boot 插件提供了对 Spring Boot 应用程序的支持，能够简化项目的构建和打包过程。它可以将项目打包为可执行的 JAR 或 WAR 文件，并支持运行 Spring Boot 应用程序
            plugin("springboot", "org.springframework.boot").version(springboot)
            // 此插件用于管理 Spring Boot 项目的依赖关系。它通过导入 spring-boot-dependencies BOM（Bill of Materials）来自动处理依赖版本，允许开发者在声明依赖时省略版本号，从而简化依赖管理
            plugin("springboot-dependencymanagement", "io.spring.dependency-management").version(
                springbootDependencymanagement
            )
        }
        // BOM 用于集中管理项目的依赖版本，用于简化和集中管理软件项目中的依赖关系，特别是在大型或多模块项目中
        create("platforms") {
            // 引入 Spring Boot 的 BOM，使得在项目中使用 Spring Boot 相关的依赖时，可以省略版本号。由于 BOM 中定义了所有相关依赖的版本，项目可以更轻松地维护和升级
            library("spring-boot-dependencies", "org.springframework.boot:spring-boot-dependencies:$springboot")
            // 引入 Spring Cloud 的 BOM，类似于 Spring Boot 的 BOM，提供了 Spring Cloud 组件的版本管理。这使得开发者能够方便地使用 Spring Cloud 的各种功能，而无需手动指定每个组件的版本
            library("spring-cloud-dependencies", "org.springframework.cloud:spring-cloud-dependencies:$springCloud")
            // 引入 Spring Cloud Alibaba 的 BOM，集中管理与 Alibaba 生态系统相关的 Spring Cloud 组件。这对于使用 Alibaba 提供的微服务解决方案非常重要，可以确保各个组件之间的版本兼容性
            library(
                "spring-cloud-alibaba-dependencies",
                "com.alibaba.cloud:spring-cloud-alibaba-dependencies:$springCloudAlibaba"
            )
        }
        create("libs") {
            // 这个库是用于连接和操作 PostGIS 数据库的 JDBC 驱动。PostGIS 是 PostgreSQL 的一个扩展，提供地理信息系统（GIS）功能。通过引入这个库，开发者可以在 Java 应用程序中使用 PostGIS 的功能，如空间查询和地理数据处理
            library("postgis-jdbc", "net.postgis:postgis-jdbc:$postgisJdbc")

            // 这个库是 PostgreSQL 数据库的官方 JDBC 驱动。它允许 Java 应用程序与 PostgreSQL 数据库进行连接和交互。通过使用这个驱动，开发者可以执行 SQL 查询、更新数据库记录等操作
            library("postgresql", "org.postgresql:postgresql:$postgresql")

            // 引入 Hutool 工具库，字符串处理、日期时间操作、文件操作、网络通信、加密解密、数据转换、图像处理、JSON 操作、Excel处理
            library("hutool-all", "cn.hutool:hutool-all:$hutoolAll")

            // 增强 Java 标准库功能的工具和类，集合 、缓存、函数式编程、并发、 字符串处理、I/O、哈希、事件总线、数学工具计算、反射工具
            library("guava", "com.google.guava:guava:$guava")

            // 提供了高效、可靠的网络请求功能，支持 HTTP/2 和 WebSocket，可以有效地处理并发请求和长连接，内置连接池机制，可以重用连接以提高性能，减少延迟，支持自定义拦截器，可以在请求和响应之间添加自定义逻辑，如日志记录、身份验证
            // 简单的异步 API，使得发起网络请求时不会阻塞主线程，内置缓存机制，可以缓存响应数据，提高应用性能，并减少网络流量，提供了丰富的错误处理机制，可以方便地处理各种网络错误和异常情况
            library("okhttp", "com.squareup.okhttp3:okhttp:$okhttp")

            // 高效、安全地处理 JSON 数据
            library("fastjson2", "com.alibaba.fastjson2:fastjson2:$fastjson2")

            // 用于发送和接收电子邮件的标准库。它支持多种邮件协议，如 SMTP、POP3 和 IMAP
            library("mail", "com.sun.mail:javax.mail:$mail")

            // 将 SkyWalking 集成到 Logback 日志框架中
            // 通过引入 apm-toolkit-logback 和 apm-toolkit-trace 库，开发者可以轻松地将 Apache SkyWalking 集成到使用 Logback 的 Java 应用程序中，从而实现高效的分布式追踪和日志记录。
            library("apm-toolkit-logback", "org.apache.skywalking:apm-toolkit-logback-1.x:$apmToolkitLogback1X")
            library("apm-toolkit-trace", "org.apache.skywalking:apm-toolkit-trace:$apmToolkitTrace")

            // 开发者能够方便地将应用程序的日志以 JSON 格式输出，并通过 TCP 或 UDP 等方式发送到 Logstash。
            library("logstash-logback-encoder", "net.logstash.logback:logstash-logback-encoder:$logstashLogbackEncoder")

            // Spring Boot 提供的一个起步依赖，专门用于构建 Web 应用程序。
            // Gradle根据platforms.spring.boot.dependencies自动管理版本
            // 1、Spring MVC: 提供了构建 RESTful Web 服务和传统 Web 应用所需的 Spring MVC 框架。
            // 2、嵌入式服务器: 默认包含嵌入式 Tomcat 服务器（也可以选择 Jetty 或 Undertow），使得应用程序可以独立运行，无需外部服务器支持。
            // 3、JSON 处理: 集成了 Jackson 库，用于处理 JSON 数据格式，使得数据序列化和反序列化变得简单
            // 当您引入 spring-boot-starter-web 时，它实际上会自动引入 spring-boot-starter-logging 依赖，而 spring-boot-starter-logging 又包含了 Logback 的依赖。
            library("spring-boot-starter-web", "org.springframework.boot", "spring-boot-starter-web").withoutVersion()
        }
    }
}
