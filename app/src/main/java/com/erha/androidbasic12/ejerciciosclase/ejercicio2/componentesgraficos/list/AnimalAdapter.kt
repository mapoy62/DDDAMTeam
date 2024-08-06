package com.erha.androidbasic12.ejerciciosclase.ejercicio2.componentesgraficos.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.erha.androidbasic12.R

class AnimalAdapter(val list: List<PersonEntity>): RecyclerView.Adapter<AnimalAdapter.AnimalViewHolder>() {

    class AnimalViewHolder(view:View): RecyclerView.ViewHolder(view){

        val tvColor = view.findViewById<TextView>(R.id.tvColor)
        val ivAnimal = view.findViewById<ImageView>(R.id.ivAnimal)
        val tvAnimal = view.findViewById<TextView>(R.id.tvAnimal)

        fun render(animalEntity: PersonEntity) {
            tvAnimal.text = animalEntity.name
            tvColor.text = animalEntity.lastName
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimalViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_animal, parent, false)
        return AnimalViewHolder(view)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: AnimalViewHolder, position: Int) {
        holder.render(list[position])
    }

}