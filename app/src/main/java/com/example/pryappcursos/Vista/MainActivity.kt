package com.example.pryappcursos.Vista

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pryappcursos.Adaptador.cursosAdaptador
import com.example.pryappcursos.Modelo.dataCarreras
import com.example.pryappcursos.Modelo.dataCursos
import com.example.pryappcursos.Presentador.clsCarrerasPresentador
import com.example.pryappcursos.R

class MainActivity : AppCompatActivity() {
    private lateinit var presenter: clsCarrerasPresentador
    private lateinit var spinnerCarreras: Spinner
    private lateinit var recyclerCursos: RecyclerView
    private lateinit var btnVerRegistros: Button
    private lateinit var adapterCursos: cursosAdaptador

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        spinnerCarreras = findViewById(R.id.spnCategorias)
        recyclerCursos = findViewById(R.id.rvLista)
        btnVerRegistros = findViewById(R.id.btnVerRegistros)

        recyclerCursos.layoutManager = LinearLayoutManager(this)
        adapterCursos = cursosAdaptador(this, emptyList())
        recyclerCursos.adapter = adapterCursos

        presenter = clsCarrerasPresentador(this)
        configurarListeners()
        presenter.iniciar()
    }

    private fun configurarListeners() {
        spinnerCarreras.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                presenter.seleccionarCarrera(position)
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }
        btnVerRegistros.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                presenter.verRegistros()
            }
        })
    }

    fun mostrarCarreras(carreras: List<dataCarreras>) {
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, carreras)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerCarreras.adapter = adapter
    }

    fun mostrarCursos(cursos: List<dataCursos>) {
        adapterCursos.actualizarLista(cursos)
    }

    fun seleccionarCurso(curso: dataCursos) {
        presenter.seleccionarCurso(curso)
    }
    fun registrarseCurso(curso: dataCursos) {
        presenter.registrarseCurso(curso)
    }

    fun abrirDetalleCurso(id: Int) {
        val intent = Intent(this, DetalleCursoActivity::class.java)
        intent.putExtra("ID_CURSO", id)
        startActivity(intent)
    }
    fun abrirVerRegistros() {
        val intent = Intent(this, VerRegistrosActivity::class.java)
        startActivity(intent)
    }
    fun abrirRegistroCurso(id: Int) {
        val intent = Intent(this, RegistroCursosActivity::class.java)
        intent.putExtra("ID_CURSO", id)
        startActivity(intent)
    }

    fun mostrarError(mensaje: String) {
        Toast.makeText(this, mensaje, Toast.LENGTH_LONG).show()
    }
}