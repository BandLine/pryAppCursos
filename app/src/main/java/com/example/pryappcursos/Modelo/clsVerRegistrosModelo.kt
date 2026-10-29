package com.example.pryappcursos.Modelo

import com.example.pryappcursos.Interfaceapi.RetrofitCliente

class clsVerRegistrosModelo {
    suspend fun obtenerCarreras(): List<dataCarreras> {
        val datos = RetrofitCliente.apiService.obtenerCarreras()
        val listaFinal = mutableListOf(dataCarreras(0, "Todas las carreras"))
        listaFinal.addAll(datos)
        return listaFinal
    }

    suspend fun obtenerEstadoInscripciones(idCarrera: Int): dataEstadoInscripciones {
        return RetrofitCliente.apiService.obtenerEstadoInscripciones(idCarrera)
    }
}