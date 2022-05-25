package com.dev.leonardom.introuduccionajetpackcompose.presentation

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Pantalla2(text: String) {

    LazyColumn(contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ){
        item{

                Text(
                    text = "Comisarías",
                    style = TextStyle(
                        fontSize = 28.sp,
                        fontWeight = FontWeight.Black
                    )
                )


        }
        items(listaComisaria){

            ComisariaDiseño(comisaria = it,text)
        }
    }
}

data class Comisaria(val nombre: String, val departamento:String)



private val listaComisaria= listOf(
    Comisaria(nombre="Ceviche de Pescado",departamento="Lima"),
    Comisaria(nombre="Lomo Saltado",departamento="Lima"),
    Comisaria(nombre="Papa Rellena",departamento="Arequipa"),
    Comisaria(nombre="Escabeche de Pescado",departamento="Arequipa"),
    Comisaria(nombre="Picarones",departamento="Arequipa"),
    Comisaria(nombre="Arroz con Mariscos",departamento="Junín"),
    Comisaria(nombre="Carapulcra",departamento="Arequipa"),

)
data class Publicidad(val titulo:String)
private val listaPublicidad= listOf(
    Publicidad(titulo="Publicidad 1"),
    Publicidad(titulo="Publicidad 2"),
    Publicidad(titulo="Publicidad 3"),
    Publicidad(titulo="Publicidad 4")
)
@Composable
fun ComisariaDiseño(comisaria:Comisaria,text: String) {
    Row(
        modifier=Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    )
    {
        if(text==comisaria.departamento) {
            Button(onClick = {mostrarDatos() }){
                Text(comisaria.nombre,
                style = TextStyle(
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Light,
                    fontStyle = FontStyle.Italic
                ))
            }
        }
    }

}
fun mostrarDatos(){

}