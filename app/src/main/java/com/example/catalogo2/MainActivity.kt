package com.example.catalogo2

import com.example.catalogo2.databinding.ActivityMainBinding
import android.content.Intent
import android.graphics.BitmapFactory
import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.catalogo2.databinding.LectorBinding
import kotlinx.android.synthetic.main.activity_main.*
import java.util.ArrayList
import com.google.zxing.integration.android.IntentIntegrator
import kotlinx.android.synthetic.main.elemento_lista_prendas.*
import kotlinx.android.synthetic.main.lector.*
import org.imaginativeworld.whynotimagecarousel.ImageCarousel
import org.imaginativeworld.whynotimagecarousel.listener.CarouselListener
import org.imaginativeworld.whynotimagecarousel.model.CarouselItem

class MainActivity : AppCompatActivity() {

    private lateinit var binding: LectorBinding
    private val list = mutableListOf<CarouselItem>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = LectorBinding.inflate(layoutInflater)
        setContentView(binding.root)
    //inicia escaneo
        binding.btnEscaner.setOnClickListener { initScanner() }
    //inicia conexion al WS
        binding.btnBuscar.setOnClickListener {val intent = Intent(this,Lector::class.java)
            startActivity(intent)
            val input1 = txtValor.text.toString().trim()

            when {
                input1.length == 0 -> Toast.makeText(
                    this,

                    "Escana un codigo primero",
                    Toast.LENGTH_SHORT

                ).show()
                !Utils.isConnected(this@MainActivity) -> Toast.makeText(
                    this,

                    "El no hubo internet",
                    Toast.LENGTH_SHORT

                ).show()

                else -> getCitiesOfCountry().execute(input1)

            }
        }



        //Carrusel
        val carousel: ImageCarousel = findViewById(R.id.carousel)

        list.add(CarouselItem("https://c8.alamy.com/compes/t67ryj/conjunto-de-ropa-de-los-ninos-para-el-muchacho-los-pantalones-y-camisa-azul-sobre-fondo-de-madera-fotografia-en-color-horizontal-t67ryj.jpg","1"))
        list.add(CarouselItem("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSAigL11PZN-MG1-4xZfJfkvP7KU2QnxBI4Iw&usqp=CAU","2"))
        list.add(CarouselItem("https://stylesatlife.com/wp-content/uploads/2017/01/Bright-and-Dark-Colored-Blue-Jeans-with-Shades.jpg.webp","3"))
        list.add(CarouselItem("https://c8.alamy.com/compes/t67rxn/conjunto-de-ropa-de-los-ninos-para-el-muchacho-los-pantalones-y-camisa-azul-sobre-fondo-de-madera-fotografia-en-color-horizontal-t67rxn.jpg","4"))


        carousel.addData(list)

        carousel.carouselListener = object : CarouselListener {
            override fun onClick(position: Int, carouselItem: CarouselItem) {
                Toast.makeText(this@MainActivity, "Imagen: ${carouselItem.caption}", Toast.LENGTH_SHORT).show()
            }
        }

    }

//Inicia Metodo del WS

inner class getCitiesOfCountry : AsyncTask<String, String, String>() {
    //inner class getCitiesOfCountry : AsyncTask<Int, Int, String>() {  --> WSLocal Calculadora
    override fun doInBackground(vararg params: String?): String {

        val response = CallWebService().callApi(Utils.METHOD_CONS,params[0])//Construye el la petición
        Log.v("response", "response==" + response)

        // Pasaremos de la actividad actual a OtraActivity
        // Pasaremos de la actividad actual a OtraActivity

        val intent = Intent(this@MainActivity,Lector::class.java)
        var aux :String = response
        val b :Bundle = Bundle()
        b.putString("x",aux)
        intent.putExtras(b)
        startActivity(intent)


        return response //retorna el resultado
    }
}


//Regresa datos de scaner
    private fun initScanner(){
        IntentIntegrator(this).initiateScan()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        val result = IntentIntegrator.parseActivityResult(requestCode,resultCode,data)

        if(result != null){
            if(result == null)
            {
                Toast.makeText(this, "Cancelado", Toast.LENGTH_SHORT).show()
            }else{
                binding.txtValor.setText(result.contents)
            }
        }else{
            super.onActivityResult(requestCode, resultCode, data)
        }
    }

}