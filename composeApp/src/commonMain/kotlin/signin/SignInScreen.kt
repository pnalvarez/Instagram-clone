package signin

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import cafe.adriel.voyager.core.model.rememberScreenModel
import cafe.adriel.voyager.core.screen.Screen
import common.BaseScreen

class SignInScreen: Screen {
    @Composable
    override fun Content() {
        val screenModel = rememberScreenModel { SignInScreenModel() }
        val state by screenModel.state.collectAsState()

        BaseScreen(content = {

        }, bottomBar = {

        })
    }
}