package design_system.molecules.buttons

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow

data object ScreenLinkConfig {
    enum class LinkType(val style: PrimaryMainButtonConfig.Style) {
        SCREEN(style = PrimaryMainButtonConfig.Style.BRAND),
        FLOW(style = PrimaryMainButtonConfig.Style.ACCENT)
    }
}

@Composable
fun ScreenLink(
    name: String,
    screen: Screen,
    type: ScreenLinkConfig.LinkType = ScreenLinkConfig.LinkType.SCREEN
) {
    val navigator = LocalNavigator.currentOrThrow
    PrimaryMainButton(
        modifier = Modifier
            .padding(horizontal = 20.dp)
            .fillMaxWidth(),
        text = name,
        onClick = {
            navigator.push(screen)
        },
        style = type.style
    )
}