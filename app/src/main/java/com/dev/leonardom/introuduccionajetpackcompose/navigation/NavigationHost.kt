package com.dev.leonardom.introuduccionajetpackcompose.presentation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import com.dev.leonardom.introuduccionajetpackcompose.navigation.Destinations.*

@Composable
fun NavigationHost(navController:NavHostController) {


    NavHost(navController = navController, startDestination = Pantalla1.route) {

        composable(Pantalla1.route) {
            Pantalla1(navController=navController)
        }
        composable(
            Pantalla3.route,
            arguments = listOf(navArgument("newText"){ type= NavType.StringType })
        ){
            Pantalla3(navController=navController, it.arguments?.getString("newText").toString())
        }
        composable(
            Pantalla2.route,
            arguments = listOf(navArgument("newText"){ type= NavType.StringType },
            navArgument("newText2"){ type= NavType.StringType })
        ) {
            Pantalla2(
                navController=navController, it.arguments?.getString("newText").toString(),
                 it.arguments?.getString("newText2").toString()
               )


        }
    }
}