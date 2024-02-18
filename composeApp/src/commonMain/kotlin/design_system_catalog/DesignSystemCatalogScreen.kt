package design_system_catalog

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import common.BaseScreen
import design_system.molecules.buttons.ScreenLink

class DesignSystemCatalogScreen: Screen {
   @Composable
    override fun Content() {
        BaseScreen(content = {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(20.dp)
                    .verticalScroll(rememberScrollState()),
                verticalArrangement = Arrangement.spacedBy(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                ScreenLink("Buttons", ButtonScreen())
                ScreenLink("Profile Icon", ProfileIconScreen())
                ScreenLink("Text Fields", InputTextFieldScreen())
            }
        })
    }
}