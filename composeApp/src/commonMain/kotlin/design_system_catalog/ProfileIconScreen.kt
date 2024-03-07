package design_system_catalog

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import common.BaseScreen
import design.ProfileIcon
import design.ProfileIconConfig
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource

class ProfileIconScreen: Screen {
    @OptIn(ExperimentalResourceApi::class)
    @Composable
    override fun Content() {
        BaseScreen(content = {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.spacedBy(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                ProfileIcon(
                    input = ProfileIconConfig.Input(
                        image = "pedro.jpeg",
                        username = "prelogin"),
                    context = ProfileIconConfig.Context.PreLogin()
                )
                ProfileIcon(
                    input = ProfileIconConfig.Input(
                        image = "pedro.jpeg",
                        username = "stories"),
                    context = ProfileIconConfig.Context.Stories(isLive = false)
                )
                ProfileIcon(
                    input = ProfileIconConfig.Input(
                        image = "pedro.jpeg",
                        username = "stories"),
                    context = ProfileIconConfig.Context.Stories(isLive = true)
                )
            }
        })
    }
}