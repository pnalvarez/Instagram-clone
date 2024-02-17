package notifications

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.unit.dp

@Composable
fun NotificationRow(
    profileImage: Painter,
    notificationText: AnnotatedString,
    trailingImage: Painter
) {
    Row(
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(horizontal = 16.dp).fillMaxWidth()
    ) {
        Image(
            modifier = Modifier
                .size(44.dp)
                .clip(CircleShape),
            painter = profileImage,
            contentDescription = null,
        )
        Text(notificationText)
        Spacer(modifier = Modifier.weight(1f))
        Image(
            modifier = Modifier
                .size(44.dp)
                .clip(RectangleShape),
            painter = trailingImage,
            contentDescription = null,
        )
    }
}