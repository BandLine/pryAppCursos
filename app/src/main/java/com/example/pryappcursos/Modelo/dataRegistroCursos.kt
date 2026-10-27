package com.example.pryappcursos.Modelo

import kotlinx.serialization.SerialName


data class dataRegistroCursos(
    @SerialName("id_inscripcion") val id_inscripcion: Int = 0,
    @SerialName("id_curso") val id_curso: Int = 0,
    @SerialName("matricula") val matricula: String = "",
    @SerialName("correo_institucional") val correo_institucional: String = "",
    @SerialName("fecha_registro") val fecha_registro: String = ""
)