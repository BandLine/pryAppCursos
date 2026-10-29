package com.example.pryappcursos.Interfaceapi
import com.example.pryappcursos.Modelo.dataAlumno
import com.example.pryappcursos.Modelo.dataBuscarAlumno
import com.example.pryappcursos.Modelo.dataCarreras
import com.example.pryappcursos.Modelo.dataCursos
import com.example.pryappcursos.Modelo.dataDetalleCurso
import com.example.pryappcursos.Modelo.dataEstadoInscripciones
import com.example.pryappcursos.Modelo.dataRegistroCursos
import com.example.pryappcursos.Modelo.dataRespuestaRegistro
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query
interface ApiService {
    @GET("obtener_carreras.php")
    suspend fun obtenerCarreras(): List<dataCarreras>
    @GET("obtener_cursos.php")
    suspend fun obtenerCursos(@Query("carrera_id") idCarrera: Int): List<dataRegistroCursos>
    @GET("detalle_curso.php")
    suspend fun obtenerDetalleCurso(@Query("id_curso") idCurso: Int): List<dataDetalleCurso>
    @POST("buscar_alumno.php")
    suspend fun buscarAlumno(@Body datos: dataBuscarAlumno): dataAlumno
    @POST("api_Inscripciones.php")
    suspend fun registrarInscripcion(@Body datos: dataRegistroCursos): dataRespuestaRegistro
    @GET("obtener_detalle_inscripciones.php")
    suspend fun obtenerEstadoInscripciones(@Query("carrera_id") idCarrera: Int): dataEstadoInscripciones
}
