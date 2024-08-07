package com.erha.androidbasic12.ejerciciosclase.ejercicio2.actividad

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.erha.androidbasic12.R

class NavegacionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_navegacion)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btnSendActivity = findViewById<Button>(R.id.btnMenu)


        btnSendActivity.setOnClickListener {
            val intent = Intent(this, MenuActivity::class.java).apply {
            }
            startActivity(intent)
        }

        val btnSendActivity3 = findViewById<Button>(R.id.btnPersonalizacion)


        btnSendActivity3.setOnClickListener {
            val intent = Intent(this, PersonalizedOrderActivity::class.java).apply {
            }
            startActivity(intent)
        }
    }
}