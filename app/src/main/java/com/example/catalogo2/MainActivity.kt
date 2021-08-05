package com.example.catalogo2

import com.example.catalogo2.databinding.ActivityMainBinding
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.catalogo2.databinding.LectorBinding
import kotlinx.android.synthetic.main.activity_main.*
import java.util.ArrayList
import com.google.zxing.integration.android.IntentIntegrator
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

        binding.btnEscaner.setOnClickListener { initScanner() }

        binding.btnBuscar.setOnClickListener{val intent = Intent(this,Lector::class.java)
            startActivity(intent)}

        //Carrusel
        val carousel: ImageCarousel = findViewById(R.id.carousel)

        list.add(CarouselItem("https://st4.depositphotos.com/5857850/24567/v/600/depositphotos_245672022-stock-illustration-synthwave-retro-futuristic-landscape-with.jpg","1"))
        list.add(CarouselItem("https://www.crushpixel.com/big-static14/preview4/retro-styled-futuristic-landscape-with-1654535.jpg","2"))
        list.add(CarouselItem("https://image.freepik.com/vector-gratis/fondo-paisaje-futurista-estilo-retro_52683-17906.jpg","3"))
        list.add(CarouselItem("https://image.freepik.com/vector-gratis/fondo-paisaje-futurista-estilo-retro_23-2148254281.jpg","4"))
        list.add(CarouselItem("https://image.freepik.com/vector-gratis/fondo-paisaje-retro-futurista-sol_52683-19326.jpg","5"))

        carousel.addData(list)

        carousel.carouselListener = object : CarouselListener {
            override fun onClick(position: Int, carouselItem: CarouselItem) {
                Toast.makeText(this@MainActivity, "Imagen: ${carouselItem.caption}", Toast.LENGTH_SHORT).show()
            }
        }

    }



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