package br.com.jarvis.home.presentation.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.jarvis.home.impl.R

@Composable
@Preview
fun HomeScreen() {
    HomeList()
}

@Composable
private fun HomeList(names: List<String> = List(12) { "$it" }) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = Modifier.padding(vertical = 0.dp, horizontal = 0.dp),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(items = names) { name ->
            BookCard()
        }
    }
}

@Composable
private fun BookCard() {
    Column {
        Box(
            contentAlignment = Alignment.TopEnd,
        ) {
            Card(
                shape = RoundedCornerShape(20.dp),
                elevation = CardDefaults.cardElevation(defaultElevation = 0.dp),
                modifier = Modifier
                    .padding(vertical = 10.dp, horizontal = 0.dp)
                    .aspectRatio(0.75f)
                    .width(IntrinsicSize.Max)
                    .graphicsLayer {
                        shape = RoundedCornerShape(20.dp)
                        shadowElevation = 20f
                        spotShadowColor = Color.Black
                    },

                ) {

                Image(
                    modifier = Modifier.fillMaxWidth().fillMaxHeight()
                        .height(IntrinsicSize.Max)
                        .width(IntrinsicSize.Max),
                    contentScale = ContentScale.Crop,
                    painter = painterResource(R.drawable.dragon_ball_z),
                    contentDescription = "",
                )
            }
            Image(
                modifier = Modifier.padding(vertical = 0.dp, horizontal = 18.dp),
                painter = painterResource(R.drawable.ic_favorited),
                contentDescription = "",
                alignment = Alignment.CenterEnd,
            )
        }

        Text(
            text = "DragonBall Z",
            color = Color(0xFF0D1821),
            style = MaterialTheme.typography.h4.copy(
                fontWeight = FontWeight.ExtraBold,
                fontSize = 18.sp,
            )
        )

        Text(
            text = "42 Volumes",
            color = Color(0xFFBBC7CE),
            style = MaterialTheme.typography.h4.copy(
                fontWeight = FontWeight.ExtraBold,
                fontSize = 12.sp,
            )
        )
    }
}
