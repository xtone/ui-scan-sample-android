package com.example.uiscansmapleandroid

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ItemCard(itemImageId: Int) {

    Box {
        Column (
            modifier = Modifier
                .width(156.dp)
                .height(250.dp)
                .background(color = Color(0xFFFFFFFF))
                .clip(RoundedCornerShape(10.dp))
        ) {
            Image(
                painter = painterResource(id = itemImageId),
                contentDescription = null,
                modifier = Modifier
                    .width(156.dp)
                    .height(156.dp)
            )
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .padding(horizontal = 12.dp, vertical = 16.dp),
                verticalArrangement = Arrangement.SpaceBetween
                ) {
                Text(text = "TechTrack Elite", fontSize = 14.sp, fontWeight = FontWeight(590),)
                Text(text = "\$16.75", fontSize = 12.sp,)
                Row (
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ){
                    Row (
                        horizontalArrangement = Arrangement.Start
                    ){
                        Image(
                            painter = painterResource(id = R.drawable.rank_star),
                            contentDescription = null,
                            modifier = Modifier
                                .padding(0.66667.dp)
                                .width(16.dp)
                                .height(16.dp)
                        )
                        Text(modifier = Modifier.padding(start = 4.dp), text = "4.6", fontSize = 12.sp, color = Color(0xFF9E9E9E))
                    }
                    Text(text = "86 Reviews", fontSize = 12.sp, color = Color(0xFF9E9E9E))
                }
            }
        }
        Text(
            text = "NEW",
            modifier = Modifier
                .offset(x = 8.dp, y = 8.dp)
                .shadow(
                    elevation = 4.dp,
                    spotColor = Color(0x1A000000),
                    ambientColor = Color(0x1A000000)
                )
                .width(39.dp)
                .height(20.dp)
                .background(color = Color(0xFFFFD60A), shape = RoundedCornerShape(size = 4.dp))
                .padding(start = 8.dp, top = 3.dp),
            fontSize = 11.sp
        )
    }
}

@Composable
fun ItemList() {
    LazyRow(
        contentPadding = PaddingValues(horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        item { ItemCard(R.drawable.item_watch) }
        item { ItemCard(R.drawable.item_shoes) }
        item { ItemCard(R.drawable.item_bag) }
    }
}