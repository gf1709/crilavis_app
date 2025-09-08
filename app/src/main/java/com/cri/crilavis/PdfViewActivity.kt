package com.cri.crilavis

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.github.barteksc.pdfviewer.PDFView

class PdfViewActivity : AppCompatActivity() {
    lateinit var pdfView: PDFView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()
        setContentView(R.layout.activity_pdf_view)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        var fileName: String = ""

        val pdfView = findViewById<PDFView>(R.id.pdfView)
        val fileType  = intent.getStringExtra("FileType")
        if (fileType!=null) {
            fileName = "99_zoll_guida_mattevi_denise.pdf"
            if (fileType == "GuidaRapida")
                fileName = "98_zoll_guida_rapida.pdf"
            else if (fileType == "Scoiattolo_Guida_Rapida")
                fileName = "4_scoiattolo.pdf"
            else if (fileType == "Pedimate_Manuale")
                fileName = "7_pedimate_manuale.pdf"
            else if (fileType == "Hytera")
                fileName = "97_radio_HYTERA_guida.pdf"
            else if (fileType == "Emma")
                fileName = "80_emmaweb.pdf"
            else if (fileType == "abcde")
                fileName = "2_abcde.pdf"
            else if (fileType == "blsd")
                fileName = "3_blsd.pdf"
        }
        else
            fileName  = intent.getStringExtra("FileName")!!.toString()


        pdfView.fromAsset(fileName).load()
    }


}