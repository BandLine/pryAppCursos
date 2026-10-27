package com.example.pryappcursos.Modelo

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class dataDetalleCurso(
    @SerialName(value = "id_curso") val id_curso: Int = 0,
    @SerialName(value = "codigo") val codigo: String = "",
    @SerialName(value = "nombre") val nombre: String = "",
    @SerialName(value = "descripcion") val descripcion: String = "",
    @SerialName(value = "espacio") val espacio: String = "",
    @SerialName(value = "total_horas") val total_horas: Int = 0,
    @SerialName(value = "imagen_url") val imagen_url: String = "",
    @SerialName(value = "dia_semana") val dia_semana: String = "",
    @SerialName(value = "hora_inicio") val hora_inicio: String = "",
    @SerialName(value = "hora_fin") val hora_fin: String = ""
)