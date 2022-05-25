package com.dev.leonardom.introuduccionajetpackcompose.presentation

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.dev.leonardom.introuduccionajetpackcompose.Clases.Provincia
import com.dev.leonardom.introuduccionajetpackcompose.navigation.Destinations

@Composable
fun Pantalla4(navController: NavController,text:String,text2: String) {
    LazyColumn(contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ){
        item{

            Text(
                text = "Lugares de Emergencias",
                style = TextStyle(
                    fontSize = 28.sp,
                    fontWeight = FontWeight.Black
                )
            )

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                verticalArrangement = Arrangement.SpaceAround,
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                val provi=Provincia.getProvincia(text)
                if(provi.bomberos){
                    val comisaria="Comisaria"
                    Button(
                        modifier = Modifier.fillMaxWidth().padding(10.dp),
                        onClick = { navController.navigate(route=Destinations.Pantalla1.route)}) {
                        Text(
                            "Comisaría",
                            style = TextStyle(
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Light,
                                fontStyle = FontStyle.Italic

                            )
                        )

                    }


                }
            }

        }

    }
}





