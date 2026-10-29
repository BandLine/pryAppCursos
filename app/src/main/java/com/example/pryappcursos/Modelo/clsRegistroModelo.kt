package com.example.pryappcursos.Modelo
import com.example.pryappcursos.Interfaceapi.RetrofitCliente
class clsRegistroModelo {
    suspend fun buscarAlumno(matricula: String): dataAlumno {
        return RetrofitCliente.apiService.buscarAlumno(dataBuscarAlumno(matricula))
    }
    suspend fun registrarInscripcion(registro: dataRegistroCursos): dataRespuestaRegistro {
        return RetrofitCliente.apiService.registrarInscripcion(registro)
    }
}
