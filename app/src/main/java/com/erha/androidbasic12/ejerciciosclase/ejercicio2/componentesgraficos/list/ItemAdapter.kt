package com.erha.androidbasic12.ejerciciosclase.ejercicio2.componentesgraficos.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.erha.androidbasic12.R

class ItemAdapter(val list: List<ItemEntity>): RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {

    private val checkedItems = BooleanArray(list.size)

    class ItemViewHolder(view: View): RecyclerView.ViewHolder(view){

        val ivExtra = view.findViewById<ImageView>(R.id.ivExtra)
        val tvDescription = view.findViewById<TextView>(R.id.tvDescription)
        val tvPrice = view.findViewById<TextView>(R.id.tvPrice)
        val cbExtraSelected = view.findViewById<CheckBox>(R.id.cbExtraItem)

        fun render(itemEntity: ItemEntity, isChecked: Boolean) {
            tvDescription.text = itemEntity.description
            tvPrice.text = itemEntity.price.toString()

            cbExtraSelected.isChecked = isChecked
            cbExtraSelected.setOnCheckedChangeListener(){CompoundButton, isChecked ->
                if(isChecked){
                    val context = itemView.context
                    Toast.makeText(context , "Agregaste: ${itemEntity.description}", Toast.LENGTH_LONG).show()
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_extra, parent, false)
        return ItemViewHolder(view)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = list[position]
        holder.render(item, checkedItems[position])
    }


}