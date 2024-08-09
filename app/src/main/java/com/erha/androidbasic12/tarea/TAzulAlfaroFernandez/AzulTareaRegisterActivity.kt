package com.erha.androidbasic12.tarea.TAzulAlfaroFernandez
//Mov
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
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.erha.androidbasic12.R


class AzulTareaRegisterActivity : AppCompatActivity() {
    private val register = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        if (result.resultCode == RESULT_OK) {
            val isCorrect = result.data?.getBooleanExtra("EXTRA_IS_CORRECT_KEY", false)
            if (isCorrect == true) {
                onBackPressedDispatcher.onBackPressed()
            } else {
                Toast.makeText(this, "resultfrom extra = $isCorrect", Toast.LENGTH_SHORT).show()
            }
        } else {
            Toast.makeText(this, "Information not available", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_azul_tarea_register)

        //Variables
        val etRegName = findViewById<EditText>(R.id.etRegName)
        val etRegLastName = findViewById<EditText>(R.id.etRegLastName)
        val etRegMailAddress = findViewById<EditText>(R.id.etRegEmailAddress)
        val etRegPassword = findViewById<EditText>(R.id.etRegPassword)
        val spinnerGender = findViewById<Spinner>(R.id.spinnerGender)
        val btnCreateAccount = findViewById<Button>(R.id.btnRegCreateAccount)
        val cbTermsConditions = findViewById<CheckBox>(R.id.cbTermConditions)
        val genderdata = arrayListOf("Select an option","Female","Male","Prefer not to say")
        //

        //Spinner
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, genderdata).also {
            it.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        }
        spinnerGender.adapter = adapter
        spinnerGender.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, view: View?, position: Int, id: Long) {
                val itemSelected = genderdata[position]
                Toast.makeText(this@AzulTareaRegisterActivity,"Selected: $itemSelected",Toast.LENGTH_SHORT).show()
            }
            override fun onNothingSelected(p0: AdapterView<*>?) {}
        }

        //Registro de datos por medio de edit text

        //Primero decirle si le faltó algun dato en particular
        //True si alguno de los campos esta vacio. Checked false si esta vacio.
        val conditionsmet = arrayListOf(false, false, false, false, false, false)
        conditionsmet[0]=etRegName.text.toString().isEmpty()
        conditionsmet[1]=etRegLastName.text.toString().isEmpty()
        conditionsmet[2]=etRegMailAddress.text.toString().isEmpty()
        conditionsmet[3]=cbTermsConditions.isChecked
        conditionsmet[4]=etRegPassword.text.toString().isEmpty()
        if(spinnerGender.selectedItemPosition == 0)
            conditionsmet[5]= true
        //aqui
        btnCreateAccount.setOnClickListener {
        val selectedGender = spinnerGender.selectedItem.toString()
        if(etRegName.text.toString().isEmpty() || etRegLastName.text.toString().isEmpty() || etRegMailAddress.text.toString().isEmpty() || !cbTermsConditions.isChecked || etRegPassword.text.toString().isEmpty() || spinnerGender.selectedItemPosition == 0){
            when{
                etRegName.text.toString().isEmpty() -> Toast.makeText(this,"Please write your name",Toast.LENGTH_SHORT).show()
                etRegLastName.text.toString().isEmpty() -> Toast.makeText(this,"Please write your last name",Toast.LENGTH_SHORT).show()
                etRegMailAddress.text.toString().isEmpty() -> Toast.makeText(this,"Please write your email address",Toast.LENGTH_SHORT).show()
                spinnerGender.selectedItemPosition == 0 -> Toast.makeText(this,"Please select your gender",Toast.LENGTH_SHORT).show()
                etRegPassword.text.toString().isEmpty()-> Toast.makeText(this,"Please write your password",Toast.LENGTH_SHORT).show()
                !cbTermsConditions.isChecked -> Toast.makeText(this,"Please read the Terms and Conditions",Toast.LENGTH_SHORT).show()
                else -> Toast.makeText(this,"Thank you",Toast.LENGTH_SHORT).show()
            }
        }else {
            if (etRegName.text.toString().isNotEmpty() && etRegLastName.text.toString().isNotEmpty() && etRegMailAddress.text.toString().isNotEmpty() && cbTermsConditions.isChecked && etRegPassword.text.toString().isNotEmpty() && spinnerGender.selectedItemPosition != 0){
                    val intent = Intent(this, AzulIntentActivity::class.java).apply {
                        putExtra("EXTRA_NAME_KEY", etRegName.text.toString())
                        putExtra("EXTRA_LASTNAME_KEY", etRegLastName.text.toString())
                        putExtra("EXTRA_EMAIL_KEY", etRegMailAddress.text.toString())
                        putExtra("EXTRA_PASSWORD_KEY", etRegPassword.text.toString())
                        putExtra("EXTRA_GENDER_KEY", selectedGender)
                    }
                    register.launch(intent)
                }
            }
        }
        // aqui
    }
}