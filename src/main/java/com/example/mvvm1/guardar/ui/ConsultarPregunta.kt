package com.example.mvvm1.guardar.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.clientesv1.navigation.AppScreens
import com.google.firebase.firestore.FirebaseFirestore

@Composable
fun ConsultarCliente(navController: NavHostController) {

    var nombre_coleccion = "preguntas"
    val db = FirebaseFirestore.getInstance()
    //var datos by remember { mutableStateOf("") }

    Column(

        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 100.dp)
            .padding(start = 10.dp)
            .padding(end = 10.dp)
    ) {

        Text(
            text = "Búsqueda de las preguntas",
            fontWeight = FontWeight.ExtraBold
        )

        Spacer(modifier = Modifier.size(20.dp))

        //DECLARAMOS LA VARIABLE QUE VA A RECOGER LOS DATOS DE LA CONSULTA CON EL ESTADO REMEMBER
        var datos by remember { mutableStateOf("") }
        var pregunta by remember { mutableStateOf("") }
        var respuesta by remember { mutableStateOf("") }
        var respuesta1 by remember { mutableStateOf("") }
        var respuesta2 by remember { mutableStateOf("") }

        var pregunta_busqueda by remember { mutableStateOf("") }
        val field_busqueda ="pregunta"
        OutlinedTextField(
            value = nif_busqueda,
            onValueChange = { nif_busqueda = it },
            label = { Text("Introduce la pregunta que quieres buscar") },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true,
        )

        Spacer(modifier = Modifier.size(5.dp))

        Button(
            onClick = {

                // VACIAMOS VARIABLE AL DAR AL BOTON
                datos = ""
                pregunta = ""
                respuesta = ""
                respuesta1 = ""
                respuesta2= ""
                // HACEMOS LA CONSULTA A LA COLECCION CON GET
                db.collection(nombre_coleccion)
                    .whereEqualTo(field_busqueda,pregunta_busqueda)
                    .get()

                    //SI SE CONECTA CORRECTAMENTE
                    // RECORRO TODOS LOS DATOS ENCONTRADOS EN LA COLECCIÓN Y LOS ALMACENO EN DATOS
                    .addOnSuccessListener { resultado ->
                        for (encontrado in resultado) {
                            //Para crear un HashMap con todos los datos
                            datos += "${encontrado.id}: ${encontrado.data}\n"

                            //Para crear un HashMap con todos los datos
                            pregunta += encontrado["pregunta"].toString()
                            respuesta += encontrado["respuesta"].toString()
                            respuesta1 += encontrado["respuesta1"].toString()
                            respuesta2 += encontrado["respuesta2"].toString()
                            //Log.i("DATOS:", datos)
                        }

                        if (datos.isEmpty()) {
                            datos = "No existen datos"
                        }
                    }
                    //SI NO CONECTA CORRECTAMENTE
                    .addOnFailureListener { resultado ->
                        datos = "La conexión a FireStore no se ha podido completar"
                    }
            },

            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color.Blue,
                contentColor = Color.White
            ),
            border = BorderStroke(1.dp, Color.Black)
        )
        {

            Text(text = "Cargar Datos")
        }

        Spacer(modifier = Modifier.size(10.dp))

        // PINTAMOS EL RESULTADO DE LA CONSULTA A LA BASE DE DATOS
        //Text (text = datos)
        Text (text = "Pregunta: " + pregunta)
        Text (text = "Opcion A: " + respuesta)
        Text (text = "Opcion B: " + respuesta1)
        Text (text = "Opcion C: " + respuesta2)
    }
}