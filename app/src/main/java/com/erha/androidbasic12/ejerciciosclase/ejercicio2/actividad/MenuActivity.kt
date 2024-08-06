package com.erha.androidbasic12.ejerciciosclase.ejercicio2.actividad

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.erha.androidbasic12.R

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //Spinner
        val data = arrayListOf("Filtrar Por:", "Entradas", "Hamburguesas", "Infantiles", "Bebidas", )
        val spinner = findViewById<Spinner>(R.id.spinner)
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, data).also {
            it.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        }

        spinner.adapter = adapter

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, view: View?, position: Int, id: Long) {
                val itemSelected = data[position]

                if(position == 0){
                    Toast.makeText(this@MenuActivity, "Item no seleccionado", Toast.LENGTH_LONG).show()
                }else{
                    Toast.makeText(this@MenuActivity, "Item seleccionado: $itemSelected", Toast.LENGTH_LONG).show()
                }
            }

            override fun onNothingSelected(p0: AdapterView<*>?){
                Toast.makeText(this@MenuActivity, "Nada seleccionado:", Toast.LENGTH_LONG).show()
            }

        }


    }
}