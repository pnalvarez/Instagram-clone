package feed

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Divider
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.model.rememberScreenModel
import cafe.adriel.voyager.core.screen.Screen
import design_system.atoms.Colors
import design_system.atoms.Spacing
import design_system.molecules.images.LogoImage
import design_system.molecules.images.LogoImageConfig
import design_system.organisms.PostCell
import design_system.organisms.PostCellConfig
import feed.subcomponents.StoriesComponent
import feed.subcomponents.StoriesConfig
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource

class FeedScreen: Screen {
    @Composable
    override fun Content() {
        val screenModel = rememberScreenModel { FeedScreenModel() }
        Scaffold(topBar = {
            TopHeader()
        }, content = {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState()),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Top
            ) {
                StoriesComponent(
                    modifier = Modifier.fillMaxWidth().padding(top = Spacing.m),
                    input = screenModel.state.value.stories
                )
                Divider(modifier = Modifier.padding(top = Spacing.m))
                PostSection(modifier = Modifier.padding(top = Spacing.xl))
            }
        })
    }

    @OptIn(ExperimentalResourceApi::class)
    @Composable
    private fun TopHeader() {
        Column(modifier = Modifier.fillMaxWidth()) {
            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                Row(
                    modifier = Modifier
                        .padding(bottom = Spacing.m)
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    Image(
                        modifier = Modifier
                            .padding(start = Spacing.s)
                            .size(24.dp)
                            .clickable { println("Camera") },
                        painter = painterResource("camera.png"),
                        contentDescription = null
                    )
                    Spacer(modifier = Modifier.weight(1f))
                    Image(
                        modifier = Modifier
                            .padding(end = Spacing.l)
                            .size(24.dp)
                            .clickable { println("Share") },
                        painter = painterResource("igtv.png"),
                        contentDescription = null
                    )
                    Image(
                        modifier = Modifier
                            .padding(end = Spacing.l)
                            .size(24.dp)
                            .clickable { println("Share") },
                        painter = painterResource("Messenger.png"),
                        contentDescription = null
                    )
                }
                LogoImage(size = LogoImageConfig.Size.LARGE, modifier = Modifier.fillMaxWidth())
            }
            Divider()
        }
    }

    @Composable
    private fun PostSection(modifier: Modifier = Modifier) {
        Column(
            modifier = modifier,
            verticalArrangement = Arrangement.spacedBy(Spacing.xl)
        ) {
            PostCell(
                name = "joshua_l",
                isVerified = true,
                image = "man.png",
                place = "Tokyo, Japan",
                postImage = "post_photo.png",
                likeInfo = PostCellConfig.LikeInfo(
                    images = listOf("thumb-like.png", "thumb-like.png"),
                    topLikerName = "eupedroalvarez",
                    likesCount = 20000
                ),
                commentInfo = PostCellConfig.Comments.CommentInfo(
                    descriptionComment = PostCellConfig.Comments.CommentLine(
                        author = "eupedroalvarez",
                        comment = "The game in Japan was amazing and I want to share some photos"
                    ),
                    otherCommentsCount = 2,
                    highlightedComment = PostCellConfig.Comments.CommentLine(
                        author = "eupedroalvarez",
                        comment = "The game in Japan was amazing and I want to share some photos"
                    )),
            )
            PostCell(
                name = "eupedroalvarez",
                isVerified = true,
                image = "man.png",
                place = "Tokyo, Japan",
                postImage = "post_photo.png",
                likeInfo = PostCellConfig.LikeInfo(
                    images = listOf("thumb-like.png", "thumb-like.png", "thumb-like.png"),
                    topLikerName = "eupedroalvarez",
                    likesCount = 20000
                ),
                commentInfo = PostCellConfig.Comments.CommentInfo(
                    descriptionComment = PostCellConfig.Comments.CommentLine(
                        author = "eupedroalvarez",
                        comment = "The game in Japan was amazing and I want to share some photos"
                    ),
                    otherCommentsCount = 10),
            )
            PostCell(
                name = "eupedroalvarez",
                isVerified = false,
                image = "man.png",
                place = "Tokyo, Japan",
                postImage = "post_photo.png",
                likeInfo = PostCellConfig.LikeInfo(
                    images = listOf("thumb-like.png"),
                    topLikerName = "eupedroalvarez",
                    likesCount = 20023
                ),
                commentInfo = PostCellConfig.Comments.CommentInfo(
                    descriptionComment = PostCellConfig.Comments.CommentLine(
                        author = "eupedroalvarez",
                        comment = "The game in Japan was amazing and I want to share some photos"
                    )),
            )
        }
    }
}