package com.erha.androidbasic12.ejerciciosclase.ejercicio1.actividad

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.erha.androidbasic12.R

class Actividad2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_actividad2)

        val labelName = findViewById<TextView>(R.id.labelName)
        val btnReturn = findViewById<Button>(R.id.btnReturn)
        val labelIntegrantes = findViewById<TextView>(R.id.labelIntegrantes)
        val labelEdades = findViewById<TextView>(R.id.labelEdades)

        intent.extras?.let {
            if (it.containsKey("EXTRA_NAME_KEY")) {
                val name = it.getString("EXTRA_NAME_KEY", "")
                labelName.text = name
                //Toast.makeText(this, "Mi nombre es: $name", Toast.LENGTH_SHORT).show()
            }
            if (it.containsKey("EXTRA_MEMBERS_KEY")) {
                val integ = it.getString("EXTRA_MEMBERS_KEY", "")
                labelIntegrantes.text = integ
                //Toast.makeText(this, "Mi nombre es: $name", Toast.LENGTH_SHORT).show()
            }
            if (it.containsKey("EXTRA_EDADES_KEY")) {
                val edades = it.getString("EXTRA_EDADES_KEY", "")
                labelEdades.text = edades
                //Toast.makeText(this, "Mi nombre es: $name", Toast.LENGTH_SHORT).show()
            }


        }
        btnReturn.setOnClickListener {
            val resultIntent = Intent().apply {
                putExtra("EXTRA_IS_CORRECT_KEY", true)
            }

            setResult(RESULT_OK, resultIntent)
            finish()
        }
    }
}