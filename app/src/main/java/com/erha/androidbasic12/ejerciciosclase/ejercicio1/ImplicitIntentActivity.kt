package com.erha.androidbasic12.ejerciciosclase.ejercicio1

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.erha.androidbasic12.R

class ImplicitIntentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_implicit_intent)

        val btnSend = findViewById<Button>(R.id.btnSend) //Esta es la forma de crear una variable de tipo boton para que el boton haga algo
        val btnSendurl = findViewById<Button>(R.id.btnSendUrl)

        //Esto es para detectar cuando el usuario le de click al boton y ejecutara todo lo que este dentro de los corchetes
        btnSend.setOnClickListener {
            val emailIntent = Intent(Intent.ACTION_SENDTO).apply {  //SENTO es algo que esta dentro de instancia para mandar algo
                data = Uri.parse("mailto:")
                putExtra(Intent.EXTRA_SUBJECT, "Aviso Urgente")
                putExtra(Intent.EXTRA_TEXT, "Este es un mensaje prueba de email.")
            }

            startActivity(Intent.createChooser(emailIntent,"Enviar email usando:"))   //Esto es para poder seleccionar que aplicacion usar en caso de que se tengan varias opciones(gmail, outlook)
        }
        //codigo para abrir navegador
        btnSendurl.setOnClickListener {
            val urlIntent = Intent(Intent.ACTION_VIEW, Uri.parse("http://www.facebook.com"))
            startActivity(Intent.createChooser(urlIntent, "Abrir usando:"))
        }
    }
}