package com.example.pryappcursos.Modelo

import com.google.gson.annotations.SerializedName

data class dataCursos(
    @SerializedName("id_curso") val id_curso: Int = 0,
    @SerializedName("id_carrera") val id_carrera: Int =0,
    @SerializedName("Salon") val Salon: String = "",
    @SerializedName("nombre") val nombre: String = "",
    @SerializedName("imagen_url") val imagen_url: String = "",
)
