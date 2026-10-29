package com.example.pryappcursos.Presentador

import com.example.pryappcursos.Modelo.clsVerRegistrosModelo
import com.example.pryappcursos.VerRegistrosActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class clsVerRegistrosPresentador(private val vista: VerRegistrosActivity) {
    private val modelo = clsVerRegistrosModelo()

    fun cargarCarreras() {
        CoroutineScope(Dispatchers.Main).launch {
            try {
                val carreras = modelo.obtenerCarreras()
                if (carreras.isNotEmpty()) {
                    vista.mostrarCarreras(carreras)
                } else {
                    vista.mostrarError("No hay carreras registradas")
                }
            } catch (e: Exception) {
                vista.mostrarError("Error al cargar carreras: " + e.localizedMessage)
            }
        }
    }

    fun cargarEstado(idCarrera: Int) {
        CoroutineScope(Dispatchers.Main).launch {
            try {
                val estado = modelo.obtenerEstadoInscripciones(idCarrera)
                vista.mostrarEstado(estado)
            } catch (e: Exception) {
                vista.mostrarError("Error al cargar inscripciones: " + e.localizedMessage)
            }
        }
    }
}