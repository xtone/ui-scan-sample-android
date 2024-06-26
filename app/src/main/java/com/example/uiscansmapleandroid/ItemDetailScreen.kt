package com.example.uiscansmapleandroid

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Divider
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ItemDetailScreen(modifier: Modifier = Modifier) {
    Column (
        modifier.verticalScroll(state = rememberScrollState())
    ) {
        ItemDetail()
        ProductInformation()
        Divider(modifier = Modifier
            .padding(horizontal = 16.dp)
            .height(0.5.dp))
        Reviews()
        Recommendation()
    }
}

@Composable
fun ItemDetail() {
    Column (
        modifier = Modifier
            .background(color = Color(0xFFF5F5F5))
    ){
        Image(
            painter = painterResource(id = R.drawable.detail_watch),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
        )
        Column (
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 32.dp),
        ) {
            Text(
                text = "TechTrack Elite",
                style = TextStyle(
                    fontSize = 24.sp,
                    lineHeight = 32.sp,
                    fontWeight = FontWeight(590),
                    color = Color(0xFF0C1A30),
                )
            )
            Spacer(modifier = Modifier.size(24.dp))
            Text(
                text = "\$15.99",
                style = TextStyle(
                    fontSize = 20.sp,
                    lineHeight = 32.sp,
                    fontWeight = FontWeight(400),
                    color = Color(0xFF0C1A30),
                )
            )
            Spacer(modifier = Modifier.size(24.dp))
            Row {
                TextButton(
                    contentPadding = PaddingValues(0.dp),
                    shape = RoundedCornerShape(size = 8.dp),
                    onClick = { /*TODO*/ },
                    modifier = Modifier
                        .width(100.dp)
                        .height(42.dp)
                        .background(color = Color.Black, shape = RoundedCornerShape(size = 8.dp))
                ) {
                    Box(
                        modifier = Modifier
                            .size(16.dp)
                            .clip(CircleShape)
                            .background(Color.White)
                    )
                    Spacer(Modifier.size(4.dp))
                    Text(text = "White", fontSize = 16.sp, fontWeight = FontWeight(590),color = Color.White,)
                }
                Spacer(Modifier.size(12.dp))
                TextButton(
                    contentPadding = PaddingValues(0.dp),
                    shape = RoundedCornerShape(size = 8.dp),
                    onClick = { /* ... */ },
                    modifier = Modifier
                        .width(100.dp)
                        .height(42.dp)
                        .border(width = 1.dp, color = Color(0xFFE0E0E0), shape = RoundedCornerShape(size = 8.dp))
                        .background(color = Color.White, shape = RoundedCornerShape(size = 8.dp)),
                ){
                    Box(
                        modifier = Modifier
                            .size(16.dp)
                            .clip(CircleShape)
                            .background(Color.Black)
                    )
                    Spacer(Modifier.size(4.dp))
                    Text(text = "Black", fontSize = 16.sp, fontWeight = FontWeight(590), color = Color.Black,)
                }
                Spacer(modifier = Modifier.size(12.dp))
            }
            Spacer(modifier = Modifier.size(24.dp))
            OutlinedButton(
                border = null,
                shape = RoundedCornerShape(size = 10.dp),
                onClick = { /*TODO*/ },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp)
                    .background(color = Color(0xFFF0D319), shape = RoundedCornerShape(size = 10.dp))
            ) {
                Image(
                    colorFilter = ColorFilter.tint(Color.Black),
                    painter = painterResource(id = R.drawable.select_bag),
                    contentDescription = null,
                    contentScale = ContentScale.FillBounds,
                )
                Text(text = "Add to cart", color = Color.Black, fontSize = 16.sp, fontWeight = FontWeight(700))
            }
        }
    }
}


