package com.example.pryappcursos.Presentador

import com.example.pryappcursos.DetalleCursoActivity
import com.example.pryappcursos.Modelo.clsDetalleCursoModelo
import com.example.pryappcursos.Modelo.dataDetalleCurso
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class clsDetalleCursoPresentador(private val vista: DetalleCursoActivity) {
    private val modelo = clsDetalleCursoModelo()

    fun cargarDetalle(idCurso: Int) {
        CoroutineScope(Dispatchers.Main).launch {
            try {
                val listaCurso: List<dataDetalleCurso> = modelo.obtenerDetalleCurso(idCurso)
                if (listaCurso.isNotEmpty()) {
                    vista.mostrarDetalle(listaCurso[0])
                } else {
                    vista.mostrarError("No se encontró información del curso")
                }
            } catch (e: Exception) {
                vista.mostrarError("Error al cargar detalle: " + e.localizedMessage)
            }
        }
    }
}