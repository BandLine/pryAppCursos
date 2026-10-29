package com.example.pryappcursos.Vista

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pryappcursos.Adaptador.AdaptadorEstadoInscripciones
import com.example.pryappcursos.R
import com.example.pryappcursos.Modelo.dataCarreras
import com.example.pryappcursos.Modelo.dataEstadoInscripciones
import com.example.pryappcursos.Presentador.clsVerRegistrosPresentador

class VerRegistrosActivity : AppCompatActivity() {
    private lateinit var presenter: clsVerRegistrosPresentador
    private lateinit var spnCarreras: Spinner
    private lateinit var txtTotal: TextView
    private lateinit var rvEstado: RecyclerView
    private lateinit var btnVolver: Button
    private lateinit var adaptador: AdaptadorEstadoInscripciones

    private var listaCarreras: List<dataCarreras> = emptyList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_ver_registros)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        spnCarreras = findViewById(R.id.spnCarreras)
        txtTotal = findViewById(R.id.txtTotal)
        rvEstado = findViewById(R.id.rvEstado)
        btnVolver = findViewById(R.id.btnVolver)

        adaptador = AdaptadorEstadoInscripciones(emptyList())
        rvEstado.layoutManager = LinearLayoutManager(this)
        rvEstado.adapter = adaptador

        btnVolver.setOnClickListener { finish() }
        findViewById<android.widget.ImageButton>(R.id.btnRegresar).setOnClickListener { finish() }

        spnCarreras.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?, view: View?, position: Int, id: Long
            ) {
                // cada vez que cambia la carrera se recarga la lista
                if (position < listaCarreras.size) {
                    presenter.cargarEstado(listaCarreras[position].id_carrera)
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }

        presenter = clsVerRegistrosPresentador(this)
        presenter.cargarCarreras()
    }

    fun mostrarCarreras(carreras: List<dataCarreras>) {
        listaCarreras = carreras
        val adapterSpinner = ArrayAdapter(this, android.R.layout.simple_spinner_item, carreras)
        adapterSpinner.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spnCarreras.adapter = adapterSpinner
    }

    fun mostrarEstado(estado: dataEstadoInscripciones) {
        txtTotal.text = "Total: " + estado.total
        adaptador.actualizarLista(estado.cursos)
    }

    fun mostrarError(mensaje: String) {
        Toast.makeText(this, mensaje, Toast.LENGTH_LONG).show()
    }
}
