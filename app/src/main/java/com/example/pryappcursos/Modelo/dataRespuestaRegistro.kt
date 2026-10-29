package com.example.pryappcursos.Modelo
import com.google.gson.annotations.SerializedName

data class dataRespuestaRegistro(
    @SerializedName("exito") val exito: Boolean = false,
    @SerializedName("mensaje") val mensaje: String = ""
)
