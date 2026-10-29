package com.example.pryappcursos.Presentador
import com.example.pryappcursos.Modelo.clsRegistroModelo
import com.example.pryappcursos.Modelo.dataRegistroCursos
import com.example.pryappcursos.Vista.RegistroCursosActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.Calendar
class clsRegistroPresentador(private val vista: RegistroCursosActivity) {
    private val modelo = clsRegistroModelo()
    fun iniciar() {
        val hoy = Calendar.getInstance()
        formatearFecha(hoy.get(Calendar.YEAR), hoy.get(Calendar.MONTH), hoy.get(Calendar.DAY_OF_MONTH))
    }
    fun formatearFecha(anio: Int, mes: Int, dia: Int) {
        val fecha = String.format("%02d/%02d/%04d", dia, mes + 1, anio)
        vista.mostrarFecha(fecha)
    }
    fun buscarAlumno(matricula: String) {
        if (matricula.isEmpty()) {
            vista.mostrarMensaje("Por favor, ingresa la matrícula")
            return
        }
        CoroutineScope(Dispatchers.Main).launch {
            try {
                val respuesta = modelo.buscarAlumno(matricula)
                if (respuesta.exito) {
                    vista.mostrarCorreo(respuesta.correo_institucional)
                } else {
                    vista.mostrarCorreo("")
                    vista.mostrarMensaje(respuesta.mensaje)
                }
            } catch (e: Exception) {
                vista.mostrarMensaje("Error de conexión: " + e.localizedMessage)
            }
        }
    }
    fun registrar(idCurso: Int, matricula: String, correo: String, fecha: String) {
        if (matricula.isEmpty() || correo.isEmpty() || fecha.isEmpty()) {
            vista.mostrarMensaje("Completa la matrícula, la fecha y el correo")
            return
        }
        CoroutineScope(Dispatchers.Main).launch {
            try {
                val registro = dataRegistroCursos(idCurso, matricula, correo, fecha)
                val respuesta = modelo.registrarInscripcion(registro)
                vista.mostrarMensaje(respuesta.mensaje)
                if (respuesta.exito) {
                    vista.cerrar()
                }
            } catch (e: Exception) {
                vista.mostrarMensaje("Error de conexión: " + e.localizedMessage)
            }
        }
    }
}
