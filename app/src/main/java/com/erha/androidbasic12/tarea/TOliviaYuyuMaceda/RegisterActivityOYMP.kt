package com.erha.androidbasic12.tarea.TOliviaYuyuMaceda

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.Spinner
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.erha.androidbasic12.R

class RegisterActivityOYMP : AppCompatActivity() {

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
        setContentView(R.layout.activity_register_oymp)

        //Reference to components
        val etName = findViewById<EditText>(R.id.etName)
        val etLastName = findViewById<EditText>(R.id.etLastName)
        val etEmail = findViewById<EditText>(R.id.etEmail)
        val etPwd = findViewById<EditText>(R.id.etPassword)
        val rgSex = findViewById<RadioGroup>(R.id.rgSex)
        val spinner = findViewById<Spinner>(R.id.spinner)
        val cbTerms = findViewById<CheckBox>(R.id.cbTerms)
        val btnRegister = findViewById<Button>(R.id.btRegister)
        var selectedSex = ""

        //RADIOGROUP
        rgSex.setOnCheckedChangeListener{_, id ->
            selectedSex = when(id){
                R.id.rbWoman -> {
                    "Woman"
                }
                R.id.rbMan -> {
                    "Man"
                }
                else -> "Other / PreferNotSay"
            }
            Toast.makeText(this, "CheckedId: $selectedSex", Toast.LENGTH_SHORT).show()
        }

        //SPINNER
        val data = arrayListOf("Select Country","Mexico","Colombia", "Brazil","Argentina", "Chile", "Venezuela")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, data)
            .also {
                it.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            }
        spinner.adapter = adapter

        btnRegister.setOnClickListener {
            val name = etName.text.toString().trim()
            val lastName = etLastName.text.toString().trim()
            val email = etEmail.text.toString().trim()
            val password = etPwd.text.toString().trim()
            val selectedCountry = spinner.selectedItem.toString()
            val selectedTerms = cbTerms.isChecked

            // Validar que no estén vacíos
            when {
                name.isEmpty() -> {
                    etName.error = "Name is required"
                    etName.requestFocus()
                }
                lastName.isEmpty() -> {
                    etLastName.error = "Last Name is required"
                    etLastName.requestFocus()
                }
                email.isEmpty() -> {
                    etEmail.error = "Email is required"
                    etEmail.requestFocus()
                }
                (password.isEmpty() || password.length < 8) -> {
                    etPwd.error = "Must be at least 8 characters"
                    etPwd.requestFocus()
                }
                selectedSex.isEmpty() -> {
                    Toast.makeText(this, "Please select your gender", Toast.LENGTH_SHORT).show()
                    rgSex.requestFocus()
                }
                selectedCountry == "Select Country" -> {
                    Toast.makeText(this, "Please select your country", Toast.LENGTH_SHORT).show()
                    spinner.requestFocus()
                }
                !selectedTerms -> {
                    Toast.makeText(this, "Please accept our Terms and Conditions c:", Toast.LENGTH_SHORT).show()
                }

                else -> {
                    Toast.makeText(this, "All fields are filled correctly", Toast.LENGTH_SHORT).show()
                    // Envíamos los dayos al segundo intend
                    val intent = Intent(this, RegisterIntentActivityOYMP::class.java).apply {
                        putExtra("EXTRA_NAME_KEY", name)
                        putExtra("EXTRA_LAST_NAME_KEY", lastName)
                        putExtra("EXTRA_EMAIL_KEY", email)
                        putExtra("EXTRA_PASSWORD_KEY", password)
                        putExtra("EXTRA_SEX_KEY", selectedSex)
                        putExtra("EXTRA_COUNTRY_KEY", selectedCountry)
                    }
                    register.launch(intent)
                }
            }
        }
    }
}