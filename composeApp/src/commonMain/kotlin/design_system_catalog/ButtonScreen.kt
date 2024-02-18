package design_system_catalog

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import common.BaseScreen
import design_system.molecules.buttons.TertiaryMainButton
import design_system.molecules.buttons.TertiaryMainButtonPrimaryConfig
import design_system.molecules.buttons.PrimaryMainButton
import design_system.molecules.buttons.PrimaryMainButtonConfig
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource

class ButtonScreen: Screen {
    @OptIn(ExperimentalResourceApi::class)
    @Composable
    override fun Content() {
        BaseScreen(content = {
            Column(
                modifier = Modifier
                .fillMaxSize()
                .padding(20.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally) {
                PrimaryMainButton(
                    modifier = Modifier.fillMaxWidth(),
                    text = "Primary Button - Enabled",
                    onClick = { }
                )
                PrimaryMainButton(
                    modifier = Modifier.fillMaxWidth(),
                    text = "Primary Button - Disabled",
                    status = PrimaryMainButtonConfig.Status.DISABLED,
                    onClick = { }
                )
                PrimaryMainButton(
                    modifier = Modifier.fillMaxWidth(),
                    text = "Primary Button - Image Start",
                    image = painterResource("facebook-logo.png"),
                    imageAlignment = PrimaryMainButtonConfig.ImageAlignment.START,
                    onClick = { }
                )
                PrimaryMainButton(
                    modifier = Modifier.fillMaxWidth(),
                    text = "Primary Button - Image End",
                    image = painterResource("facebook-logo.png"),
                    imageAlignment = PrimaryMainButtonConfig.ImageAlignment.END,
                    onClick = { }
                )
                TertiaryMainButton(
                    text = "Tertiary Button - Enabled",
                    onClick = { }
                )
                TertiaryMainButton(
                    text = "Tertiary Button - Disabled",
                    onClick = { },
                    status = TertiaryMainButtonPrimaryConfig.Status.DISABLED
                )
                TertiaryMainButton(
                    text = "Tertiary Button - Image Start",
                    image = painterResource("facebook-logo.png"),
                    imageAlignment = TertiaryMainButtonPrimaryConfig.ImageAlignment.START,
                    onClick = { }
                )
                TertiaryMainButton(
                    text = "Tertiary Button - Image End",
                    image = painterResource("facebook-logo.png"),
                    imageAlignment = TertiaryMainButtonPrimaryConfig.ImageAlignment.END,
                    onClick = { }
                )
            }
        })
    }
}