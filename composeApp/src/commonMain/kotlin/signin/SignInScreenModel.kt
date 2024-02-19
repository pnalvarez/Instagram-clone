package signin

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import cafe.adriel.voyager.core.model.ScreenModel
import cafe.adriel.voyager.core.model.StateScreenModel

class SignInScreenModel(initialState: State = State()) : StateScreenModel<SignInScreenModel.State>(
    initialState
) {
    data class State(
        var username: MutableState<String> = mutableStateOf(""),
        var password: MutableState<String> = mutableStateOf("")
    )
}