package com.example.pryappcursos.Interfaceapi
import com.example.pryappcursos.Modelo.dataDetalleCurso
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface ApiService {

    //@GET(value = "obtener_carreras.php")
    /*suspend fun obtenerCarreras(): List<dataCarreras>

    @GET(value = "obtener_cursos.php")
    suspend fun obtenerCursos(@Query(value = "carrera_id") idCarrera: Int): List<dataCursos>
*/
    @GET(value = "detalle_curso.php")
    suspend fun obtenerDetalleCurso(@Query(value = "id_curso") idCurso: Int): List<dataDetalleCurso>
/*
    @POST("registrar_Inscripciones.php")
    suspend fun registrarInscripcion(@Body request: RegistroRequest): RegistroResponse

    @GET(value = "obtener_detalle_inscripciones.php")
    suspend fun obtenerEstadoInscripciones(@Query(value = "carrera_id") idCarrera: Int): dataEstadoInscripciones
 */

}
