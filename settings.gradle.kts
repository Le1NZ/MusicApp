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

rootProject.name = "Practics"
include(":app")
include(":design")
include(":navigation")
include(":network")
include(":model")
include(":screens:song-screen")
include(":implementation")
include(":screens:search-screen")
include(":screens:favorites-screen")
include(":database")
