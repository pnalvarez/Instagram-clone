package design_system.molecules.images

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource

object LogoImageConfig {
    enum class Size(
        val image: String,
        val height: Dp,
        val width: Dp
    ) {
        MEDIUM(image = "Instagram Logo@3x.png", height = 182.dp, width = 48.dp),
        LARGE(image = "Instagram Logo-Large.png", height = 28.dp, width = 105.dp)
    }
}

@OptIn(ExperimentalResourceApi::class)
@Composable
fun LogoImage(
    modifier: Modifier = Modifier,
    size: LogoImageConfig.Size = LogoImageConfig.Size.MEDIUM
) {
    Image(
        modifier = modifier.size(
            width = size.width,
            height = size.height
        ),
        painter = painterResource(size.image),
        contentDescription = null
    )
}