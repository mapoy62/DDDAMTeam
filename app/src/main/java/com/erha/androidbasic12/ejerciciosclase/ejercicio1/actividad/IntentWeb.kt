package com.erha.androidbasic12.ejerciciosclase.ejercicio1.actividad

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.erha.androidbasic12.R

class IntentWeb : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent_web)

        val btnSendurl = findViewById<Button>(R.id.btnSendUrl)
        
        //codigo para abrir navegador
        btnSendurl.setOnClickListener {
            val urlIntent = Intent(Intent.ACTION_VIEW, Uri.parse("http://www.facebook.com"))
            startActivity(Intent.createChooser(urlIntent, "Abrir usando:"))
        }
    }
}