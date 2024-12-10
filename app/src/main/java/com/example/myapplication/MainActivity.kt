package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                MainScreen()
            }
        }
    }
}

@Composable
fun MainScreen() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "screen1") {
        composable("screen1") { Screen1(navController) }
        composable("screen2") { Screen2(navController) }
        composable("screen3") { Screen3(navController) }
    }
}

@Composable
fun Screen1(navController: NavController) {
    ScreenContent(
        color = Color.Red,
        buttonText = "Go to Screen 2",
        onButtonClick = { navController.navigate("screen2") },
        navController = navController
    )
}

@Composable
fun Screen2(navController: NavController) {
    ScreenContent(
        color = Color.Green,
        buttonText = "Go to Screen 1",
        onButtonClick = { navController.navigate("screen1") },
        navController = navController
    )
}

@Composable
fun Screen3(navController: NavController) {
    ScreenContent(
        color = Color.Blue,
        buttonText = "Go to Screen 1",
        onButtonClick = { navController.navigate("screen1") },
        navController = navController
    )
}

@Composable
fun ScreenContent(
    color: Color,
    buttonText: String,
    onButtonClick: () -> Unit,
    navController: NavController
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color)
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Button(onClick = onButtonClick) {
                Text(text = buttonText)
            }

            Spacer(modifier = Modifier.height(16.dp))

            Button(onClick = { navController.navigate("screen3") }) {
                Text(text = "Go to Screen 3")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyApplicationTheme {
        MainScreen()
    }
}
