package com.erha.androidbasic12.tarea.TAzulAlfaroFernandez

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.erha.androidbasic12.R
import com.erha.androidbasic12.tarea.MenuTareasActivity


class AzulIntentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_azul_intent)


        //Variables de los text view
        val tvName = findViewById<TextView>(R.id.tvResName)
        val tvLastName = findViewById<TextView>(R.id.tvResLastName)
        val tvEmail = findViewById<TextView>(R.id.tvResEmail)
        val tvGender = findViewById<TextView>(R.id.tvResGender)
        val tvPassword = findViewById<TextView>(R.id.tvResPassword)
        val btnSendActivityHome = findViewById<Button>(R.id.btHome)
        val btnSendActivityRegister = findViewById<Button>(R.id.btnConfirm)

        intent.extras?.let {
            if (it.containsKey("EXTRA_NAME_KEY"))
                tvName.text = it.getString("EXTRA_NAME_KEY", "")
            if (it.containsKey("EXTRA_LASTNAME_KEY"))
                tvLastName.text = it.getString("EXTRA_LASTNAME_KEY", "")
            if (it.containsKey("EXTRA_EMAIL_KEY"))
                tvEmail.text = it.getString("EXTRA_EMAIL_KEY", "")
            if (it.containsKey("EXTRA_GENDER_KEY"))
                tvGender.text = it.getString("EXTRA_GENDER_KEY", "")
            if (it.containsKey("EXTRA_PASSWORD_KEY"))
                tvPassword.text = it.getString("EXTRA_PASSWORD_KEY", "")
        }

        btnSendActivityHome.setOnClickListener {
            val intent = Intent(this, MenuTareasActivity::class.java).apply {
            }
            startActivity(intent)
            //No se termina la actividad  para que se pueda verificar el regreso
        }
        btnSendActivityRegister.setOnClickListener {
            val intent = Intent(this, AzulTareaRegisterActivity::class.java).apply {
            }
            startActivity(intent)
            finish()
            //Se termina la actividad, no se puede regresar a esta
        }
    }
}