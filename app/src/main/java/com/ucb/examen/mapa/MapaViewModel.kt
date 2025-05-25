package com.ucb.examen.mapa

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class MapaViewModel: ViewModel() {
    val phone = mutableStateOf("")
    val latitud = mutableStateOf<Double?>(null)
    val longitud = mutableStateOf<Double?>(null)

    fun actualizarTelefono(value: String) {
        phone.value = value
    }

    fun actualizarUbicacion(lat: Double, lng: Double) {
        this.latitud.value = lat
        this.longitud.value = lng
    }

    fun esNumValido(): Boolean {
        return phone.value.isNotEmpty() && latitud.value != null && longitud.value != null
    }
}