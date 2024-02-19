package prelogin

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.model.ScreenModel
import cafe.adriel.voyager.core.screen.Screen
import common.BaseScreen
import design_system.molecules.buttons.PrimaryMainButton
import design.ProfileIcon
import design.ProfileIconConfig
import design_system.atoms.Spacing
import design_system.molecules.buttons.TertiaryMainButton
import design_system.molecules.images.LogoImage
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource

class PreLoginViewModel : ScreenModel {

}

class PreLoginScreen(
    private val profileImage: String,
    private val userName: String
) : Screen {
    @Composable
    override fun Content() {
        Screen()
    }

    @Composable
    private fun DottedLine(pathEffect: PathEffect) {
        Canvas(
            modifier = Modifier
                .fillMaxWidth()
                .height(1.dp)
        ) {
            drawLine(
                color = Color(0xFF3C3C43),
                start = Offset(0f, 0f),
                end = Offset(size.width, 0f),
                pathEffect = pathEffect
            )
        }
    }

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
            val pathEffect = PathEffect.dashPathEffect(
                floatArrayOf(10f, 0f),
                0f
            )
            val annotatedString = buildAnnotatedString {
                withStyle(
                    SpanStyle(
                        color = Color(0x66000000),
                        fontWeight = FontWeight.Normal,
                        fontSize = 12.sp
                    )
                ) {
                    append("Don't have an account? ")
                    withStyle(
                        SpanStyle(
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFF000000)
                        )
                    ) {
                        append("Sign up")
                    }
                }
            }
            DottedLine(pathEffect)
            Text(
                annotatedString,
                modifier = Modifier.padding(18.dp)
            )
        }
    }


    @OptIn(ExperimentalResourceApi::class)
    @Composable
    private fun Screen() {
        BaseScreen(content = {
            Column(
                modifier = Modifier.fillMaxSize().offset(y = (-64).dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                LogoImage()

                ProfileIcon(
                    modifier = Modifier.padding(top = Spacing.lx4),
                    input = ProfileIconConfig.Input(image = profileImage, username = userName),
                    context = ProfileIconConfig.Context.PreLogin
                )

                PrimaryMainButton(
                    modifier = Modifier
                        .padding(top = Spacing.s)
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp),
                    text = "Log in",
                    onClick = { }
                )

                TertiaryMainButton(
                    modifier = Modifier.padding(top = Spacing.xxl),
                    text = "Switch accounts",
                    onClick = { }
                )
            }
        }, bottomBar = {
            BottomContent()
        })
    }
}