package com.example.pryappcursos.Adaptador
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.pryappcursos.Interfaceapi.RetrofitCliente
import com.example.pryappcursos.Modelo.dataEstadoCurso
import com.example.pryappcursos.R
class AdaptadorEstadoInscripciones(private var listaCursos: List<dataEstadoCurso>) : RecyclerView.Adapter<AdaptadorEstadoInscripciones.EstadoViewHolder>() {
    class EstadoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgCurso: ImageView = itemView.findViewById(R.id.imgCurso)
        val txtNombreCurso: TextView = itemView.findViewById(R.id.txtNombreCurso)
        val pbInscripciones: ProgressBar = itemView.findViewById(R.id.pbInscripciones)
        val txtInscritos: TextView = itemView.findViewById(R.id.txtInscritos)
        val txtCupo: TextView = itemView.findViewById(R.id.txtCupo)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EstadoViewHolder {
        val vista = LayoutInflater.from(parent.context).inflate(R.layout.item_ver_cursos, parent, false)
        return EstadoViewHolder(vista)
    }
    override fun onBindViewHolder(holder: EstadoViewHolder, position: Int) {
        val curso = listaCursos[position]

        holder.txtNombreCurso.text = curso.nombre
        holder.txtInscritos.text = curso.inscritos.toString() + " inscritos"
        holder.txtCupo.text = curso.cupo.toString() + " total"

        holder.pbInscripciones.max = curso.cupo
        holder.pbInscripciones.progress = curso.inscritos
        if (curso.inscritos >= curso.cupo) {
            holder.pbInscripciones.progressTintList = holder.itemView.context.getColorStateList(R.color.verde)
        } else {
            holder.pbInscripciones.progressTintList = holder.itemView.context.getColorStateList(R.color.azul)
        }
        val urlImagen = RetrofitCliente.BASE_URL + curso.imagen_url
        Glide.with(holder.itemView.context).load(urlImagen).placeholder(android.R.drawable.ic_menu_gallery).error(android.R.drawable.stat_notify_error).into(holder.imgCurso)
    }
    override fun getItemCount(): Int {
        return listaCursos.size
    }
    fun actualizarLista(nuevaLista: List<dataEstadoCurso>) {
        listaCursos = nuevaLista
        notifyDataSetChanged()
    }
}