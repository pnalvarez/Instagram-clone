package common

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import general_catalog.CatalogScreen
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource

@OptIn(ExperimentalResourceApi::class)
@Composable
fun BaseScreen(
    content: @Composable () -> Unit,
    bottomBar: @Composable () -> Unit = { }
) {
    val navigator = LocalNavigator.currentOrThrow
    Scaffold(topBar = {
        Image(
            modifier = Modifier
                .size(64.dp)
                .padding(20.dp)
                .clickable {
                    if (navigator.canPop) navigator.pop()
                },
            painter = painterResource("back-arrow.png"),
            contentDescription = null
        )
    }, bottomBar = bottomBar) {
        content()
    }
}