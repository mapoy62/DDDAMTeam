package com.erha.androidbasic12.tarea.TEmilioHerrera

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.erha.androidbasic12.R

class EmilioTareaActivity : AppCompatActivity() {
    private val register = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        if (result.resultCode == RESULT_OK) {
            val isCorrect = result.data?.getBooleanExtra("EXTRA_IS_CORRECT_KEY", false)
            if (isCorrect == true) {
                onBackPressedDispatcher.onBackPressed()
            } else {
                Toast.makeText(this, "resultExtra= $isCorrect", Toast.LENGTH_SHORT).show()
            }
        } else {
            Toast.makeText(this, "CANCELLED", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tarea_emilio)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val data = arrayListOf("Sexo:", "Hombre", "Mujer")
        val spinner = findViewById<Spinner>(R.id.spinner)
        val etName = findViewById<EditText>(R.id.etNombre)
        val etApellido = findViewById<EditText>(R.id.etApellido)
        val etEmail = findViewById<EditText>(R.id.etEmail)
        val etPassword = findViewById<EditText>(R.id.etPassword)
        val cbTerminos = findViewById<CheckBox>(R.id.cbTerminos)
        val btGetInfo = findViewById<Button>(R.id.btRegistrar)
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, data).also {
            it.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        }

        btGetInfo.setOnClickListener {

            val selectedGender = spinner.selectedItem.toString()

            // Validación para una entrada de texto
            if (etName.text.toString().isNotEmpty() && etApellido.text.toString().isNotEmpty() && etEmail.text.toString().isNotEmpty() && etPassword.text.toString().isNotEmpty()) {
                if (cbTerminos.isChecked) {
                    if (spinner.selectedItemPosition != 0) {
                        val intent = Intent(this, IntentEmilioActivity::class.java).apply {
                            putExtra("EXTRA_NAME_KEY", etName.text.toString())
                            putExtra("EXTRA_LASTNAME_KEY", etApellido.text.toString())
                            putExtra("EXTRA_EMAIL_KEY", etEmail.text.toString())
                            putExtra("EXTRA_PASSWORD_KEY", etPassword.text.toString())
                            putExtra("EXTRA_GENDER_KEY", selectedGender.toString())
                        }
                        register.launch(intent)
                    } else {
                        Toast.makeText(this, "Elige un sexo valido", Toast.LENGTH_SHORT).show()
                    }
                } else {
                    Toast.makeText(this, "Por favor acepta los Terminos", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "Debes ingresar tus datos", Toast.LENGTH_SHORT).show()
            }
        }

        spinner.adapter = adapter

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, view: View?, position: Int, id: Long) {
                val itemSelected = data[position]
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {}
        }
    }
}
