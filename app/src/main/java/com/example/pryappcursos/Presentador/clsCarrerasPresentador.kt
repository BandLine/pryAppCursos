package com.example.pryappcursos.Presentador
import com.example.pryappcursos.Modelo.clsCarrerasModelo
import com.example.pryappcursos.Modelo.clsCursosModelo
import com.example.pryappcursos.Modelo.dataCarreras
import com.example.pryappcursos.Modelo.dataCursos
import com.example.pryappcursos.Vista.MainActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
class clsCarrerasPresentador(private val vista: MainActivity) {
    private val modeloCarreras = clsCarrerasModelo()
    private val modeloCursos = clsCursosModelo()
    private var listaCarreras: List<dataCarreras> = emptyList()
    fun iniciar() {
        CoroutineScope(Dispatchers.Main).launch {
            try {
                listaCarreras = modeloCarreras.obtenerCarreras()
                vista.mostrarCarreras(listaCarreras)
            } catch (e: Exception) {
                vista.mostrarError("Error al cargar carreras: " + e.localizedMessage)
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
    fun verDetalle(curso: dataCursos) {
        vista.abrirDetalleCurso(curso.id_curso)
    }
    fun registrarse(curso: dataCursos) {
        vista.abrirRegistro(curso.id_curso, curso.nombre, curso.imagen_url)
    }
    fun verRegistros() {
        vista.abrirVerRegistros()
    }
}
