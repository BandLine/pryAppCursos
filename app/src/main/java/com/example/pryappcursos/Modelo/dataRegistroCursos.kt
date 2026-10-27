package com.example.pryappcursos.Modelo

import com.google.gson.annotations.SerializedName

data class dataRegistroCursos(
    @SerializedName("id_inscripcion") val id_inscripcion: Int = 0,
    @SerializedName("id_curso") val id_curso: Int = 0,
    @SerializedName("matricula") val matricula: String = "",
    @SerializedName("correo_institucional") val correo_institucional: String = "",
    @SerializedName("fecha_registro") val fecha_registro: String = ""
)