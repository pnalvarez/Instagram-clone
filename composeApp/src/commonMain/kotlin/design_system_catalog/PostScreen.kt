package design_system_catalog

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.core.screen.Screen
import common.BaseScreen
import design_system.atoms.Spacing
import design_system.organisms.PostCell
import design_system.organisms.PostCellConfig

class PostScreen : Screen {
    @Composable
    override fun Content() {
        BaseScreen(
            applyHorizontalPadding = false,
            content = {
                Column(modifier = Modifier
                    .verticalScroll(
                        rememberScrollState()),
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
                            topLikerName = "advlarissamartins",
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
                            topLikerName = "advlarissamartins",
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
                            topLikerName = "advlarissamartins",
                            likesCount = 20023
                        ),
                        commentInfo = PostCellConfig.Comments.CommentInfo(
                            descriptionComment = PostCellConfig.Comments.CommentLine(
                                author = "eupedroalvarez",
                                comment = "The game in Japan was amazing and I want to share some photos"
                            )),
                    )
                }
            })
    }
}