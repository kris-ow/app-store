pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "app-store"

// Auto-include every app under apps/ that has a build.gradle.kts.
// Drop a new module under apps/<name>/ and a Gradle sync picks it up.
val appsDir = file("apps")
if (appsDir.exists()) {
    appsDir.listFiles { f -> f.isDirectory && !f.name.startsWith("_") && File(f, "build.gradle.kts").exists() }
        ?.forEach { include(":apps:${it.name}") }
}
