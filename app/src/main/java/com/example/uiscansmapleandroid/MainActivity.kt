package com.example.uiscansmapleandroid

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.uiscansmapleandroid.ui.theme.UIScanSmapleAndroidTheme
import jp.co.xtone.android.autoscreenshot.AutoCapture
import jp.co.xtone.android.autoscreenshot.AutoCaptureInitializer

@OptIn(ExperimentalMaterial3Api::class)
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        AutoCaptureInitializer.initialize(
            apiKey = "api key",
            projectId = "project id",
            shouldSaveImageLocally = true
        )

        setContent {
            UIScanSmapleAndroidTheme {
                val navController = rememberNavController()
                var selectedItemIndex by rememberSaveable {
                    mutableStateOf(0)
                }
                Scaffold(
                    topBar = {
                        TopAppBar(
                            title = {
                                if (selectedItemIndex==0) {
                                    MainTopBar()
                                } else {
                                    ItemDetailTopBar()
                                }
                            }
                        )
                    },
                    bottomBar = {
                        BottomAppBar {
                            Row(modifier = Modifier.fillMaxWidth()) {
                                NavigationBarItem(
                                    label = { Text(text = "HOME", fontSize = 10.sp, fontWeight = FontWeight(510)) },
                                    icon = {
                                        Icon(painter = painterResource(id = R.drawable.home), contentDescription = "ORDER")
                                    },
                                    selected = true,
                                    alwaysShowLabel = false,
                                    onClick = {
                                        selectedItemIndex = 0
                                        navController.navigate("HOME")
                                    },
                                    colors = NavigationBarItemDefaults.colors()
                                )
                                NavigationBarItem(
                                    // Text that shows bellow the icon
                                    label = { Text(text = "WISHLIST", fontSize = 10.sp, fontWeight = FontWeight(510)) },
                                    icon = {
                                        Icon(painter = painterResource(id = R.drawable.heart), contentDescription = "WISHLIST")
                                    },
                                    selected = false,
                                    alwaysShowLabel = true,
                                    onClick = { selectedItemIndex = 1
                                        navController.navigate("ITEM DETAIL")
                                    },
                                    colors = NavigationBarItemDefaults.colors()
                                )
                                NavigationBarItem(
                                    label = { Text(text = "ORDER", fontSize = 10.sp, fontWeight = FontWeight(510)) },
                                    icon = {
                                        Icon(painter = painterResource(id = R.drawable.select_bag), contentDescription = "ORDER")
                                    },
                                    selected = false,
                                    alwaysShowLabel = true,
                                    onClick = { /*TODO*/ },
                                    colors = NavigationBarItemDefaults.colors()
                                )
                                NavigationBarItem(
                                    label = { Text(text = "LOGIN", fontSize = 10.sp, fontWeight = FontWeight(510)) },
                                    icon = {
                                        Icon(painter = painterResource(id = R.drawable.person), contentDescription = "LOGIN")
                                    },
                                    selected = false,
                                    alwaysShowLabel = true,
                                    onClick = { /*TODO*/ },
                                    colors = NavigationBarItemDefaults.colors()
                                )
                            }
                        }
                    }
                )
                { padding ->
                    NavHost(
                        navController = navController,
                        startDestination = "HOME"
                    ) {
                        composable("HOME") {
                            MainScreen(modifier = Modifier.padding(
                                top = padding.calculateTopPadding(),
                                bottom = padding.calculateBottomPadding()))
                        }
                        composable("ITEM DETAIL") {
                            ItemDetailScreen(
                                modifier = Modifier.padding(
                                    top = padding.calculateTopPadding(),
                                    bottom = padding.calculateBottomPadding()
                                )
                            )
                        }
                    }
                }
            }

        }
        //create and initialize an instance
        val auto = AutoCapture.build(this)

        //execute screenshot
        auto.captureStart()
    }
}

@Composable
fun MainTopBar() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
    ) {
        Text(
            text = "Shop Ease ",
            fontSize = 17.sp,
            textAlign = TextAlign.Right,
            color = Color(0xFF000000),
            fontWeight = FontWeight(590)
        )
    }
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.End,
    ) {
        Row {
            Image(
                painter = painterResource(id = R.drawable.bell),
                contentDescription = null,
                contentScale = ContentScale.FillBounds,
            )
            Spacer(Modifier.size(16.dp))
        }
    }
}

