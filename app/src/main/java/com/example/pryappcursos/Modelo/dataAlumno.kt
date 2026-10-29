package com.example.pryappcursos.Modelo
import com.google.gson.annotations.SerializedName

data class dataAlumno(
    @SerializedName("exito") val exito: Boolean = false,
    @SerializedName("mensaje") val mensaje: String = "",
    @SerializedName("matricula") val matricula: String = "",
    @SerializedName("correo_institucional") val correo_institucional: String = ""
)
