package com.example.catalogo2

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat.startActivity
import com.example.catalogo2.databinding.LectorBinding
import kotlinx.android.synthetic.main.lector.*
import java.util.ArrayList
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*


class Lector : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        RVCatalogo.layoutManager = LinearLayoutManager(this)
        RVCatalogo.adapter = AdaptadorPrendas(generarDatosPrueba(), this)

    }

        private fun generarDatosPrueba(): ArrayList<Prenda> {
        var lista= ArrayList<Prenda>()
        lista.add(Prenda(R.drawable.camisa_amarilla,"Camisa amarilla","Talla 36 a 42" ))
        lista.add(Prenda(R.drawable.camisa_azul,"Camisa azul","Talla 38 a 42" ))
        lista.add(Prenda(R.drawable.camisa_cuadros,"Camisa cuadros","Talla 36 a 40" ))
        lista.add(Prenda(R.drawable.camisa_gris,"Camisa gris","Talla 38" ))
        lista.add(Prenda(R.drawable.camisa_rosa,"Camisa rosa","Talla 40" ))
        return lista
    }

}