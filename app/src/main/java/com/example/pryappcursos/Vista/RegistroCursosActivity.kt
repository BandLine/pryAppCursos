package com.example.pryappcursos.Vista
import android.app.DatePickerDialog
import android.os.Bundle
import android.view.KeyEvent
import android.view.inputmethod.EditorInfo
import android.widget.Button
import android.widget.DatePicker
import android.widget.EditText
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.bumptech.glide.Glide
import com.example.pryappcursos.Interfaceapi.RetrofitCliente
import com.example.pryappcursos.Presentador.clsRegistroPresentador
import com.example.pryappcursos.R
import java.util.Calendar
class RegistroCursosActivity : AppCompatActivity() {
    private lateinit var presentador: clsRegistroPresentador
    private lateinit var txtInscripcion: TextView
    private lateinit var imgCurso: ImageView
    private lateinit var txtNombreCurso: TextView
    private lateinit var txtMatricula: EditText
    private lateinit var txtFecha: EditText
    private lateinit var txtCorreo: EditText
    private lateinit var btnConfirmar: Button
    private var idCurso = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_registro_cursos)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        btnConfirmar = findViewById(R.id.btnConfirmar)
        txtInscripcion = findViewById(R.id.txtInscripcion)
        imgCurso = findViewById(R.id.imgCurso)
        txtNombreCurso = findViewById(R.id.txtNombreCurso)
        txtMatricula = findViewById(R.id.txtMatricula)
        txtFecha = findViewById(R.id.txtFecha)
        txtCorreo = findViewById(R.id.txtCorreo)
        idCurso = intent.getIntExtra("ID_CURSO", 0)
        val nombre = intent.getStringExtra("NOMBRE_CURSO") ?: ""
        val imagen = intent.getStringExtra("IMAGEN_CURSO") ?: ""
        txtInscripcion.text = nombre
        txtNombreCurso.text = nombre
        val urlImagen = RetrofitCliente.BASE_URL + imagen
        Glide.with(this).load(urlImagen).placeholder(android.R.drawable.ic_menu_gallery).error(android.R.drawable.stat_notify_error).into(imgCurso)
        presentador = clsRegistroPresentador(this)
        configurarListeners()
        presentador.iniciar()
    }
    private fun configurarListeners() {
        txtMatricula.setOnEditorActionListener(this::buscarDatos)
        txtFecha.setOnClickListener { abrirCalendario() }
        btnConfirmar.setOnClickListener { presentador.registrar(idCurso, txtMatricula.text.toString(), txtCorreo.text.toString(), txtFecha.text.toString()) }
    }
    fun buscarDatos(v: TextView?, accion: Int, evento: KeyEvent?): Boolean {
        if (accion == EditorInfo.IME_ACTION_DONE) {
            presentador.buscarAlumno(txtMatricula.text.toString())
        }
        return false
    }
    private fun abrirCalendario() {
        val hoy = Calendar.getInstance()
        val calendario = DatePickerDialog(this, this::fechaSeleccionada, hoy.get(Calendar.YEAR), hoy.get(Calendar.MONTH), hoy.get(Calendar.DAY_OF_MONTH))
        calendario.show()
    }
    fun fechaSeleccionada(vista: DatePicker?, anio: Int, mes: Int, dia: Int) {
        presentador.formatearFecha(anio, mes, dia)
    }
    fun mostrarFecha(fecha: String) {
        txtFecha.setText(fecha)
    }
    fun mostrarCorreo(correo: String) {
        txtCorreo.setText(correo)
    }
    fun mostrarMensaje(mensaje: String) {
        Toast.makeText(this, mensaje, Toast.LENGTH_LONG).show()
    }
    fun cerrar() {
        finish()
    }
}