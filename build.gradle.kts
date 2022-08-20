subprojects{

    apply(plugin = "java")

    group = "io.github.emanuelmcp"
    version = "1.0.0"

    repositories {
        mavenCentral()
        mavenLocal()
        maven("https://repo.codemc.io/repository/nms/")
                maven("https://oss.sonatype.org/content/repositories/snapshots")
                maven("https://oss.sonatype.org/content/repositories/central")
                maven("https://hub.spigotmc.org/nexus/content/repositories/snapshots/")
    }

}