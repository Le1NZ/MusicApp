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
include(":database")
include(":design")
include(":implementation")
include(":likes-control")
include(":model")
include(":navigation")
include(":network")
include(":screens:favorites-screen")
include(":screens:search-screen")
include(":screens:song-item")
include(":screens:song-screen")
include(":notification")
