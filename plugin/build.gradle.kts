plugins{
    id("net.minecrell.plugin-yml.bukkit") version "0.5.2"
    id("com.github.johnrengelman.shadow") version "7.1.2"
}

dependencies{
    bukkitLibrary("com.google.code.gson", "gson", "2.8.9")
    compileOnly("org.spigotmc:spigot-api:1.19.2-R0.1-SNAPSHOT")
    implementation("org.jetbrains:annotations:23.0.0")
    compileOnly("org.projectlombok:lombok:1.18.24")
    annotationProcessor("org.projectlombok:lombok:1.18.24")
    implementation(project(":api"))
}

bukkit {
    main = "io.github.emanuelmcp.RpMmo"
    apiVersion = "1.19"
    prefix = "TEST"
}