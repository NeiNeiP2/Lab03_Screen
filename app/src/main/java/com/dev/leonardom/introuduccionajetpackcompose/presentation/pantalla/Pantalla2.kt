package com.dev.leonardom.introuduccionajetpackcompose.presentation

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.toSize
import androidx.navigation.NavController
import com.dev.leonardom.introuduccionajetpackcompose.Clases.Provincia
import com.dev.leonardom.introuduccionajetpackcompose.navigation.Destinations

@Composable
fun Pantalla2(navController: NavController, text: String, text2: String) {

    LazyColumn(contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ){
        item{

                Text(
                    text = text2,
                    style = TextStyle(
                        fontSize = 28.sp,
                        fontWeight = FontWeight.Black
                    )
                )


        }
        items(listaDatos){

            ComisariaDiseño(dato = it,text)
        }
    }
}

data class Datos(val datos: String,val Dirección:String, val Teléfono:String,val provincia:String,val tipo:String)

private val listaDatos= listOf(
    Datos(datos="Comisaria San Juan de Dios", Dirección=" C. San Juan de Dios 304, Arequipa 04001"
    ,Teléfono=" (054)231515",provincia="Arequipa",tipo="Comisaria"),
    Datos(datos=" Comisaría Palacio Viejo ", Dirección= "C. Palacio Viejo 112, Arequipa 04001 " ,
        Teléfono= "(054) 205896", provincia="Arequipa", tipo="Comisaria")

)

data class Publicidad(val titulo:String)
private val listaPublicidad= listOf(
    Publicidad(titulo="Publicidad 1"),
    Publicidad(titulo="Publicidad 2"),
    Publicidad(titulo="Publicidad 3"),
    Publicidad(titulo="Publicidad 4")
)
@Composable
fun ComisariaDiseño(dato:Datos,text: String) {
    Row(
        modifier=Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    )
    {
        if(text==dato.provincia) {
            Button(onClick = {mostrarDatos() }){
                Text(dato.datos,
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