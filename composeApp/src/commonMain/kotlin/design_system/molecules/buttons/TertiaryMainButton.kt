package design_system.molecules.buttons

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

data object TertiaryMainButtonPrimaryConfig {
    enum class ImageAlignment {
        START, END
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
fun TertiaryMainButton(
    modifier: Modifier = Modifier,
    text: String,
    image: Painter? = null,
    imageAlignment: TertiaryMainButtonPrimaryConfig.ImageAlignment = TertiaryMainButtonPrimaryConfig.ImageAlignment.START,
    status: TertiaryMainButtonPrimaryConfig.Status = TertiaryMainButtonPrimaryConfig.Status.ENABLED,
    onClick: () -> Unit
) {
    Row {
        when (imageAlignment) {
            TertiaryMainButtonPrimaryConfig.ImageAlignment.START ->
                StartImageContent(
                    modifier = modifier,
                    text = text,
                    image = image,
                    status = status,
                    onClick = onClick
                )

            TertiaryMainButtonPrimaryConfig.ImageAlignment.END ->
                EndImageContent(
                    modifier = modifier,
                    text = text,
                    image = image,
                    status = status,
                    onClick = onClick
                )
        }
    }
}

@Composable
private fun StartImageContent(
    modifier: Modifier,
    text: String,
    image: Painter? = null,
    status: TertiaryMainButtonPrimaryConfig.Status,
    onClick: () -> Unit
) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        if (image != null)
            Image(
                image,
                modifier = Modifier.size(16.dp),
                contentDescription = null
            )
        Text(
            modifier = modifier
                .clickable(
                    enabled = status.isInteractionEnabled
                ) { onClick() }
                .alpha(status.opacity),
            text = text,
            color = Color(0xFF3797EF),
            textAlign = TextAlign.Center,
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
private fun EndImageContent(
    modifier: Modifier,
    text: String,
    image: Painter? = null,
    status: TertiaryMainButtonPrimaryConfig.Status,
    onClick: () -> Unit
) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            modifier = modifier
                .clickable(
                    enabled = status.isInteractionEnabled
                ) { onClick() }
                .alpha(status.opacity),
            text = text,
            color = Color(0xFF3797EF),
            textAlign = TextAlign.Center,
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold
        )
        if (image != null)
            Image(
                image,
                modifier = Modifier.size(16.dp),
                contentDescription = null
            )
    }
}