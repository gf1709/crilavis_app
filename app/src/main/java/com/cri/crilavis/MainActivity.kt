package com.cri.crilavis

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val abcdeImgButton = findViewById<ImageButton>(R.id.imageButtonabcde)
        abcdeImgButton.setOnClickListener {
            val intent  = Intent(this, AbcdeActivity::class.java)
            startActivity(intent)
        }
        val blsdImgButton = findViewById<ImageButton>(R.id.imageButtonblsd)
        blsdImgButton.setOnClickListener {
            val intent  = Intent(this, BlsdActivity::class.java)
            startActivity(intent)
        }
        val zollImgButton = findViewById<ImageButton>(R.id.imageButtonzoll)
        zollImgButton.setOnClickListener {
            val intent  = Intent(this, ZollActivity::class.java)
            startActivity(intent)
        }

        val cardiopaticaImgButton = findViewById<ImageButton>(R.id.imgButtonCardiopatica)
        cardiopaticaImgButton.setOnClickListener {
            val intent  = Intent(this, CardiopaticaActivity::class.java)
            startActivity(intent)
        }
        val scoiattoloImgButton = findViewById<ImageButton>(R.id.imgButtonScoiattolo)
        scoiattoloImgButton.setOnClickListener {
            val intent  = Intent(this, PdfViewActivity::class.java)
            intent.putExtra("FileType", "Scoiattolo_Guida_Rapida")
            startActivity(intent)
        }
        val pedimateImgButton = findViewById<ImageButton>(R.id.imgButtonPedimate)
        pedimateImgButton.setOnClickListener {
            val intent  = Intent(this, PdfViewActivity::class.java)
            intent.putExtra("FileType", "Pedimate_Manuale")
            startActivity(intent)
        }

    }

}