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

class PdfViewActivity : AppCompatActivity(), OnPageErrorListener {
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
        pdfView.fromAsset(fileName).load()
    }

    private fun checkPdfAction(intent: Intent) {
        when (intent.getStringExtra("ViewType")) {
            "assets" -> {
                // perform action to show pdf from assets
                showPdfFromAssets("ciao.pdf")
            }
            "storage" -> {
                // perform action to show pdf from storage
            }
            "internet" -> {
                // perform action to show pdf from the internet
            }
        }
    }
    private fun showPdfFromAssets(pdfName: String) {
        pdfView.fromAsset(pdfName).load()
//        pdfView.fromAsset(pdfName)
//            .password(null) // if password protected, then write password
//            .defaultPage(0) // set the default page to open
//            .onPageError(this)
//            .load()
    }
    override fun onPageError(page: Int, t: Throwable?) {
        Log.e("PDFView", "Cannot load page " + page);
        Toast.makeText(
            this@PdfViewActivity,
            "Error at page: $page", Toast.LENGTH_LONG
        ).show()

    }

}