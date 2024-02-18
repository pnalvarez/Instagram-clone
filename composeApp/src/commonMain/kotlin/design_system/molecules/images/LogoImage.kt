package design_system.molecules.images

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource

@OptIn(ExperimentalResourceApi::class)
@Composable
fun LogoImage(modifier: Modifier = Modifier) {
    Image(
        modifier = modifier.size(
            width = 182.dp,
            height = 48.dp
        ),
        painter = painterResource("Instagram Logo@3x.png"),
        contentDescription = null
    )
}