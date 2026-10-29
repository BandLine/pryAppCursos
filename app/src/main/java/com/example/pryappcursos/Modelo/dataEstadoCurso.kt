package com.example.pryappcursos.Modelo

import com.google.gson.annotations.SerializedName

// Un curso de la lista (nombre, imagen, inscritos y cupo)
data class dataEstadoCurso(
    @SerializedName("id_curso") val id_curso: Int = 0,
    @SerializedName("nombre") val nombre: String = "",
    @SerializedName("imagen_url") val imagen_url: String = "",
    @SerializedName("inscritos") val inscritos: Int = 0,
    @SerializedName("cupo") val cupo: Int = 0
)