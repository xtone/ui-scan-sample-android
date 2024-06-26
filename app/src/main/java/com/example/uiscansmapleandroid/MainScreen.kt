package com.example.uiscansmapleandroid

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun MainScreen(modifier: Modifier = Modifier) {
    Column (
        modifier.verticalScroll(state = rememberScrollState())
    ){
        Search()
        CarouselArea()
        CategoryArea()
        FeaturedArea()
        NewsArea()
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Search() {
    var text by remember { mutableStateOf("") }
    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth()
//            .background(color = Color(0xFFE0E0E0), shape = RoundedCornerShape(size = 10.dp))
            .padding(horizontal = 16.dp, vertical = 24.dp),
        value = text,
        onValueChange = { text = it },
        label = { Text("Search") },
    )
}
@Composable
fun CarouselArea() {
    LazyRow(
        modifier = Modifier.height(158.dp),
        contentPadding = PaddingValues(horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        item {
            ItemImage(R.drawable.cal1)
        }
        item {
            ItemImage(R.drawable.cal2)
        }
        item {
            ItemImage(R.drawable.cal3)
        }
    }
}
@Composable
fun CategoryArea() {
    CategoryTitle(categoryName = "Categories", isDisplaySeeAll = false)
    CategoryList()
    Spacer(Modifier.size(32.dp))
}
@Composable
fun FeaturedArea() {
    Column (
        modifier = Modifier
            .background(color = Color(0xFFF5F5F5)),
    ){
        CategoryTitle(categoryName = "Featured Product")
        ItemList()
        CategoryTitle(categoryName = "Best Sellers")
        ItemList()
        CategoryTitle(categoryName = "New Arrivals")
        ItemList()
        Spacer(Modifier.size(32.dp))
    }
}
@Composable
fun NewsArea() {
    CategoryTitle(categoryName = "Latest News", isDisplaySeeAll = false)
    ArticleItem(R.drawable.news_1)
    Divider(modifier = Modifier
        .padding(horizontal = 16.dp)
        .height(1.5.dp))
    ArticleItem(R.drawable.news_2)
    Divider(modifier = Modifier
        .padding(horizontal = 16.dp)
        .height(1.5.dp))
    ArticleItem(R.drawable.news_3)
    OutlinedButton(
        onClick = { /*TODO*/ },
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp)
            .padding(horizontal = 16.dp)
    ) {
        Text(text = "See All")
    }
    Spacer(Modifier.size(32.dp))
}

@Composable
fun ArticleItem(newImageId: Int) {
    Row (
        modifier = Modifier
            .height(128.dp)
            .padding(horizontal = 16.dp, vertical = 24.dp)
    ){
        Column (
            modifier = Modifier
                .width(260.dp)
        ){
            Text(text = "Exclusive Offer Inside!", fontSize = 14.sp, fontWeight = FontWeight(510), color = Color(0xFF212121))
            Spacer(Modifier.size(4.dp))
            Text(
                text = "Dive into savings! Limited-time discounts on your favorite gadgets, fashion, and ...",
                fontSize = 12.sp,
                lineHeight = 22.sp,
                color = Color(0xFF06070C))
            Spacer(Modifier.size(4.dp))
            Text(text = "13 Jan 2023", fontSize = 12.sp, color = Color(0xFF9E9E9E))
        }
        Spacer(Modifier.size(16.dp))
        Image(
            painter = painterResource(id = newImageId),
            contentDescription = null,
            modifier = Modifier
                .width(80.dp)
                .height(80.dp)
        )
    }
}

@Composable
fun CategoryTitle(categoryName: String,
                  isDisplaySeeAll: Boolean = true,
                  modifier: Modifier = Modifier) {
    Row (modifier = Modifier.padding(top = 32.dp, bottom = 24.dp, start = 16.dp, end = 16.dp),
        verticalAlignment = Alignment.CenterVertically){
        Text(
            text = categoryName,
            modifier = Modifier.weight(1f),
            style = TextStyle(
                fontSize = 20.sp,
                lineHeight = 32.sp,
                fontWeight = FontWeight(590),
                color = Color(0xFF0C1A30),
            )
        )
        if (isDisplaySeeAll) {
            Text(
                text = "See All",
                modifier = modifier,
                style = TextStyle(
                    fontSize = 14.sp,
                    fontWeight = FontWeight(400),
                    color =Color(0xFF3F51B5),
                    textAlign = TextAlign.Right,
                )

            )
        }
    }
}


@Composable
fun ItemImage(@DrawableRes id: Int) {
    Image(
        painter = painterResource(id = id),
        contentDescription = null,
        contentScale = ContentScale.FillBounds,
        modifier = Modifier
            .shadow(
                elevation = 8.dp,
                spotColor = Color(0x26000000),
                ambientColor = Color(0x26000000)
            )
            .width(311.dp)
            .height(150.dp)
            .clip(RoundedCornerShape(10.dp))
    )
}

@Composable
fun CategoryList() {
    LazyRow(
        modifier = Modifier,
        contentPadding = PaddingValues(horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(28.dp),
    ) {
        item {
            CategoryItem(id = R.drawable.category_food, itemName = "Foods")
        }
        item {
            CategoryItem(id = R.drawable.category_gift, itemName = "Gift")
        }
        item {
            CategoryItem(id = R.drawable.category_interior, itemName = "Interior")
        }
        item {
            CategoryItem(id = R.drawable.category_fashion, itemName = "Fashio")
        }
        item {
            CategoryItem(id = R.drawable.category_book, itemName = "Book")
        }
    }
}

@Composable
fun CategoryItem(modifier: Modifier = Modifier,
                 @DrawableRes id: Int, itemName: String) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = id),
            contentDescription = null,
            contentScale = ContentScale.FillBounds,
            modifier = modifier
        )
        Text(
            text = itemName,
            // Body 2/Regular
            style = TextStyle(
                fontSize = 14.sp,
                lineHeight = 22.sp,
                fontWeight = FontWeight(400),
                color = Color(0xFF212121),
                textAlign = TextAlign.Center,
            )
        )
    }
}
