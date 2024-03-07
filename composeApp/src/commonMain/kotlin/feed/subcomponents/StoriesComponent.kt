package feed.subcomponents

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import design.ProfileIcon
import design.ProfileIconConfig
import design_system.atoms.Spacing

data object StoriesConfig {
    data class Input(val stories: List<ProfileIconConfig.Input>)
}
@Composable
fun StoriesComponent(
    modifier: Modifier = Modifier,
    input: StoriesConfig.Input
) {
    LazyRow(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.Top
    ) {
        items(input.stories) {item ->
            ProfileIcon(
                modifier = Modifier.padding(horizontal = 5.dp),
                input = item,
                context = ProfileIconConfig.Context.Stories(isLive = false)
            )
        }
    }
}