package com.erha.androidbasic12.ejerciciosclase.ejercicio2.componentesgraficos.list

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.erha.androidbasic12.R

class AnimalListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animal_list)

        val list = findViewById<RecyclerView>(R.id.animalList)

        /*val data = listOf(AnimalEntity("Leon", "Amarillo", ""),
            AnimalEntity("Tigre", "Naranja", ""),
            AnimalEntity("Jirafa", "Amarillo", ""),
            AnimalEntity("Armadillo", "Amarillo", ""),
            AnimalEntity("Perro", "Amarillo", ""),
            AnimalEntity("Gato", "Amarillo", ""),
            AnimalEntity("Gato", "Amarillo", ""),
            AnimalEntity("Gato", "Amarillo", ""),
            AnimalEntity("Gato", "Amarillo", ""),
            AnimalEntity("Gato", "Amarillo", ""),
            AnimalEntity("Gato", "Amarillo", "")
            )*/

        val data = listOf(PersonEntity("Luis","Hernandez", ""),
            PersonEntity("Maria","Garcia", ""),
            PersonEntity("Carlos","Martinez", ""),
            PersonEntity("Ana","Lopez", ""),
            PersonEntity("Pedro","Gonzalez", ""),
            PersonEntity("Sofia","Perez", ""),
            PersonEntity("Miguel","Sanchez", ""),
            PersonEntity("Lucia","Ramirez", ""),
            PersonEntity("Javier","Torres", ""),
            PersonEntity("Elena","Diaz", ""))


        val adapter = AnimalAdapter(data)
        list.adapter = adapter
        list.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        //list.layoutManager = GridLayoutManager(this, 2)

    }
}