package general_catalog

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import design_system.molecules.buttons.ScreenLink
import design_system.molecules.buttons.ScreenLinkConfig
import design_system_catalog.DesignSystemCatalogScreen
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource
import prelogin.PreLoginScreen
import signin.SignInScreen

class CatalogScreen : Screen {
    @OptIn(ExperimentalResourceApi::class)
    @Composable
    override fun Content() {
        val profileImage = painterResource("pedro.jpeg")
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp)
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            ScreenLink(
                "Pre Login", PreLoginScreen(
                    profileImage = profileImage,
                    userName = "eupedroalvarez"
                )
            )
            ScreenLink(
                "Sign In",
                SignInScreen()
            )
            ScreenLink(
                "Design System",
                DesignSystemCatalogScreen(),
                type = ScreenLinkConfig.LinkType.FLOW
            )
        }
    }
}