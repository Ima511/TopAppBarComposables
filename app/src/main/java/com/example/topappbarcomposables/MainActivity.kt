package com.example.topappbarcomposables

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SmallTopAppBar
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.topappbarcomposables.ui.theme.TopAppBarComposablesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TopAppBarComposablesTheme {
                // A surface container using the 'background' color from the theme
                Surface(
//                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MyUi()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyUi() {

    // Top App bar: Provides the info about the
    // content and actions related to the current
    // screen. (navigation, actions, screen titles...)
    val context = LocalContext.current.applicationContext
    Surface(shadowElevation = 50.dp,
        modifier = Modifier
            .padding(5.dp)
            .background(Color.Red)
    ) {
        CenterAlignedTopAppBar(

            title = { Text(text = "Our Corse") },
            navigationIcon = {
                IconButton(onClick = {
                    Toast.makeText(
                        context,
                        "You clicked the icon",
                        Toast.LENGTH_SHORT
                    ).show()
                }) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = "Navigation Icon"
                    )
                }
            },
            actions = {
                // Search Icon
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        imageVector = Icons.Filled.Search,
                        contentDescription = "Search"
                    )
                }

                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        imageVector = Icons.Filled.Menu,
                        contentDescription = "Menu"
                    )
                }
            },
            colors = TopAppBarDefaults.smallTopAppBarColors(Color.Red),

            )
    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TopAppBarComposablesTheme {
        MyUi()
    }
}