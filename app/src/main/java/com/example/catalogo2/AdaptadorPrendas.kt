package com.example.catalogo2

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import java.util.ArrayList
import kotlinx.android.synthetic.main.elemento_lista_prendas.view.*

class AdaptadorPrendas(private var lista: ArrayList<Prenda>, private var contexto: Context):RecyclerView.Adapter<AdaptadorPrendas.ViewHolder>() {

    class ViewHolder(var vista: View, var contexto: Context): RecyclerView.ViewHolder(vista){
        fun bind(prendas: Prenda){
            vista.ImgPrenda.setImageResource(prendas.idPrenda)
            vista.txtNombre.text = prendas.nombre
            vista.txtTallas.text = prendas.talla
            vista.ImgPrenda.setOnClickListener{

            }
            vista.setOnClickListener{
                contexto.startActivity(Intent(contexto, VisorDatos::class.java).putExtra("pren",prendas))
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.elemento_lista_prendas, parent, false), contexto)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(lista[position])
    }

    override fun getItemCount(): Int {
        return  lista.size
    }
}