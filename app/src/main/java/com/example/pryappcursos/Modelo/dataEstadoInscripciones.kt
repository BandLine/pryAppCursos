package com.example.pryappcursos.Modelo

import com.google.gson.annotations.SerializedName

// Respuesta completa de obtener_detalle_inscripciones.php
data class dataEstadoInscripciones(
    @SerializedName("total") val total: Int = 0,
    @SerializedName("cursos") val cursos: List<dataEstadoCurso> = emptyList()
)

