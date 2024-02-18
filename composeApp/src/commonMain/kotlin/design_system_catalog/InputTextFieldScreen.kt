package design_system_catalog

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.core.screen.Screen
import common.BaseScreen
import design_system.atoms.Spacing
import design_system.molecules.textfields.InputTextField

class InputTextFieldScreen: Screen {
    @Composable
    override fun Content() {
        BaseScreen(content = {
            val text = remember { mutableStateOf("") }
            InputTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = Spacing.l),
                text = text,
                placeholder = "Some placeholder"
            )
        })
    }
}