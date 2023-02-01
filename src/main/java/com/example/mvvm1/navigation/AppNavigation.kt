package com.example.mvvm1.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.mvvm1.view.*


@Composable
fun AppNavigation() {
    val navigationController = rememberNavController()
    NavHost(navController = navigationController, startDestination = AppScreens.MenuInicio.ruta) {
        composable(AppScreens.BorrarPregunta.ruta) {
            BorrarPregunta(navigationController), ViewModel
        }

        composable(AppScreens.MenuInicio.ruta) {
            ConsultarPregunta(navigationController), ViewModel
        }

        composable(AppScreens.GuardarPregunta.ruta) {
            GuardarPregunta(navigationController), ViewModel
        }

        composable(AppScreens.InformePregunta.ruta) {
            InformePregunta(navigationController), ViewModel
        }

        composable(AppScreens.MenuInicio.ruta) {
            MenuInicio(navigationController), ViewModel
        }
        composable(AppScreens.ModificarPregunta.ruta) {
            ModificarPregunta(navigationController), ViewModel
        }
    }
}