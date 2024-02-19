package feed

import design.ProfileIconConfig
import feed.subcomponents.StoriesConfig
import org.jetbrains.compose.resources.painterResource

data class FeedState(
    val stories: StoriesConfig.Input = StoriesConfig.Input(
        stories = listOf(
            ProfileIconConfig.Input(
                image = "pedro.jpeg",
                username = "eupedroalvarez"
            ),
            ProfileIconConfig.Input(
                image = "pedro.jpeg",
                username = "eupedroalvarez"
            ),
            ProfileIconConfig.Input(
                image = "pedro.jpeg",
                username = "eupedroalvarez"
            ),
            ProfileIconConfig.Input(
                image = "pedro.jpeg",
                username = "eupedroalvarez"
            ),
            ProfileIconConfig.Input(
                image = "pedro.jpeg",
                username = "eupedroalvarez"
            ),
            ProfileIconConfig.Input(
                image = "pedro.jpeg",
                username = "eupedroalvarez"
            ),
            ProfileIconConfig.Input(
                image = "pedro.jpeg",
                username = "eupedroalvarez"
            )
        )
    )
)