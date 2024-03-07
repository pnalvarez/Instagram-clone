package design_system.molecules.badges

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Badge(modifier: Modifier = Modifier, title: String) {
    val gradientColors = listOf(
        Color(0xFFC90083),
        Color(0xFFD22463),
        Color(0xFFE10038
        )
    )
    val gradient = Brush.linearGradient(
        colors = gradientColors,
        start = Offset(0f, 0f),
        end = Offset(100f, 100f)
    )
    Surface(
        modifier = modifier.clip(RoundedCornerShape(4.dp)),
    ) {
        Box(
            modifier = Modifier.background(Color.Yellow),
            contentAlignment = Alignment.Center
        ) {
            Box(
                modifier = Modifier
                    .background(gradient)
                    .padding(2.dp),
                contentAlignment = Alignment.Center) {
                Text(
                    modifier = Modifier
                        .padding(2.dp)
                        .background(Color.Transparent),
                    text = title,
                    fontSize = 12.sp,
                    color = Color.White
                )
            }
        }
    }
}