package com.dev.leonardom.introuduccionajetpackcompose.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.dev.leonardom.introuduccionajetpackcompose.Clases.Provincia
import com.dev.leonardom.introuduccionajetpackcompose.navigation.Destinations

@Composable
fun Pantalla4(navController: NavController) {
    LazyColumn(contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ){
        item {
            Text(
                buildAnnotatedString {
                    withStyle(style = SpanStyle(fontSize = 37.sp, fontWeight = FontWeight.Bold)) {
                        withStyle(style = SpanStyle(color = Color.Blue)) {
                            append("Llamada ")
                        }
                        append("de ")
                        withStyle(style = SpanStyle(color = Color.Red)) {
                            append("Emergencia")
                        }

                    }

                }, Modifier.padding(all = 20.dp), textAlign = TextAlign.Center)
            Column(
                modifier = Modifier.fillMaxWidth()
                    .border(2.dp, Color.Gray, RoundedCornerShape(8.dp))
                    .padding(8.dp).background(Color.LightGray, RoundedCornerShape(8.dp))
            ) {
                Text(
                    text = "Comisaría",
                    style = TextStyle(
                        fontSize = 28.sp,
                        fontWeight = FontWeight.Black
                    )
                )
                SelectionContainer {
                    Text(
                        text = "(054)231515",
                        style = TextStyle(
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Black
                        )
                    )
                }
                Text(
                    text = "Centro de Salud", Modifier.padding(top = 20.dp),
                    style = TextStyle(
                        fontSize = 28.sp,
                        fontWeight = FontWeight.Black
                    )
                )
                SelectionContainer {
                    Text(
                        text = "(054) 231313",
                        style = TextStyle(
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Black
                        )
                    )
                }
                Text(
                    text = "Bomberos", Modifier.padding(top = 20.dp),
                    style = TextStyle(
                        fontSize = 28.sp,
                        fontWeight = FontWeight.Black
                    )
                )
                SelectionContainer {
                    Text(
                        text = "(054) 241833",
                        style = TextStyle(
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Black
                        )
                    )
                }


            }
        }
    }
}





