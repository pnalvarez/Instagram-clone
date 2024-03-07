package design_system.organisms

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import design_system.atoms.Colors
import design_system.atoms.Spacing
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource

object PostCellConfig {
    data class LikeInfo(
        val images: List<String>,
        val topLikerName: String,
        val likesCount: Int
    )

    object Comments {
        data class CommentLine(
            val author: String,
            val comment: String
        )
        data class CommentInfo(
            val descriptionComment: CommentLine? = null,
            val otherCommentsCount: Int = 0,
            val highlightedComment: CommentLine? = null
        )
    }
}
@OptIn(ExperimentalResourceApi::class)
@Composable
private fun PostHeader(
    name: String,
    image: String,
    isVerified: Boolean,
    place: String
) {
    Row(
        modifier = Modifier.padding(horizontal = Spacing.m).fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start
    ) {
        Image(
            modifier = Modifier
                .size(32.dp)
                .clip(CircleShape),
            painter = painterResource(image),
            contentDescription = null,
        )

        Column(
            modifier = Modifier.padding(start = Spacing.s),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.Start
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = name,
                    color = Colors.textDefault,
                    fontWeight = FontWeight.Bold,
                    fontSize = 12.sp
                )
                Image(
                    modifier = Modifier.padding(start = Spacing.xxs).size(10.dp),
                    painter = painterResource("verified.png"),
                    contentDescription = null
                )
            }
            Text(
                text = place,
                color = Colors.textDefault,
                fontWeight = FontWeight.Normal,
                fontSize = 12.sp
            )
        }

        Spacer(modifier = Modifier.weight(1f))

        Image(
            modifier = Modifier.width(14.dp).height(3.dp),
            painter = painterResource("more.png"),
            contentDescription = null
        )
    }
}

@OptIn(ExperimentalResourceApi::class)
@Composable
private fun MainPhoto(modifier: Modifier = Modifier, image: String) {
    Box(modifier, contentAlignment = Alignment.TopEnd) {
        Image(
            modifier = Modifier.height(375.dp).fillMaxWidth(),
            painter = painterResource(image),
            contentDescription = null,
            contentScale = ContentScale.FillBounds
        )
        PhotoCounter(
            Modifier.padding(
                top = Spacing.l,
                end = Spacing.l
            ),
            1,
            3
        )
    }
}

@Composable
private fun PhotoCounter(
    modifier: Modifier = Modifier,
    count: Int,
    max: Int
) {
    Box(modifier = modifier
        .size(width = 34.dp, height = 26.dp)
        .clip(CircleShape)
        .background(Color(0xBB121212)),
        contentAlignment = Alignment.Center
    ) {
        Text(
            "$count/$max",
            color = Color.White,
            fontSize = 12.sp
        )
    }
}

@OptIn(ExperimentalResourceApi::class)
@Composable
private fun ReactionsRow(scrollCount: Int, scrollMax: Int) {
    Row(
        modifier = Modifier.padding(horizontal = Spacing.m).padding(top = Spacing.s),
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            modifier = Modifier.size(24.dp).clickable { println("Like") },
            painter = painterResource("Like.png"),
            contentDescription = null
        )
        Image(
            modifier = Modifier
                .padding(start = Spacing.l)
                .size(24.dp)
                .clickable { println("Comment") },
            painter = painterResource("Comment.png"),
            contentDescription = null
        )
        Image(
            modifier = Modifier
                .padding(start = Spacing.l)
                .size(24.dp)
                .clickable { println("Share") },
            painter = painterResource("Messenger.png"),
            contentDescription = null
        )
        PhotoScrollCount(scrollCount, scrollMax)
        Spacer(modifier = Modifier.weight(1f))
        Image(
            modifier = Modifier.size(24.dp).clickable { println("Save") },
            painter = painterResource("Save.png"),
            contentDescription = null
        )
    }
}

@OptIn(ExperimentalResourceApi::class)
@Composable
private fun LikesRow(
    images: List<String>,
    topLikerName: String,
    likesCount: Int
) {
    Row(
        modifier = Modifier
            .padding(top = Spacing.l)
            .padding(horizontal = Spacing.m)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start
    ) {
        val text = buildAnnotatedString {
            withStyle(SpanStyle(fontWeight = FontWeight.Normal)) {
                append("Liked by ")
            }
            withStyle(SpanStyle(fontWeight = FontWeight.Bold)) {
                append(topLikerName)
            }
            withStyle(SpanStyle(fontWeight = FontWeight.Normal)) {
                append(" and ")
            }
            withStyle(SpanStyle(fontWeight = FontWeight.Bold)) {
                append("$likesCount others")
            }
        }

        (images.indices).forEach { index ->
            Image(
                modifier = Modifier
                    .size(16.dp)
                    .graphicsLayer { translationX = 15f - index * 15f },
                painter = painterResource(images[index]),
                contentDescription = null
            )
        }
        Text(
            modifier = Modifier.padding(start = Spacing.xs),
            text = text,
            fontSize = 12.sp
        )
    }
}

@Composable
private fun PhotoScrollCount(count: Int, max: Int) {
    LazyRow(
        modifier = Modifier.padding(start = Spacing.lx7),
        horizontalArrangement = Arrangement.spacedBy(Spacing.xs),
        verticalAlignment = Alignment.CenterVertically
    ) {
        items(max) {item ->
            Box(
                modifier = Modifier
                    .size(6.dp)
                    .background(
                        if(count == item)
                            Colors.primaryBlue
                        else
                            Colors.secondaryGrey,
                        shape = CircleShape)
            )
        }
    }
}

@Composable
private fun CommentsSection(input: PostCellConfig.Comments.CommentInfo) {
    Column(
        modifier = Modifier.padding(horizontal = Spacing.m).padding(top = Spacing.xxs),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Top
    ) {
        if (input.descriptionComment != null)
            CommentLine(input.descriptionComment)
        if(input.otherCommentsCount > 0)
            Text(
                modifier = Modifier
                    .padding(vertical = Spacing.xxs)
                    .clickable { println("See comments") },
                text = "See other ${input.otherCommentsCount} comments",
                fontSize = 14.sp,
                color = Color(0x66000000)
            )
        if(input.highlightedComment != null)
            CommentLine(input.highlightedComment)
    }
}

@Composable
private fun CommentLine(input: PostCellConfig.Comments.CommentLine) {
    val text = buildAnnotatedString {
        withStyle(SpanStyle(fontWeight = FontWeight.Bold)) {
            append("${input.author} ")
        }
        withStyle(SpanStyle(fontWeight = FontWeight.Normal)) {
            append(input.comment)
        }
    }
    Text(
        text = text,
        fontSize = 12.sp
    )
}

@Composable
fun PostCell(
    name: String,
    image: String,
    isVerified: Boolean,
    place: String,
    postImage: String,
    likeInfo: PostCellConfig.LikeInfo,
    commentInfo: PostCellConfig.Comments.CommentInfo
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        PostHeader(name, image, isVerified, place)
        MainPhoto(
            modifier = Modifier.padding(top = Spacing.s),
            postImage
        )
        ReactionsRow(2,3)
        LikesRow(
            images = likeInfo.images,
            topLikerName = likeInfo.topLikerName,
            likesCount = likeInfo.likesCount
        )
        CommentsSection(commentInfo)
    }
}