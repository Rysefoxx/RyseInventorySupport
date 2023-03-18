import org.jetbrains.kotlin.gradle.plugin.mpp.pm20.util.archivesName

group = "io.github.rysefoxx.inventory.bot.tag"
archivesName.set("Supportbot-Tag")

repositories {
    maven("https://jitpack.io/")
}

dependencies {
    compileOnly("net.dv8tion:JDA:5.0.0-beta.5")
    compileOnly("com.github.minndevelopment:jda-ktx:0.10.0-beta.1")

    compileOnly(project(":command-bridge"))
    compileOnly(project(":document"))
    compileOnly(project(":extension"))
    compileOnly(project(mapOf("path" to ":spring:model")))
    compileOnly("org.springframework.boot:spring-boot-starter-data-jpa:2.7.2")
}