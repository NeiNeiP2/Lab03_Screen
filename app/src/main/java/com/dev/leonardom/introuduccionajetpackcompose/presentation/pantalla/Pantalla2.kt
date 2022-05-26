package com.dev.leonardom.introuduccionajetpackcompose.presentation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.compiler.plugins.kotlin.lower.forEachWith
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
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
import androidx.constraintlayout.compose.ConstraintSet
import androidx.datastore.core.DataStore
import androidx.navigation.NavController
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.dev.leonardom.introuduccionajetpackcompose.Clases.Provincia
import com.dev.leonardom.introuduccionajetpackcompose.navigation.Destinations
import java.util.prefs.Preferences

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun Pantalla2(navController: NavController, text3: String, text4: String) {
    var text by remember { mutableStateOf("")}
    var text2 by remember  { mutableStateOf("")}
    Box(modifier=Modifier.fillMaxSize()){
        text=text3
        text2=text4
        val listState = rememberLazyListState()
        LazyColumn(contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(20.dp),
            state = listState
        ){
            item{
                if(text2!="CentroDeSalud"){
                    Text(
                        text = text2,
                        style = TextStyle(
                            fontSize = 28.sp,
                            fontWeight = FontWeight.Black
                        )
                    )
                }
                else{
                    Text(
                        text = "Centro de Salud",
                        style = TextStyle(
                            fontSize = 28.sp,
                            fontWeight = FontWeight.Black
                        )
                    )
                }
            }
            items(listaDatos){
                        Row(
                            modifier=Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        )
                        {
                    ComisariaDiseño(dato = it,text,text2)
                }

            }
        }
    }




}

