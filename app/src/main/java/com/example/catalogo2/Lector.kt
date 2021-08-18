package com.example.catalogo2

import android.graphics.BitmapFactory
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_visor_datos.*
import kotlinx.android.synthetic.main.elemento_lista_prendas.*
import java.util.*


class Lector() : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        RVCatalogo.layoutManager = LinearLayoutManager(this)
        RVCatalogo.adapter = AdaptadorPrendas(generarDatosPrueba(), this)


    }

        private fun generarDatosPrueba(): ArrayList<Prenda> {
//Recibe el response del Metodo del WS

            var bundle = intent.extras
            var aux = bundle?.getString("x")
            var imagen = R.drawable.white_radius
//Divide el response
            fun String.toWords() = trim().splitToSequence(' ').filter { it.isNotEmpty() }.toList()
            var aux3 = aux?.toWords()
            var id = aux3?.get(0).toString()
//Control de imagenes
            imagen = Control().control(id)

//Envio de datos
        var lista= ArrayList<Prenda>()
        lista.add(Prenda(imagen,aux3?.get(1).toString(), aux3?.get(2).toString(),aux3?.get(3).toString(),aux3?.get(4).toString(),aux3?.get(5).toString()))
        return lista
    }

}