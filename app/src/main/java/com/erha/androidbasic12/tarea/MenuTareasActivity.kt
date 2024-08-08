package com.erha.androidbasic12.tarea

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.erha.androidbasic12.R
import com.erha.androidbasic12.ejerciciosclase.ejercicio2.actividad.MenuActivity
import com.erha.androidbasic12.ejerciciosclase.ejercicio2.actividad.PersonalizedOrderActivity
import com.erha.androidbasic12.tarea.TEmilioHerrera.EmilioTareaActivity

class MenuTareasActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_tareas)


        val btnSendActivity = findViewById<Button>(R.id.btnEmilio)

        btnSendActivity.setOnClickListener {
            val intent = Intent(this, EmilioTareaActivity::class.java).apply {
            }
            startActivity(intent)
        }


    }
}