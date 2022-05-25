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
fun Pantalla3(navController: NavController,text:String) {
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
                if(provi.comisaria){
                    val comisaria="Comisaria"
                    Button(
                        modifier = Modifier.fillMaxWidth().padding(10.dp),
                        onClick = {navController.navigate(route="pantalla2/"+provi.nombre+"/"+comisaria )}) {
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
                if(provi.refugio){
                    val hospital="CentroDeSalud"
                    Button(
                        modifier = Modifier.fillMaxWidth().padding(10.dp),
                        onClick = {navController.navigate(route="pantalla2/"+provi.nombre+"/"+hospital )}) {
                        Text(
                            "Centro de Salud",
                            style = TextStyle(
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Light,
                                fontStyle = FontStyle.Italic

                            )
                        )

                    }


                }
                if(provi.bomberos){
                    val bombero= "Bomberos"
                    Button(
                        modifier = Modifier.fillMaxWidth().padding(10.dp),
                        onClick = {navController.navigate(route="pantalla2/"+provi.nombre+"/"+bombero )}) {
                        Text(
                            "Bomberos",
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





