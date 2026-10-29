package com.example.pryappcursos.Modelo
import com.example.pryappcursos.Modelo.dataCursos
import com.example.pryappcursos.Interfaceapi.RetrofitCliente

class clsCursosModelo {
    suspend fun obtenerCursosPorCarrera(idCarrera: Int): List<dataCursos> {
        return RetrofitCliente.apiService.obtenerCursos(idCarrera)
    }
}