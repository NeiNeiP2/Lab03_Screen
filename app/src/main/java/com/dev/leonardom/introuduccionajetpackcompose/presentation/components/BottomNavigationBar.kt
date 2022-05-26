package com.dev.leonardom.introuduccionajetpackcompose.presentation.components

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import com.dev.leonardom.introuduccionajetpackcompose.navigation.Destinations

@Composable
fun BottomNavigationBar(
    navController: NavController,
    item:List<Destinations>
){
    val currentRoute= currentRoute(navController)
    BottomNavigation {
       item.forEach{ screen->
            BottomNavigationItem(
                icon = { Icon(imageVector = screen.icon, contentDescription= screen.title) },
                label={ Text(screen.title)},
                selected =currentRoute==screen.route,
                onClick = {
                    if(screen.route=="pantalla2/{newText}/{newText2}"){
                        navController.navigate("pantalla2/Arequipa/Comisaria"){
                            popUpTo(navController.graph.findStartDestination().id){
                                saveState=true
                            }
                            launchSingleTop=true
                        }
                    }else{
                        navController.navigate(screen.route){
                            popUpTo(navController.graph.findStartDestination().id){
                                saveState=true
                            }
                            launchSingleTop=true
                        }
                    }

                },
                alwaysShowLabel=false
            )
                

       }
    }
}
@Composable
private fun currentRoute(navController: NavController):String?{
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    return navBackStackEntry?.destination?.route
}