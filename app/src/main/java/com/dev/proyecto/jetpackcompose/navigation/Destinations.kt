package com.dev.leonardom.introuduccionajetpackcompose.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector

sealed class Destinations(
    val route: String,
    val title:String,
    val icon:ImageVector
) {
    object Pantalla1: Destinations("pantalla1","Inicio", Icons.Filled.Home)
    object Pantalla3: Destinations("pantalla3/{newText}","SubSección de Apoyo",Icons.Filled.Settings)


    object Pantalla2: Destinations("pantalla2/{newText}/{newText2}","Apoyo",Icons.Filled.Favorite)




}
