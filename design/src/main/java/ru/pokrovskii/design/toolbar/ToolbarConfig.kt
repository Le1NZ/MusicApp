package ru.pokrovskii.design.toolbar


data class ToolbarConfig(
    val icons: List<ToolbarIcon>,
) {

    companion object {

        val PREVIEW = ToolbarConfig(
            icons = listOf(
                ToolbarIcon.Search(
                    onClick = { },
                ),
                ToolbarIcon.Favorites(
                    onClick = { },
                ),
            )
        )
    }
}