@Composable
fun ItemDetailTopBar() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
        ) {
        Text(
            text = "Detail Product",
            fontSize = 17.sp,
            textAlign = TextAlign.Right,
            color = Color(0xFF000000),
            fontWeight = FontWeight(590)
        )
    }
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        Image(
            painter = painterResource(id = R.drawable.chevron_left),
            contentDescription = null,
            contentScale = ContentScale.FillBounds
        )
        Row(
            modifier = Modifier.padding(end = 24.dp)
        ){
            Image(
                painter = painterResource(id = R.drawable.heart),
                contentDescription = null,
                contentScale = ContentScale.FillBounds,
            )
            Spacer(Modifier.size(8.dp))
            Image(
                painter = painterResource(id = R.drawable.bell),
                contentDescription = null,
                contentScale = ContentScale.FillBounds,
            )
            Spacer(Modifier.size(16.dp))
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true, heightDp = 2000)
@Composable
fun GreetingPreview() {
    UIScanSmapleAndroidTheme {
        val navController = rememberNavController()
        var selectedItemIndex by rememberSaveable {
            mutableStateOf(0)
        }
        Scaffold(
            topBar = {
                TopAppBar(
                    title = {
                        if (selectedItemIndex==0) {
                            MainTopBar()
                        } else {
                            ItemDetailTopBar()
                        }
                    }
                )
            },
            bottomBar = {
                BottomAppBar {
                    Row(modifier = Modifier.fillMaxWidth()) {
                        NavigationBarItem(
                            label = { Text(text = "HOME", fontSize = 10.sp, fontWeight = FontWeight(510)) },
                            icon = {
                                Icon(painter = painterResource(id = R.drawable.home), contentDescription = "ORDER")
                            },
                            selected = true,
                            alwaysShowLabel = false,
                            onClick = {
                                selectedItemIndex = 0
                                navController.navigate("HOME")
                            },
                            colors = NavigationBarItemDefaults.colors()
                        )
                        NavigationBarItem(
                            // Text that shows bellow the icon
                            label = { Text(text = "WISHLIST", fontSize = 10.sp, fontWeight = FontWeight(510)) },
                            icon = {
                                Icon(painter = painterResource(id = R.drawable.heart), contentDescription = "WISHLIST")
                            },
                            selected = false,
                            alwaysShowLabel = true,
                            onClick = { selectedItemIndex = 1
                                navController.navigate("ITEM DETAIL")
                            },
                            colors = NavigationBarItemDefaults.colors()
                        )
                        NavigationBarItem(
                            label = { Text(text = "ORDER", fontSize = 10.sp, fontWeight = FontWeight(510)) },
                            icon = {
                                Icon(painter = painterResource(id = R.drawable.select_bag), contentDescription = "ORDER")
                            },
                            selected = false,
                            alwaysShowLabel = true,
                            onClick = { /*TODO*/ },
                            colors = NavigationBarItemDefaults.colors()
                        )
                        NavigationBarItem(
                            label = { Text(text = "LOGIN", fontSize = 10.sp, fontWeight = FontWeight(510)) },
                            icon = {
                                Icon(painter = painterResource(id = R.drawable.person), contentDescription = "LOGIN")
                            },
                            selected = false,
                            alwaysShowLabel = true,
                            onClick = { /*TODO*/ },
                            colors = NavigationBarItemDefaults.colors()
                        )
                    }
                }
            }
        )
        { padding ->
            NavHost(
                navController = navController,
                startDestination = "HOME"
            ) {
                composable("HOME") {
                    MainScreen(modifier = Modifier.padding(
                        top = padding.calculateTopPadding(),
                        bottom = padding.calculateBottomPadding()))
                }
                composable("ITEM DETAIL") {
                    ItemDetailScreen(
                        modifier = Modifier.padding(
                            top = padding.calculateTopPadding(),
                            bottom = padding.calculateBottomPadding()
                        )
                    )
                }
            }
        }
    }
}
