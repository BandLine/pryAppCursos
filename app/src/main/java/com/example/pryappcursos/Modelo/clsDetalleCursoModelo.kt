package com.example.pryappcursos.Modelo

import com.example.pryappcursos.Interfaceapi.RetrofitCliente

class clsDetalleCursoModelo {
    suspend fun obtenerDetalleCurso(idCurso: Int): List<dataDetalleCurso> {
        return RetrofitCliente.apiService.obtenerDetalleCurso(idCurso)
    }
}