package com.erha.androidbasic12.ejerciciosclase.ejercicio2.actividad

import android.os.Bundle
import android.widget.Button
import android.widget.RadioGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.erha.androidbasic12.R
import com.erha.androidbasic12.ejerciciosclase.ejercicio2.actividad.list.ItemAdapter
import com.erha.androidbasic12.ejerciciosclase.ejercicio2.actividad.list.ItemEntity

class PersonalizedOrderActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.personalized_order_layout)

        val list = findViewById<RecyclerView>(R.id.rvFoodElements)
        val rbBurguers = findViewById<RadioGroup>(R.id.rgBurguerTypes)
        val btSetInfo = findViewById<Button>(R.id.btnOrder)

        val data = listOf(
            ItemEntity("Papas a la francesa medianas", 38),
            ItemEntity("Aros de cebollas", 52),
            ItemEntity("Pepinillos", 8),
            ItemEntity("Jalapeños", 8),
            ItemEntity("Catsup", 3),
            ItemEntity("Ranch", 3),
            ItemEntity("BBQ", 4)
        )

        val adapter = ItemAdapter(data)
        list.adapter = adapter

        list.layoutManager = LinearLayoutManager(this)

        rbBurguers.setOnCheckedChangeListener { radioGroup, Id ->
            val idName =when(Id){
                R.id.rbHawaiana -> "Hawaiana"
                R.id.rbDoble ->  "Doble"
                R.id.rbSencilla ->  "Sencilla"
                else -> "Desconocida"
            }
            Toast.makeText(this, "Tipo de hamburguesa = $idName", Toast.LENGTH_SHORT).show()
        }

        btSetInfo.setOnClickListener {
            //Colocar variable del checkmark aqui
            val selectedRbOption = when(rbBurguers.checkedRadioButtonId){
                R.id.rbHawaiana -> "Hawaiana"
                R.id.rbDoble ->  "Doble"
                R.id.rbSencilla ->  "Sencilla"
                else -> "Desconocida"
            }
            //Toast con datos de radiogroup
            Toast.makeText(this,"Se ha seleccionado  $selectedRbOption", Toast.LENGTH_SHORT).show()
        }

    }
}