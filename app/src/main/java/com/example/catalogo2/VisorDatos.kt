package com.example.catalogo2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_visor_datos.*

class VisorDatos : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_visor_datos)
        val prenda= intent.getSerializableExtra("pren") as Prenda

        imgPrincipal.setImageResource(prenda.idPrenda)
        txtNombreEspecial.text=getString(R.string.nombre,prenda.nombre)
        txtTallaEspecial.text=getString(R.string.talla,prenda.talla)
    }
}