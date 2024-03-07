package design

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import design_system.atoms.Spacing
import design_system.molecules.badges.Badge
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource

object ProfileIconConfig {
    sealed class Context(
        val shouldHighlight: Boolean,
        val usernameShouldBeBold: Boolean,
        val isLive: Boolean
    ) {
        class PreLogin: Context(
            shouldHighlight = false,
            usernameShouldBeBold = true,
            isLive = false
        )

        class Stories(isLive: Boolean): Context(
            shouldHighlight = true,
            usernameShouldBeBold = false,
            isLive
        )
    }

    enum class Axis {
        HORIZONTAL, VERTICAL
    }

    data class Input(
        val image: String,
        val username: String,
        val isLive: Boolean = false
    )
}

@Composable
private fun LiveBadge(isLive: Boolean) {
    if (isLive) Badge(modifier = Modifier.offset(y = Spacing.xxs), title ="LIVE")
}

@OptIn(ExperimentalResourceApi::class)
@Composable
fun ProfileIcon(
    modifier: Modifier = Modifier,
    input: ProfileIconConfig.Input,
    context: ProfileIconConfig.Context
) {
    val gradientColors = listOf(Color(0xFFFBAA47), Color(0xFFD91A46), Color(0xFFA60F93))
    val gradient = Brush.linearGradient(
        colors = gradientColors)

    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(contentAlignment = Alignment.BottomCenter) {
            Image(
                modifier = Modifier
                    .size(80.dp)
                    .clip(CircleShape)
                    .border(
                        BorderStroke(if (context.shouldHighlight) 3.dp else 0.dp, gradient),
                        shape = CircleShape
                    ),
                painter = painterResource(input.image),
                contentDescription = null,
            )
            LiveBadge(context.isLive)
        }
        Text(
            modifier = Modifier
                .padding(top = 8.dp),
            text = input.username,
            fontWeight =
            if (context.usernameShouldBeBold) FontWeight.Bold else FontWeight.Normal,
            fontSize = 12.sp
        )
    }
}