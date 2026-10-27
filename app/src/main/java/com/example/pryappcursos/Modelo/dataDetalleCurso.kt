package com.example.pryappcursos.Modelo

import com.google.gson.annotations.SerializedName

data class dataDetalleCurso(
    @SerializedName("id_curso") val id_curso: Int = 0,
    @SerializedName("codigo") val codigo: String = "",
    @SerializedName("nombre") val nombre: String = "",
    @SerializedName("descripcion") val descripcion: String = "",
    @SerializedName("espacio") val espacio: String = "",
    @SerializedName("total_horas") val total_horas: Int = 0,
    @SerializedName("imagen_url") val imagen_url: String = "",
    @SerializedName("dia_semana") val dia_semana: String = "",
    @SerializedName("hora_inicio") val hora_inicio: String = "",
    @SerializedName("hora_fin") val hora_fin: String = ""
)