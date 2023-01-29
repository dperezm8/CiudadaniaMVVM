package com.example.mvvm1.guardar.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.google.firebase.firestore.FirebaseFirestore

@Composable
fun GuardarDatos(ViewModel: ViewModel) {

    val db = FirebaseFirestore.getInstance()

    var nombre_coleccion = "preguntas"

    val id:String by ViewModel.id.observeAsState(initial = "")
    val pregunta:String by ViewModel.nombre.observeAsState (initial = "")
    val respuesta:String by ViewModel.nombre.observeAsState (initial = "")
    val respuesta1:String by ViewModel.nombre.observeAsState (initial = "")
    val respuesta2:String by ViewModel.nombre.observeAsState (initial = "")
    val isButtonEnable:Boolean by ViewModel.isButtonEnable.observeAsState (initial = false)

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        elevation = 112.dp,
        shape = MaterialTheme.shapes.small,
        backgroundColor = Color.White,
        contentColor = Color.DarkGray,
        border = BorderStroke(1.dp, Color.Blue)
    ) {

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 100.dp)
                .padding(start = 10.dp)
                .padding(end = 10.dp)

        ) {

            Text(
                text = "Guardar pregunta",
                fontWeight = FontWeight.ExtraBold
            )

            Spacer(modifier = Modifier.size(20.dp))

            Spacer(modifier = Modifier.size(5.dp))

            OutlinedTextField(
                value = nombre,
                onValueChange = { ViewModel.onCompletedFields(pregunta = it, respuesta = respuesta, respuesta1 = respuesta1, respuesta2 = respuesta2) },
                label = { Text("Introduce la pregunta") },
                modifier = Modifier.fillMaxWidth(),
                singleLine = true,
            )

            OutlinedTextField(
                value = nombre,
                onValueChange = { ViewModel.onCompletedFields(pregunta = pregunta, respuesta = it, respuesta1 = respuesta1, respuesta2 = respuesta2) },
                label = { Text("Introduce la primera a") },
                modifier = Modifier.fillMaxWidth(),
                singleLine = true,
            )

            OutlinedTextField(
                value = nombre,
                onValueChange = { ViewModel.onCompletedFields(pregunta = pregunta, respuesta = respuesta, respuesta1 = it, respuesta2 = respuesta2) },
                label = { Text("Introduce la opcion b") },
                modifier = Modifier.fillMaxWidth(),
                singleLine = true,
            )

            OutlinedTextField(
                value = nombre,
                onValueChange = { ViewModel.onCompletedFields(pregunta = pregunta, respuesta = respuesta, respuesta1 = respuesta1, respuesta2 = it) },
                label = { Text("Introduce la opcion c") },
                modifier = Modifier.fillMaxWidth(),
                singleLine = true,
            )

            Spacer(modifier = Modifier.size(5.dp))
            val dato = hashMapOf(
                "pregunta" to pregunta.toString(),
                "respuesta" to respuesta.toString(),
                "respuesta1" to respuesta1.toString(),
                "respuesta2" to respuesta2.toString(),
            )

            var mensaje_confirmacion by remember { mutableStateOf("") }

            Button(

                onClick = {
                    db.collection(nombre_coleccion)
                        .document(id)
                        .set(dato)
                        .addOnSuccessListener {
                            mensaje_confirmacion ="Datos guardados correctamente"


                        }
                        .addOnFailureListener {
                            mensaje_confirmacion ="No se ha podido guardar"

                        }
                },

                // EJEMPLO DE VIEWMODEL PARA HABILITAR EL BOTÓN
                enabled= isButtonEnable,

                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Color.Blue,
                    contentColor = Color.White,
                    disabledBackgroundColor = Color(0xFF78C8F9),
                    disabledContentColor = Color.White
                ),
                border = BorderStroke(1.dp, Color.Black)
            )
            {

                Text(text = "Guardar")

            }
            Spacer(modifier = Modifier.size(5.dp))
            Text(text = mensaje_confirmacion)
        }
    }
}