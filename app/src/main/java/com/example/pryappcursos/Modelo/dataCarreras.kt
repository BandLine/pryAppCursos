package com.example.pryappcursos.Modelo
import com.google.gson.annotations.SerializedName

data class dataCarreras(
    @SerializedName("id_carrera") val id_carrera: Int = 0,
    @SerializedName("nombre") val nombre: String = ""
) {
    override fun toString(): String {
        return nombre
    }
}
