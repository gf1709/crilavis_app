package com.cri.crilavis

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.github.barteksc.pdfviewer.PDFView
import com.github.barteksc.pdfviewer.listener.OnPageErrorListener

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
        val pdfView = findViewById<PDFView>(R.id.pdfView)
        val fileType  = intent.getStringExtra("FileType")
        var fileName = "zoll_Mattevi_Denise.pdf"
        if (fileType=="GuidaRapida")
            fileName="zoll_guida_rapida.pdf"
        else if (fileType=="Scoiattolo_Guida_Rapida")
            fileName="sedia_scendiscale_meber_guida_rapida.pdf"
        else if (fileType=="Pedimate_Manuale")
            fileName="pedimate_Manuale_Uso.pdf"
        else if (fileType=="Hytera")
            fileName="Radio_HYTERA_guida_rapida.pdf"

        pdfView.fromAsset(fileName).load()
    }


}