package com.cri.crilavis

import android.content.Intent
import android.content.res.ColorStateList
import android.graphics.Color
import android.net.Uri
import android.os.Bundle
import android.widget.ImageButton
import android.widget.LinearLayout
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipGroup


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

        val assetFiles = getAssets().list("")
        if (assetFiles != null) {
            val layoutC: ChipGroup = findViewById(R.id.riga6)
            for (assetFile in assetFiles) {
                if (assetFile.endsWith(".pdf")) {
                    val newChip = Chip(this)
                    newChip.layoutParams =
                        LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, 150)
                    newChip.text = assetFile.replace(".pdf", "")
                    newChip.chipBackgroundColor = ColorStateList.valueOf(Color.CYAN)
                    newChip.setOnClickListener {
                        Toast.makeText(
                            this@MainActivity,
                            "opening " + assetFile.replace(".pdf", "") + "...",
                            Toast.LENGTH_LONG
                        ).show()
                        val intent = Intent(this, PdfViewActivity::class.java)
                        intent.putExtra("FileName", assetFile)
                        startActivity(intent)
                    }
                    layoutC.addView(newChip)
                }
            }
        }

        val checklist_ambulanza_button = findViewById<Chip>(R.id.checklist_ambulanza)
        checklist_ambulanza_button.setOnClickListener {
            val uri = Uri.parse("https://forms.gle/PAAswQ4JDT5Ye9zH8")
            val intent = Intent(Intent.ACTION_VIEW, uri)
            startActivity(intent)
        }

        val abcdeImgButton = findViewById<ImageButton>(R.id.imageButtonabcde)
        abcdeImgButton.setOnClickListener {
            val intent  = Intent(this, PdfViewActivity::class.java)
            intent.putExtra("FileType", "abcde")
            startActivity(intent)
        }
        val blsdImgButton = findViewById<ImageButton>(R.id.imageButtonblsd)
        blsdImgButton.setOnClickListener {
            val intent  = Intent(this, PdfViewActivity::class.java)
            intent.putExtra("FileType", "blsd")
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
        val appuntiImgButton = findViewById<ImageButton>(R.id.imgButtonAppunti)
        appuntiImgButton.setOnClickListener {
            val intent  = Intent(this, AppuntiActivity::class.java)
            startActivity(intent)
        }
        val codiciGravitaImgButton = findViewById<ImageButton>(R.id.imgButtonCodiciGravita)
        codiciGravitaImgButton.setOnClickListener {
            val intent  = Intent(this, CodiciGravitaActivity::class.java)
            startActivity(intent)
        }
        val emmaWebImgButton = findViewById<ImageButton>(R.id.imgButtonEmma)
        emmaWebImgButton.setOnClickListener {
            val intent  = Intent(this, PdfViewActivity::class.java)
            intent.putExtra("FileType", "Emma")
            startActivity(intent)
        }
    }

}