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
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pryappcursos.Adaptador.cursosAdaptador
import com.example.pryappcursos.Modelo.dataCarreras
import com.example.pryappcursos.Modelo.dataCursos
import com.example.pryappcursos.Presentador.clsCarrerasPresentador
import com.example.pryappcursos.R
class MainActivity : AppCompatActivity() {
    private lateinit var presentador: clsCarrerasPresentador
    private lateinit var spnCarreras: Spinner
    private lateinit var rvCursos: RecyclerView
    private lateinit var btnVerRegistros: Button
    private lateinit var adaptadorCursos: cursosAdaptador
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        spnCarreras = findViewById(R.id.spnCategorias)
        rvCursos = findViewById(R.id.rvLista)
        btnVerRegistros = findViewById(R.id.btnVerRegistros)
        rvCursos.layoutManager = GridLayoutManager(this, 2)
        adaptadorCursos = cursosAdaptador(this, emptyList())
        rvCursos.adapter = adaptadorCursos
        presentador = clsCarrerasPresentador(this)
        configurarListeners()
        presentador.iniciar()
    }
    private fun configurarListeners() {
        spnCarreras.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                presentador.seleccionarCarrera(position)
            }
            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }
        btnVerRegistros.setOnClickListener { presentador.verRegistros() }
    }
    fun mostrarCarreras(carreras: List<dataCarreras>) {
        val adaptador = ArrayAdapter(this, android.R.layout.simple_spinner_item, carreras)
        adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spnCarreras.adapter = adaptador
    }
    fun mostrarCursos(cursos: List<dataCursos>) {
        adaptadorCursos.actualizarLista(cursos)
    }
    fun verDetalle(curso: dataCursos) {
        presentador.verDetalle(curso)
    }
    fun registrarse(curso: dataCursos) {
        presentador.registrarse(curso)
    }
    fun abrirDetalleCurso(idCurso: Int) {
        val intent = Intent(this, DetalleCursoActivity::class.java)
        intent.putExtra("ID_CURSO", idCurso)
        startActivity(intent)
    }
    fun abrirRegistro(idCurso: Int, nombre: String, imagen: String) {
        val intent = Intent(this, RegistroCursosActivity::class.java)
        intent.putExtra("ID_CURSO", idCurso)
        intent.putExtra("NOMBRE_CURSO", nombre)
        intent.putExtra("IMAGEN_CURSO", imagen)
        startActivity(intent)
    }
    fun abrirVerRegistros() {
        val intent = Intent(this, VerRegistrosActivity::class.java)
        startActivity(intent)
    }
    fun mostrarError(mensaje: String) {
        Toast.makeText(this, mensaje, Toast.LENGTH_LONG).show()
    }
}
