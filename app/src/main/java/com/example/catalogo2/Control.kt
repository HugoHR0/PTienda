package com.example.catalogo2

import android.content.Intent
import android.graphics.drawable.Drawable
import android.os.Bundle

class Control  {
fun control (id : String): Int {
    var imagen = R.drawable.white_radius

    if ( id == "[51,")
    {
        imagen = R.drawable.pantalon_cafe_vestir
    }
    else if (id == "[52,")
    {
        imagen = R.drawable.pantalon_meczilla
    }
    else if (id == "[53,")
    {
        imagen = R.drawable.pantalon_blanco
    }
    else if (id == "[54,")
    {
        imagen = R.drawable.pantalon_gris_vestir
    }
    else if (id == "[50,")
    {
        imagen = R.drawable.pantalon_azul_formal
    }
    else if (id == "[101," )
    {
        imagen = R.drawable.camisa_amarilla
    }
    else if (id == "[102," )
    {
        imagen = R.drawable.camisa_azul
    }
    else if (id == "[103," )
    {
        imagen = R.drawable.camisa_cuadros
    }
    else if (id == "[104," )
    {
        imagen = R.drawable.camisa_rosa
    }
    else if (id == "[105," )
    {
        imagen = R.drawable.camisa_azul_cuadros
    }
    else if ( id == "[201,")
    {
        imagen = R.drawable.playera_naranja_naves
    }
    else if (id == "[202," )
    {
        imagen = R.drawable.playera_gris_rayada
    }
    else if (id == "[203," )
    {
        imagen = R.drawable.playera_azul
    }
    else if (id == "[204," )
    {
        imagen = R.drawable.playera_gris
    }

    return imagen
}

}