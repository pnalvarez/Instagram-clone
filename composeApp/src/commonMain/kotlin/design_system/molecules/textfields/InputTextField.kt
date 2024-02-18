package design_system.molecules.textfields

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
        modifier = modifier,
        value = text.value,
        onValueChange = { newText ->
            text.value = newText
        },
        shape = RoundedCornerShape(8.dp),
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = Colors.backgroundGrey,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            placeholderColor = Color.Red
        ),
        label = { Text(text = label, modifier = Modifier.offset(y = -Spacing.xxs)) },
        placeholder = { Text(
            text = placeholder,
            textAlign = TextAlign.Center,
            modifier = Modifier.offset(y = -Spacing.xxs)) }
    )
}