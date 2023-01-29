package com.example.mvvm1.guardar.ui

import android.util.Patterns
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class  ViewModel:ViewModel() {

    private val _pregunta = MutableLiveData<String>()
    val pregunta : LiveData<String> = _preguntaz

    private val _respuesta = MutableLiveData<String>()
    val respuesta : LiveData<String> = _respuestaz

    private val _respuesta1 = MutableLiveData<String>()
    val respuesta1 : LiveData<String> = _respuesta1z

    private val _respuesta2 = MutableLiveData<String>()
    val respuesta2 : LiveData<String> = _respuesta2z

    private val _isButtonEnable =MutableLiveData<Boolean>()
    val isButtonEnable: LiveData<Boolean> = _isButtonEnable

    fun onCompletedFields(nombre:String, pregunta: String, respuesta: String, respuesta1: String, respuesta2: String) {
        _pregunta.value = pregunta
        _respuesta.value = respuesta
        _respuesta1.value = respuesta1
        _respuesta2.value = respuesta2
        _isButtonEnable.value = enableButton(, nombre, pregunta, respuesta, respuesta1, respuesta2)
    }

    fun enableButton(pregunta: String:String, respuesta: String, respuesta1: String, respuesta2: String) =
        //Patterns.EMAIL_ADDRESS.matcher(mail).matches()
        pregunta.length >0 && respuesta.length >0 && respuesta1.length >0 && respuesta2.length >0
}