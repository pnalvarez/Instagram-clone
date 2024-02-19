package signin

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.model.rememberScreenModel
import cafe.adriel.voyager.core.screen.Screen
import common.BaseScreen
import design_system.atoms.Colors
import design_system.atoms.Spacing
import design_system.molecules.buttons.LinkButton
import design_system.molecules.buttons.TertiaryMainButton
import design_system.molecules.buttons.TertiaryMainButtonPrimaryConfig
import design_system.molecules.images.LogoImage
import design_system.molecules.textfields.InputTextField
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource

class SignInScreen: Screen {
    @Composable
    private fun BottomContent() {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(64.dp)
                .background(Color.White),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            Divider(
                modifier = Modifier
                .height(1.dp)
                .background(
                    Color(0x153C3C43)
                )
            )
            Text(
                modifier = Modifier.padding(top = Spacing.xxl),
                text = "Instagram or Facebook",
                fontSize = 12.sp,
                color = Color(0x66000000)
            )
        }
    }

    @Composable
    private fun PasswordRecoveryButton() {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.End
        ) {
            Spacer(modifier = Modifier.weight(1f))
            LinkButton(
                modifier = Modifier.padding(top = Spacing.l),
                text = "Forgot password?",
                onClick = { }
            )
        }
    }

    @Composable
    private fun OrDivider() {
        Row(
            modifier = Modifier
            .padding(top = Spacing.xxxl)
            .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(Spacing.xxl)) {

            Divider(
                Modifier.height(1.dp).fillMaxWidth().weight(1f),
                Colors.dividerGrey
            )

            Text(
                modifier = Modifier.width(24.dp),
                text = "OR",
                fontSize = 12.sp,
                color = Colors.textTransparent
            )

            Divider(
                Modifier.height(1.dp).fillMaxWidth().weight(1f),
                Colors.dividerGrey
            )
        }
    }

    @Composable
    private fun SignUpButton() {
        Row(
            modifier = Modifier.padding(top = Spacing.xxxl),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                "Don't have an account? ",
                fontSize = 14.sp,
                color = Colors.textTransparent
            )
            LinkButton(
                text = "Sign up",
                onClick = { }
            )
        }
    }

    @OptIn(ExperimentalResourceApi::class)
    @Composable
    private fun Body() {
        val screenModel = rememberScreenModel { SignInScreenModel() }
        val state by screenModel.state.collectAsState()

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = Spacing.m),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Spacer(modifier = Modifier.fillMaxHeight(0.1f))

            LogoImage()

            InputTextField(
                modifier = Modifier.padding(top = Spacing.lx4).fillMaxWidth(),
                text = state.username,
                placeholder = "Username"
            )

            InputTextField(
                modifier = Modifier.padding(top = Spacing.s).fillMaxWidth(),
                text = state.password,
                placeholder = "Password"
            )

            PasswordRecoveryButton()

            TertiaryMainButton(
                modifier = Modifier.padding(top = Spacing.xxxl),
                text = "Login with Facebook",
                onClick = { },
                image = painterResource("facebook-logo.png"),
                imageAlignment = TertiaryMainButtonPrimaryConfig.ImageAlignment.START
            )

            OrDivider()

            SignUpButton()
        }
    }

    @Composable
    override fun Content() {
        BaseScreen(content = {
            Body()
        }, bottomBar = {
            BottomContent()
        })
    }
}