@Composable
fun PublicidadDiseño(publicidad: Publicidad) {
    Box(
        modifier=Modifier.padding(end=8.dp).size(140.dp).clip(RoundedCornerShape(12))
            .background(color=Color.LightGray), contentAlignment = Alignment.Center
    )
    {
        Text(publicidad.titulo,
                style = TextStyle(
                fontSize = 20.sp,
                fontWeight = FontWeight.Black,
                            fontStyle = FontStyle.Italic
                        ))
    }
}
@Composable
fun ComisariaDiseño(dato:Datos,text: String, text2: String) {

                if(text==dato.provincia&&text2==dato.tipo){
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
fun mostrarDatos(){

}
data class Datos(val datos: String,val Dirección:String, val Teléfono:String,val provincia:String,val tipo:String)

private val listaDatos= listOf(
    //Provincia - Arequipa - Comisaria
    Datos(datos="Comisaria San Juan de Dios", Dirección=" C. San Juan de Dios 304, Arequipa 04001"
    ,Teléfono=" (054)231515",provincia="Arequipa",tipo="Comisaria"),
    Datos(datos=" Comisaría Palacio Viejo ", Dirección= "C. Palacio Viejo 112, Arequipa 04001 " ,
        Teléfono= "(054) 205896", provincia="Arequipa", tipo="Comisaria"),
    Datos(datos="Comisaria PNP Santa Marta", Dirección= "Calle Sta. Marta 212, Arequipa 04001",
        Teléfono= "(054) 206259", provincia="Arequipa", tipo="Comisaria"),
    Datos(datos="Comisaría Yanahuara", Dirección= "Av. Ejército 341, Yanahuara 04013",
        Teléfono= "(054) 276444", provincia="Arequipa", tipo="Comisaria"),
    Datos(datos="Comisaria Jose Luis Bustamante y Rivero",
            Dirección= "Cipreses S/N, José Luis Bustamante y Rivero 04002",
        Teléfono= "(054) 427290", provincia="Arequipa", tipo="Comisaria"),
    Datos(datos="Policía de Turismo", Dirección= "C. Jerusalén 315, Arequipa 04001", Teléfono= "(054) 282613",
        provincia="Arequipa", tipo="Comisaria"),
    Datos(datos="POLICÍA NACIONAL", Dirección= "Av. Emmel 106, Yanahuara 04013",
        Teléfono= "(054) 254020", provincia="Arequipa", tipo="Comisaria"),
    Datos(datos="Comisaría de Cayma", Dirección= "Calle Plaza Principal de Cayma N°412, Av. Cayma, Cayma",
        Teléfono= "(054) 256891", provincia="Arequipa", tipo="Comisaria"),
    Datos(datos="Comisaria Hunter", Dirección= "Av. Brasilia N° 305, Jacobo Hunter 04011", Teléfono= "(054) 440307",
        provincia="Arequipa", tipo="Comisaria"),
    Datos(datos="Comisaría Sachaca", Dirección= "HCGP+P2W, Av. Fernandini, Sachaca 04013", Teléfono= "(054) 222179",
        provincia="Arequipa", tipo="Comisaria"),
    //          Hospitales
    Datos(datos="Hospital Regional Honorio Delgado Espinoza",
            Dirección= "Alcides Carrión, Arequipa 04002", Teléfono= "(054) 234597", provincia="Arequipa", tipo="CentroDeSalud"),
    Datos(datos="Hospital Goyeneche", Dirección= "Av. Goyeneche, Arequipa 04001",Teléfono= "(054) 231313",
        provincia="Arequipa", tipo="CentroDeSalud"),
    Datos(datos="Hospital Nacional Carlos Alberto Seguin Escobedo", Dirección= "JF4C+27X, Esquina de Peral y Filtro S/N, Arequipa",
        Teléfono= "(054) 214050", provincia="Arequipa", tipo="CentroDeSalud"),
    Datos(datos="Seguro Social Essalud Arequipa", Dirección= "C. Peral 555, Arequipa 04001", Teléfono= "(054) 226969",
        provincia="Arequipa", tipo="CentroDeSalud"),
    Datos(datos="Hospital III Yanahuara EsSalud", Dirección= "JF34+56M, Av. Garaycochea, Arequipa 04013",
        Teléfono= "(054) 226969", provincia="Arequipa", tipo="CentroDeSalud"),
    Datos(datos="Es Salud", Dirección="JF39+WP2, C. Ayacucho, Arequipa 04001",
        Teléfono= "(054) 235155", provincia="Arequipa", tipo="CentroDeSalud"),
    Datos(datos="Clínica Arequipa S.A", Dirección= "Francisco Bolognesi 104, Arequipa 04017",
        Teléfono= "(054) 599000", provincia="Arequipa", tipo="CentroDeSalud"),
    Datos(datos="Clínica San Juan de Dios", Dirección= "Terminal Terrestre, Óvalo, Arequipa 04011",
        Teléfono= "913 030 100", provincia="Arequipa", tipo="CentroDeSalud"),
    Datos(datos="Policlinico Barra", Dirección= "Av. Emmel 235, Arequipa 04013",
        Teléfono= "(054) 692816", provincia="Arequipa", tipo="CentroDeSalud"),
    //          Bomberos
    Datos(datos="Benemérita y Centenaria Compañía de Bomberos Arequipa 19", Dirección= "C. Bolivar 120, Arequipa 04001", Teléfono= "(054) 241833",
        provincia="Arequipa", tipo="Bomberos"),
    Datos(datos="VII COMANDANCIA DEPARTAMENTAL DE AREQUIPA CUERPO GENERAL DE BOMBEROS VOLUNTARIOS DEL PERU", Dirección= "JF5C+PG8, Alto Selva Alegre 04001",
        Teléfono= "(054) 213333", provincia="Arequipa", tipo="Bomberos"),
    //PROVINCIA - CAMANÁ
    Datos(datos="Comisaría sectorial la pampa", Dirección= "98P2+HGQ, Vía de Evitamiento, Camaná 04446",
        Teléfono= "(054) 505063", provincia="Camana", tipo="Comisaria"),
    Datos(datos="Complejo Policial Camaná", Dirección= "Av. Mariscal Castilla 735, Camaná 04450", Teléfono= "(054) 572988", provincia="Camana",
        tipo="Comisaria"),
    Datos(datos="Comisaria san jose",Dirección= "Avenida Plaza de Armas N°150",
        Teléfono= "(054) 573503", provincia="Camana",
        tipo="Comisaria"),

    Datos(datos="Comisaría san gregorio", Dirección= "Calle Progreso N°437", Teléfono= "(054) 505199",
    provincia="Camana", tipo="Comisaria"),
    Datos(datos="Comisaría de El Cardo",
            Dirección= "97WF+R9X, Calle Comercio N° S/N, Anexo El Puente de Fierro",
        Teléfono= "(054) 573460",
        provincia="Camana",
        tipo="Comisaria"),
    //              HOSPITALES
    Datos(datos="Hospital de Apoyo de Camaná",
            Dirección= "Panamericana Sur 550, Camaná 04450",
        Teléfono= "(054) 571604",
        provincia="Camana",
        tipo="CentroDeSalud"),
    Datos(datos="Nuevo Hospital De Camaná",
            Dirección= "Av 3 de Noviembre 141, Camaná 04450",
        Teléfono= "(054) 571604", provincia="Camana", tipo="CentroDeSalud"),
    Datos(datos="Hospital EsSalud Camana",
            Dirección= "Av 13 de Noviembre, 04446",
        Teléfono= "(054)571494", provincia="Camana", tipo="CentroDeSalud"),
    //              BOMBEROS
    Datos(datos="Compañía de Bomberos de Camana B-35",
            Dirección= "Jr. Nicolas de Pierola 308, Camaná 04451", Teléfono="(054) 571021", provincia="Camana",
        tipo="Bomberos"),
    //PROVINCIA - Caravelí
    Datos(datos="Comisaría Sectorial de Caravelí",
            Dirección= "Avenida 2 de Mayo N° 809, Caravelí 04740",
        Teléfono= "(054) 511081",
        provincia="Caraveli",
        tipo="Comisaria"),
    Datos(datos="Centro de Salud de Caravelí",
            Dirección= "12, Caravelí 04740",
        Teléfono= "(054) 511089",
        provincia="Caraveli",
        tipo="CentroDeSalud"),

    //PROVINCIA . CASTILLA
    Datos(datos="CPNP Sectorial Castilla Aplao",
            Dirección=  "Cll. Pardo Sn Mz.J1 Lt.14",
        Teléfono=  "(054)471187",
        provincia="Castilla",
        tipo="Comisaria"),
    Datos(datos="Comisaría PNP Protección de Carreteras Aplao",
            Dirección= "Pardo Mz. K1 Lt. 4, Aplao",
        Teléfono= "(054) 471022",
        provincia="Castilla",
        tipo="Comisaria"),
    //hospital
    Datos(datos="Hospital de Aplao",
            Dirección= "Av. 21 de Marzo 111, Aplao",
        Teléfono= "(054) 471021",
        provincia="Castilla",
        tipo="CentroDeSalud"),
    Datos(datos="Red de Salud Castilla - Condesuyos - La Unión (RED CCU)",
            Dirección= "Av. 21 de Marzo 105, Aplao",
        Teléfono= "(054) 471137",
        provincia="Castilla",
        tipo="CentroDeSalud"),
    Datos(datos="Centro de Salud Orcopampa",
            Dirección= "Av. Manto S/N, Orcopampa 04656",
        Teléfono= "(054) 582339",
        provincia="Castilla",
        tipo="CentroDeSalud"),
    //PROVINCIA - LA UNION
    Datos(datos="Comisaria rural alca",
            Dirección= "V68P+25W, Calle Plaza de Armas S/N - La union - Alca, Alca",Teléfono="",
        provincia="LaUnion",
                tipo="Comisaria"),
    Datos(datos="Comisaria rural charcana",
            Dirección= "QW5H+RXV, Calle Plaza de Armas S/N - La Union Charcana, Charcana",Teléfono="",
        provincia="LaUnion",
        tipo="Comisaria"),
    Datos(datos="COMISARIA SECTORIAL COTAHUASI",
            Dirección= "Q4Q2+6J Cotahuasi, Perú",
        Teléfono= "054581031",
        provincia="LaUnion",
        tipo="Comisaria"),
    //          HOSPITAL
    Datos(datos="CS cotahuasi",
            Dirección= "AV Union,Cotahuasi, la union",Teléfono="",
        provincia="LaUnion",
        tipo="CentroDeSalud"),
    Datos(datos="PS Characana",
            Dirección="Calle manco capac,Characana,la union", Teléfono="",
        provincia="LaUnion",
        tipo="CentroDeSalud"),
    // PROVINCIA - CONDESUYOS
            Datos(datos="Comisaria sectorial rural chuquibamba",
            Dirección= "Avenida Nicolas de Pierola N° 100 - Condesuyos - Chuquibamba",
    Teléfono= "(054) 474119",
    provincia="Condesuyos",
    tipo="Comisaria"),
    Datos(datos="Comisaria rural salamanca",
            Dirección= "F5W8+3FJ, Avenida Salamanca S/N - Condesuyos - Salamanca, Queñuamarca",
        Teléfono= "945078655",
        provincia="Condesuyos",
        tipo="Comisaria"),
    Datos(datos="Comisaria minas ocoña",
            Dirección= "3V59+RF7, Calle Principal S/N - Condesuyo - Rio Grande, Cunocuno",
        Teléfono= "957689643",
        provincia="Condesuyos",
        tipo="Comisaria"),
    Datos(datos="COMISARIA RURAL ARCATA",
            Dirección= "XP5F+CQX, Arcata 04195",
        Teléfono= "#957689516",
        provincia="Condesuyos",
        tipo="Comisaria"),
    Datos(datos="COMISARIA RURAL YANAQUIHUA",
            Dirección= "64FF+CX Yanaquihua",
        Teléfono= "#957690104",
        provincia="Condesuyos",
        tipo="Comisaria"),
    //      HOSPITAL
    Datos(datos="Posta Medica De Chuquibamba",
            Dirección="Av Mariscal Castilla 108 A",
        Teléfono="(054) 474149",
        provincia="Condesuyos",
        tipo="CentroDeSalud"),
    Datos(datos="Centro de Salud Yanaquihua",
            Dirección="AV.Rodriguez del valle,Yanaquihua",
        Teléfono= "(054) 720350",
        provincia="Condesuyos",
        tipo="CentroDeSalud"),
    // provincia -  islay
    Datos(datos="Comisaría Policial de Matarani",
            Dirección= "Matarani 04410",
        Teléfono= "(054) 557016",
        provincia="Islay",
        tipo="Comisaria"),
    Datos(datos="Comisaria el arenal",
            Dirección= "V6H3+HJ2, Islay - Dean Valdivia, El Arenal",
    Teléfono= "(054) 556042",
    provincia="Islay",
    tipo="Comisaria"),
    Datos(datos="Comisaria sectorial mollendo", Dirección= "C. Islay 849, Mollendo 04416",
    Teléfono= "(054) 534242", provincia="Islay", tipo="Comisaria"),
    Datos(datos="Comisaria la curva", Dirección= "V54H+9CJ, Avenida Dean Valdivia S/N, La Curva",
    Teléfono= "(054) 554042", provincia="Islay", tipo="Comisaria"),
    Datos(datos="Comisaria Alto Inclán", Dirección= "XXJW+4CP, Mollendo 04416",
    Teléfono= "(054) 532702", provincia="Islay",tipo="Comisaria"),
    Datos(datos="Comisaria Punta de Bombón",
            Dirección= "Calle Plaza 28 de Julio S/N, Punta de Bombón",
        Teléfono= "(054) 553150",
        provincia="Islay",
        tipo="Comisaria"),
    Datos(datos="Comisaria cocachacra",
            Dirección= "Av. Libertad 824, Cocachacra 04431",
        Teléfono= "(054) 403067",
        provincia="Islay",
        tipo="Comisaria"),
    Datos(datos="Comisaria Miramar",
            Dirección= "XXFR+HMM, Mollendo 04416",
        Teléfono= "(054) 533053",
        provincia="Islay",
        tipo="Comisaria"),
    //      hospital
    Datos(datos="Posta Medica Matarani",
            Dirección= ",2W24+C9Q, Matarani 04410",
        Teléfono= "(054) 557118",
        provincia="Islay",
        tipo="CentroDeSalud"),
    Datos(datos="Hospital II Manuel de Torres Nuñez Mollendo - EsSalud",
            Dirección= "Hospital Manuel Torres Munoz, Juan B. Arenas 100, Mollendo 04416",
        Teléfono= "(054) 226969",
        provincia="Islay",
        tipo="CentroDeSalud"),
    Datos(datos="Centro de salud Alto Inclán",
            Dirección= "XXJV+2XQ, Mollendo 04416",
        Teléfono= "(054) 532331",
        provincia="Islay",
        tipo="CentroDeSalud"),
    Datos(datos="Puesto de Salud El Arenal",
            Dirección= "El Arenal 04425",
        Teléfono= "(054) 556114",
        provincia="Islay",
        tipo="CentroDeSalud"),
    //          bomberos
    Datos(datos="Compañia de Bomberos 12",
            Dirección= "XXCM+4VW, Mollendo 04416",
        Teléfono= "(054) 533333",
        provincia="Islay",
        tipo="Bomberos"),
    Datos(datos="Compañía de Bomberos Samuel Málaga N° 144",
            Dirección= "Jhon F Kennedy 206, Mollendo 04416",
        Teléfono= "(054) 533572",
        provincia="Islay",
        tipo="Bomberos"),
    Datos(datos="Compañia de Bomberos B—209",
            Dirección= "W66M+6MW, Cocachacra 04431",
    Teléfono= "961 968 715",
    provincia="Islay",
    tipo="Bomberos"),
    //provincia - caylloma
    Datos(datos="Comisaria rural caylloma",
            Dirección= "R66G+PJQ, Plaza Principal Caylloma S/N - Caylloma, Caylloma",
        Teléfono= "(054) 531 072",
        provincia="Caylloma",
        tipo="Comisaria"),
    Datos(datos="Comisaria Rural PNP Chivay",
            Dirección= "997X+68W, Av. Salaverry, Chivay 04145",
        Teléfono= "(054) 531072",
        provincia="Caylloma",
        tipo="Comisaria"),
    Datos(datos="Comisaría huanca",
            Dirección= "Calle 3 De Setiembre S/N - Caylloma - Huanca",
        Teléfono="",
        provincia="Caylloma",
        tipo="Comisaria"),
    //hospital
    Datos(datos="Centro de Salud Caylloma",
            Dirección= "R67H+GVG, 04190",
        Teléfono="",
        provincia="Caylloma",
        tipo="CentroDeSalud"),
    Datos(datos="Centro de Salud Caylloma Alta",
        Dirección="R67G+368, Caylloma 04190",
        Teléfono="",
        provincia="Caylloma",
        tipo="CentroDeSalud"),
    Datos(datos="Centro de Salud - MINSA",
            Dirección= "9C82+G6Q, Ramon Castilla, Chivay 04145",
        Teléfono= "950 683 783",
        provincia="Caylloma",
        tipo="CentroDeSalud"),
    Datos(datos="Posta Medica - ESSALUD",
            Dirección= "9C42+FXV, 2 de Mayo, Chivay 04145",
        Teléfono= "(054) 531110",
        provincia="Caylloma",
        tipo="CentroDeSalud"),
    Datos(datos="Hospital Central de Majes",
            Dirección= "Majes 04110",
        Teléfono= "987 332 969",
        provincia="Caylloma",
        tipo="CentroDeSalud"),
    //bomberos
    Datos(datos="CUERPO GENERAL DE BOMBEROS VOLUNTARIOS DEL PERÙ",
            Dirección= "B-205 - EL PEDREGAL,majes,caylloma",
        Teléfono= "",
        provincia="Caylloma",
        tipo="Bomberos"))

data class Publicidad(val titulo:String)
private val listaPublicidad= listOf(
    Publicidad(titulo="Publicidad 1"),
    Publicidad(titulo="Publicidad 2"),
    Publicidad(titulo="Publicidad 3"),
    Publicidad(titulo="Publicidad 4")
)
