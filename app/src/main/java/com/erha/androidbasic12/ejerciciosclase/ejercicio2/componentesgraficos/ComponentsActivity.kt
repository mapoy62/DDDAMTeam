package com.erha.androidbasic12.ejerciciosclase.ejercicio2.componentesgraficos

import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.Spinner
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.erha.androidbasic12.R
class ComponentsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_components)

        val cbCreditCard = findViewById<CheckBox>(R.id.cbCreditCard)
        val btGetInfo = findViewById<Button>(R.id.btGetInfo)
        val rgSex = findViewById<RadioGroup>(R.id.rgSex)
        val spinner = findViewById<Spinner>(R.id.spinner)
        val etName = findViewById<EditText>(R.id.etName)

        cbCreditCard.setOnCheckedChangeListener { compoundButton, isChecked ->
            if (isChecked){
                rgSex.visibility = View.GONE
            }else{
                rgSex.visibility = View.VISIBLE
            }
            Toast.makeText(this, "isChecked = $isChecked", Toast.LENGTH_SHORT).show()
        }

        rgSex.setOnCheckedChangeListener { radioGroup, id ->
            val idName = when(id){
                R.id.rbWoman ->{
                    "Mujer"
                }
                R.id.rbMen ->{
                    "Hombre"
                }
                else -> "Opcion Desconocida"
            }

            Toast.makeText(this, "CheckedId = $idName", Toast.LENGTH_SHORT).show()
        }

        btGetInfo.setOnClickListener {
            val cbStatus = cbCreditCard.isChecked
            val itemSpinnerSelected = spinner.selectedItem
            val selectedRgOption = when(rgSex.checkedRadioButtonId){
                R.id.rbMen -> "H"
                R.id.rbWoman -> "M"
                else -> "D"
            }

    //Validacion para una entrada de texto
            if (etName.text.toString().isNotEmpty()){
                Toast.makeText(this, "isChecked = $cbStatus y checkedId = $selectedRgOption y selectedSpinnerItem = $itemSpinnerSelected, name = ${etName.text.toString()}", Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(this, "Debes ingresar tu nombre", Toast.LENGTH_SHORT).show()
            }

        }

        //Spinner
        val data = arrayListOf("No seleccion", "Mexico", "Colombia", "Canada", "Argentina", "Dinamarca", "Venezuela", "Espana")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, data).also {
            it.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        }

        spinner.adapter = adapter

        spinner.onItemSelectedListener = object :OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, view: View?, position: Int, id: Long) {
                val itemSelected = data[position]

                if(position == 0){
                    Toast.makeText(this@ComponentsActivity, "Item no seleccionado", Toast.LENGTH_LONG).show()
                }else{
                    Toast.makeText(this@ComponentsActivity, "Item seleccionado: $itemSelected", Toast.LENGTH_LONG).show()
                }
            }

            override fun onNothingSelected(p0: AdapterView<*>?){
                Toast.makeText(this@ComponentsActivity, "Nada seleccionado:", Toast.LENGTH_LONG).show()
            }

        }


    }
}