package com.example.pryappcursos.Presentador

import com.example.pryappcursos.Modelo.clsCarrerasModelo
import com.example.pryappcursos.Modelo.clsCursosModelo
import com.example.pryappcursos.Modelo.dataCarreras
import com.example.pryappcursos.Modelo.dataCursos
import com.example.pryappcursos.Vista.MainActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class clsCarrerasPresentador (val vista: MainActivity){
    private val modeloCarreras = clsCarrerasModelo()
    private val modeloCursos = clsCursosModelo()
    private var listaCarreras: List<dataCarreras> = emptyList()

    fun iniciar() {
        CoroutineScope(Dispatchers.Main).launch {
            try {
                listaCarreras = modeloCarreras.obtenerCarreras()
                vista.mostrarCarreras(listaCarreras)
                cargarCursos(0)

            } catch (e: Exception) {
                vista.mostrarError("Error: " + e.localizedMessage)
            }
        }
    }

    fun seleccionarCarrera(posicion: Int) {
        if (posicion >= 0 && posicion < listaCarreras.size) {
            val carrera = listaCarreras[posicion]
            cargarCursos(carrera.id_carrera)
        }
    }

    private fun cargarCursos(idCarrera: Int) {
        CoroutineScope(Dispatchers.Main).launch {
            try {
                val cursos = modeloCursos.obtenerCursosPorCarrera(idCarrera)
                vista.mostrarCursos(cursos)
            } catch (e: Exception) {
                vista.mostrarError("Error al cargar cursos: " + e.localizedMessage)
            }
        }
    }

    fun seleccionarCurso(curso: dataCursos) {
        vista.abrirDetalleCurso(curso.id_curso)
    }
    fun registrarseCurso(curso: dataCursos) {
        vista.abrirRegistroCurso(curso)    }
    fun verRegistros() {
        vista.abrirVerRegistros()
    }
}