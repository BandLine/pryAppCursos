package com.example.pryappcursos.Modelo

import com.example.pryappcursos.Interfaceapi.RetrofitCliente

class clsVerRegistrosModelo {
    suspend fun obtenerCarreras(): List<dataCarreras> {
        return RetrofitCliente.apiService.obtenerCarreras()
    }

    suspend fun obtenerEstadoInscripciones(idCarrera: Int): dataEstadoInscripciones {
        return RetrofitCliente.apiService.obtenerEstadoInscripciones(idCarrera)
    }
}