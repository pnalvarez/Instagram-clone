package design_system.molecules.buttons

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

data object PrimaryMainButtonConfig {
    enum class ImageAlignment {
        START, END
    }

    enum class Style(val backgroundColor: Color) {
        BRAND(backgroundColor = Color(0xFF3797EF)),
        ACCENT(backgroundColor = Color(0xFF191919))
    }

    enum class Status(
        val opacity: Float,
        val isInteractionEnabled: Boolean
    ) {
        ENABLED(opacity = 1f, isInteractionEnabled = true),
        DISABLED(opacity = 0.4f, isInteractionEnabled = false)
    }
}

@Composable
private fun IconImage(image: Painter?) {
    if (image == null) return
    Image(
        image,
        modifier = Modifier.size(16.dp),
        contentDescription = null
    )
}

@Composable
private fun ContentText(text: String) {
    Text(
        text = text,
        modifier = Modifier
            .padding(16.dp)
            .background(Color.Transparent),
        color = Color.White,
        textAlign = TextAlign.Center,
        fontSize = 18.sp
    )
}

@Composable
fun PrimaryMainButton(
    modifier: Modifier = Modifier,
    text: String,
    image: Painter? = null,
    imageAlignment: PrimaryMainButtonConfig.ImageAlignment = PrimaryMainButtonConfig.ImageAlignment.START,
    style: PrimaryMainButtonConfig.Style = PrimaryMainButtonConfig.Style.BRAND,
    status: PrimaryMainButtonConfig.Status = PrimaryMainButtonConfig.Status.ENABLED,
    onClick: () -> Unit
) {

    Card(
        modifier = modifier
            .clickable(
                enabled = status.isInteractionEnabled
            ) { onClick() }
            .alpha(status.opacity),
        shape = RoundedCornerShape(8.dp),
        backgroundColor = style.backgroundColor,
    ) {
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            when (imageAlignment) {
                PrimaryMainButtonConfig.ImageAlignment.START -> {
                    IconImage(image = image)
                    ContentText(text = text)
                }

                PrimaryMainButtonConfig.ImageAlignment.END -> {
                    ContentText(text = text)
                    IconImage(image = image)
                }
            }
        }
    }
}