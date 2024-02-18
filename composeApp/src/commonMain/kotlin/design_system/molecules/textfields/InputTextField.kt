package design_system.molecules.textfields

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldColors
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import design_system.atoms.Colors
import design_system.atoms.Spacing

@Composable
fun InputTextField(
    modifier: Modifier = Modifier,
    text: MutableState<String>,
    label: String = "",
    placeholder: String = "",
    isSecure: Boolean = false) {
    TextField(
        modifier = modifier.border(
            1.dp,
            Colors.borderDefault,
            shape = RoundedCornerShape(8.dp)
        ),
        value = text.value,
        onValueChange = { newText ->
            text.value = newText
        },
        shape = RoundedCornerShape(8.dp),
        colors = TextFieldDefaults.textFieldColors(
            textColor = Colors.textDefault,
            backgroundColor = Colors.backgroundGrey,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            placeholderColor = Color(0x33000000)
        ),
        label = { Text(text = label) },
        placeholder = { Text(
            text = placeholder,
            textAlign = TextAlign.Center) }
    )
}