package com.cri.crilavis

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat


class AppuntiActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_appunti)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val hyteraButton = findViewById<android.widget.Button>(R.id.btnGuidaHytera)
        hyteraButton.setOnClickListener {
            val intent  = Intent(this, PdfViewActivity::class.java)
            intent.putExtra("FileType", "Hytera")
            startActivity(intent)
        }
        val checkListButton = findViewById<android.widget.Button>(R.id.btnCheckList)
        checkListButton.setOnClickListener {
            val uri = Uri.parse("https://forms.gle/PAAswQ4JDT5Ye9zH8")
            val intent = Intent(Intent.ACTION_VIEW, uri)
            startActivity(intent)
//            val intent  = Intent(this, PdfViewActivity::class.java)
//            intent.putExtra("FileType", "CheckList")
//            startActivity(intent)
        }
    }
}