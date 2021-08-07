package com.example.catalogo2

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import java.util.ArrayList
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*


class Lector() : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        RVCatalogo.layoutManager = LinearLayoutManager(this)
        RVCatalogo.adapter = AdaptadorPrendas(generarDatosPrueba(), this)




        //Log.v("response", "response desde lector ==" + aux)

    }

        private fun generarDatosPrueba(): ArrayList<Prenda> {

            var bundle = intent.extras
            var aux = bundle?.getString("x")

            fun String.toWords() = trim().splitToSequence(' ').filter { it.isNotEmpty() }.toList()
            var aux3 = aux?.toWords()


        var lista= ArrayList<Prenda>()
        lista.add(Prenda(R.drawable.camisa_amarilla,aux3?.get(1).toString(), aux3?.get(2).toString(),aux3?.get(3).toString(),aux3?.get(4).toString(),aux3?.get(5).toString(),aux3?.get(6).toString()))
        /*lista.add(Prenda(R.drawable.camisa_azul,"Camisa azul","Talla 38 a 42" ))
        lista.add(Prenda(R.drawable.camisa_cuadros,"Camisa cuadros","Talla 36 a 40" ))
        lista.add(Prenda(R.drawable.camisa_gris,"Camisa gris","Talla 38" ))
        lista.add(Prenda(R.drawable.camisa_rosa,"Camisa rosa","Talla 40" ))*/
        return lista
    }

}