package com.example.pryappcursos.Adaptador
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.pryappcursos.Interfaceapi.RetrofitCliente
import com.example.pryappcursos.Modelo.dataCursos
import com.example.pryappcursos.R
import com.example.pryappcursos.Vista.MainActivity
class cursosAdaptador(private val activity: MainActivity, private var listaCursos: List<dataCursos>) : RecyclerView.Adapter<cursosAdaptador.CursoViewHolder>() {
    class CursoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgCurso: ImageView = itemView.findViewById(R.id.imgCurso)
        val txtNombreCurso: TextView = itemView.findViewById(R.id.txtNombreCurso)
        val txtEspacio: TextView = itemView.findViewById(R.id.txtEspacio)
        val btnVerDetalle: Button = itemView.findViewById(R.id.btnVerDetalle)
        val btnRegistrarse: Button = itemView.findViewById(R.id.btnRegistrarse)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CursoViewHolder {
        val vista = LayoutInflater.from(parent.context).inflate(R.layout.item_curso, parent, false)
        return CursoViewHolder(vista)
    }
    override fun onBindViewHolder(holder: CursoViewHolder, position: Int) {
        val curso = listaCursos[position]
        holder.txtNombreCurso.text = curso.nombre
        holder.txtEspacio.text = curso.espacio
        val urlImagen = RetrofitCliente.BASE_URL + curso.imagen_url
        Glide.with(holder.itemView.context).load(urlImagen).placeholder(android.R.drawable.ic_menu_gallery).error(android.R.drawable.stat_notify_error).into(holder.imgCurso)
        holder.btnVerDetalle.setOnClickListener { activity.verDetalle(curso) }
        holder.btnRegistrarse.setOnClickListener { activity.registrarse(curso) }
    }
    override fun getItemCount(): Int {
        return listaCursos.size
    }
    fun actualizarLista(nuevaLista: List<dataCursos>) {
        listaCursos = nuevaLista
        notifyDataSetChanged()
    }
}
