package com.example.mvvm1.guardar.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.Preguntasv1.R
import com.example.Preguntasv1.navigation.AppScreens
import com.example.Preguntasv1.navigation.AppNavigation

@Composable
fun MenuInicio(navController: NavHostController) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        elevation = 12.dp,
        shape = MaterialTheme.shapes.small,
        backgroundColor = Color.White,
        contentColor = Color.DarkGray,
        border = BorderStroke(1.dp, Color.DarkGray)
    ) {

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 25.dp)
                .padding(start = 10.dp)
                .padding(end = 10.dp)

        ) {



            Image(
                    painter = painterResource(R.drawable.firebase_completo),
                    contentDescription = "LogoFirebase",
                    modifier = Modifier.size(170.dp)
                )

            //Spacer(modifier = Modifier.size(10.dp))

            Text(
                text = "Preguntas",
                fontSize = 28.sp,
                fontWeight = FontWeight.ExtraBold,

                )

            Spacer(modifier = Modifier.size(10.dp))

            Button(
                onClick = {
                    navController.navigate("GuardarPregunta")


                },
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Color.Blue,
                    contentColor = Color.White
                ),
                border = BorderStroke(1.dp, Color.Black)
            )
            {
               Text(text = "Alta")
            }

            Spacer(modifier = Modifier.size(8.dp))

            Button(
                onClick = {
                    navController.navigate("ModificarPregunta")
                },
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Color.Blue,
                    contentColor = Color.White
                ),
                border = BorderStroke(1.dp, Color.Black)
            )
            {
                Text(text = "Modificar")
            }

            Spacer(modifier = Modifier.size(8.dp))

            Button(
                onClick = {
                    navController.navigate("BorrarPregunta")
                },
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Color.Blue,
                    contentColor = Color.White
                ),
                border = BorderStroke(1.dp, Color.Black)
            )
            {
                Text(text = "Borrar")
            }

            Spacer(modifier = Modifier.size(8.dp))

            Button(
                onClick = {
                    navController.navigate("ConsultarPregunta")
                },
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Color.Blue,
                    contentColor = Color.White
                ),
                border = BorderStroke(1.dp, Color.Black)
            )
            {
                Text(text = "Consultar")
            }

            Spacer(modifier = Modifier.size(8.dp))

            Button(
                onClick = {
                    navController.navigate("InformePreguntas")
                },
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Color.Blue,
                    contentColor = Color.White
                ),
                border = BorderStroke(1.dp, Color.Black)
            )
            {
                Text(text = "Informe general")
            }

        }



    }
}

@Preview (showBackground = true)
@Composable
fun MenuInicio () {
}