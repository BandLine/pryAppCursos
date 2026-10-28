package com.example.pryappcursos.Adaptador

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.pryappcursos.Modelo.dataCursos
import com.example.pryappcursos.R
import com.example.pryappcursos.Vista.MainActivity

class cursosAdaptador(
    private val activity: MainActivity,
    private var listaCursos: List<dataCursos>
) : RecyclerView.Adapter<cursosAdaptador.CursoViewHolder>() {

    class CursoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvNombre: TextView = itemView.findViewById(R.id.txtNombreCurso)
        val tvSalon: TextView = itemView.findViewById(R.id.txtSalon)
        val imgCurso: ImageView = itemView.findViewById(R.id.imgCurso)
        val btnVerDetalle: Button = itemView.findViewById(R.id.btnVerDetalle)
        val btnRegistrarse: Button = itemView.findViewById(R.id.btnRegistrarse)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CursoViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_curso, parent, false)
        return CursoViewHolder(view)
    }

    override fun onBindViewHolder(holder: CursoViewHolder, position: Int) {
        val curso = listaCursos[position]
        holder.tvNombre.text = curso.nombre
        holder.tvSalon.text = "Salon: " + curso.Salon

        val baseUrl = "http://10.255.134.130/cursos_api/"
        val urlImagenCompleta = baseUrl + curso.imagen_url

        Glide.with(holder.itemView.context)
            .load(urlImagenCompleta)
            .placeholder(android.R.drawable.ic_menu_gallery)
            .error(android.R.drawable.stat_notify_error)
            .into(holder.imgCurso)

        holder.itemView.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                activity.seleccionarCurso(curso)
            }
        })

        holder.btnVerDetalle.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                activity.seleccionarCurso(curso)
            }
        })

        holder.btnRegistrarse.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                activity.registrarseCurso(curso)
            }
        })

    }

    override fun getItemCount(): Int {
        return listaCursos.size
    }

    fun actualizarLista(nuevaLista: List<dataCursos>) {
        listaCursos = nuevaLista
        notifyDataSetChanged()
    }
}
