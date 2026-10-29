package com.example.pryappcursos.Modelo
import com.example.pryappcursos.Interfaceapi.RetrofitCliente
class clsCarrerasModelo {
    suspend fun obtenerCarreras(): List<dataCarreras> {
        val datos = RetrofitCliente.apiService.obtenerCarreras()
        val listaFinal = mutableListOf(dataCarreras(0, "Todas las carreras"))
        listaFinal.addAll(datos)
        return listaFinal
    }
}