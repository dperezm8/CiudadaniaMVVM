package com.example.mvvm1.navigation

// CREAMOS UNA SEALED CLASS PARA CONTENER LOS OBJETOS DE CADA RUTA
sealed class AppScreens(val ruta: String){
    object BorrRarPregunta: AppScreens("BorrarPregunta")
    object ConsultarPregunta: AppScreens("ConsultarPregunta")
    object GuardarPregunta: AppScreens("GuardarDatos")
    object InformePregunta: AppScreens("InformePregunta")
    object MenuInicio: AppScreens("MenuInicio")
    object ModificarPregunta: AppScreens("ModificarPregunta")

}