@Composable
fun ProductInformation() {
    Column (
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 32.dp),
    ){
        Text(
            text = "Product information",
            style = TextStyle(
                fontSize = 20.sp,
                lineHeight = 32.sp,
                fontWeight = FontWeight(590),
                color = Color(0xFF0C1A30),
            )
        )
        Spacer(modifier = Modifier.size(24.dp))
        Text(
            text = "Introducing our latest innovation, the TechTrack Elite - where technology meets elegance. This smartwatch seamlessly integrates cutting-edge features with sleek design. Monitor your heart rate, sleep patterns, and physical activity in real time, empowering you with personalized fitness insights.",
            style = TextStyle(
                fontSize = 14.sp,
                lineHeight = 28.sp,
                fontWeight = FontWeight(400),
                color = Color(0xFF0C1A30),
            )
        )
    }
}

@Composable
fun Reviews() {
    Column (
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 32.dp),
    ) {
        ReviewTitle()
        ReviewItem()
        ReviewItem()
        ReviewItem()
        Spacer(modifier = Modifier.size(24.dp))
        OutlinedButton(
            shape = RoundedCornerShape(size = 10.dp),
            onClick = { /*TODO*/ },
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp)
        ) {
            Text(text = "See All Review", color = Color.Black, fontSize = 16.sp, fontWeight = FontWeight(400))
        }
    }
}
@Composable
fun ReviewItem() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
    ) {
        Reviewer()
        ReviewComment()
    }
}
@Composable
fun Recommendation() {
    Column (
        modifier = Modifier
            .background(color = Color(0xFFF5F5F5)),
    ){
        CategoryTitle(categoryName = "you might also like", isDisplaySeeAll = true)
        ItemList()
        Spacer(modifier = Modifier.size(32.dp))
    }
}

@Composable
fun ReviewTitle() {
    Row (
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 16.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ){
        Text(
            text = "Review (86)",
            style = TextStyle(
                fontSize = 20.sp,
                lineHeight = 32.sp,
                fontWeight = FontWeight(590),
                color = Color(0xFF0C1A30),
            )
        )
        Row {
            Image(
                painter = painterResource(id = R.drawable.rank_star),
                contentDescription = null,
                modifier = Modifier
                    .width(24.dp)
                    .height(24.dp)
            )
            Text(
                text = "4.6",
                style = TextStyle(
                    fontSize = 20.sp,
                    lineHeight = 32.sp,
                    fontWeight = FontWeight(590),
                    color = Color(0xFF0C1A30),
                )
            )
        }
    }
}

@Composable
fun ReviewStars() {
    Row {
        ReviewStar()
        ReviewStar()
        ReviewStar()
        ReviewStar()
        ReviewStar()
    }
}
@Composable
fun ReviewStar() {
    Image(
        painter = painterResource(id = R.drawable.rank_star),
        contentDescription = null,
        modifier = Modifier
            .width(16.dp)
            .height(16.dp)
    )
}

@Composable
fun Reviewer() {
    Row (
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ){
        Row {
            //Reviewer Image
            Image(
                painter = painterResource(id = R.drawable.reviewer),
                contentDescription = null,
                modifier = Modifier
                    .width(44.dp)
                    .height(44.dp)
                    .background(color = Color(0xFFD9D9D9), shape = RoundedCornerShape(size = 44.dp))
            )
            Column(
                modifier = Modifier.padding(start = 16.dp)
            ) {
                //Reviewer Name
                Text(
                    text = "Jhon Doe",
                    style = TextStyle(
                        fontSize = 16.sp,
                        lineHeight = 21.sp,
                        fontWeight = FontWeight(590),
                        color = Color(0xFF0C1A30),
                    )
                )
                //Review Rank
                ReviewStars()
            }
        }
        //timestamp
        Text(
            text = "Today, 12:30 pm",
            style = TextStyle(
                fontSize = 11.sp,
                lineHeight = 24.sp,
                fontWeight = FontWeight(590),
                color = Color(0xFF9E9E9E),
            )
        )
    }
}

@Composable
fun ReviewComment() {
    Text(
        modifier = Modifier.padding(start = 56.dp),
        text = "TechTrack Elite exceeded my expectations! Sleek design, accurate health tracking, and intuitive interface. A must-have for tech enthusiasts!",
        style = TextStyle(
            fontSize = 14.sp,
            lineHeight = 22.sp,
            fontWeight = FontWeight(400),
            color = Color(0xFF212121),
        )
    )

}
