package signin

import cafe.adriel.voyager.core.model.ScreenModel
import cafe.adriel.voyager.core.model.StateScreenModel

class SignInScreenModel(initialState: State = State()) : StateScreenModel<SignInScreenModel.State>(
    initialState
) {
    data class State(
        var someData: String? = null
    )
}