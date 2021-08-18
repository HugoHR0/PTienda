package com.example.catalogo2

import android.content.Context
import android.content.Intent
import android.graphics.BitmapFactory
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.elemento_lista_prendas.*
import kotlinx.android.synthetic.main.elemento_lista_prendas.view.*
import java.io.InputStream
import java.util.*

class AdaptadorPrendas(private var lista: ArrayList<Prenda>, private var contexto: Context):RecyclerView.Adapter<AdaptadorPrendas.ViewHolder>() {

    class ViewHolder(var vista: View, var contexto: Context): RecyclerView.ViewHolder(vista){
        fun bind(prendas: Prenda){
//Vista resumida de los datos
            vista.ImgPrenda.setImageResource(prendas.idPrenda)


            vista.txtNombre.text = "Nombre: " + prendas.nombre
            vista.txtTallas.text = "Talla : " + prendas.talla

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