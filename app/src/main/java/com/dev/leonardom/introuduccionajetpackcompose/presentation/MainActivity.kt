package com.dev.leonardom.introuduccionajetpackcompose.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.dev.leonardom.introuduccionajetpackcompose.navigation.Destinations
import com.dev.leonardom.introuduccionajetpackcompose.presentation.components.BottomNavigationBar
import com.dev.leonardom.introuduccionajetpackcompose.ui.theme.IntrouduccionAJetpackComposeTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainScreen()



        }
    }
}
@Composable
fun MainScreen(){
    val navController= rememberNavController()
    val navigationItems= listOf(
        Destinations.Pantalla1,
        Destinations.Pantalla3,
        Destinations.Pantalla2,
        Destinations.Pantalla4



    )
    Scaffold(
        bottomBar = { BottomNavigationBar(navController = navController, item = navigationItems)}
    ){
        NavigationHost(navController=navController)
    }
}










