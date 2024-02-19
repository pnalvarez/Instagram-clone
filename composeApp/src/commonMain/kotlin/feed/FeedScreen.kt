package feed

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.core.model.rememberScreenModel
import cafe.adriel.voyager.core.screen.Screen
import feed.subcomponents.StoriesComponent
import feed.subcomponents.StoriesConfig

class FeedScreen: Screen {
    @Composable
    override fun Content() {
        val screenModel = rememberScreenModel { FeedScreenModel() }
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            StoriesComponent(
                modifier = Modifier.fillMaxWidth(),
                input = screenModel.state.value.stories
            )
        }
    }
}