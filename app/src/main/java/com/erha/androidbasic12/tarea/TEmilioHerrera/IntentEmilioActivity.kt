package com.erha.androidbasic12.tarea.TEmilioHerrera

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.erha.androidbasic12.R
import com.erha.androidbasic12.tarea.MenuTareasActivity

class IntentEmilioActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent_emilio)

        val labelNombres = findViewById<TextView>(R.id.labelNombres)
        val labelApellido = findViewById<TextView>(R.id.labelApellido)
        val labelEmail = findViewById<TextView>(R.id.labelEmail)
        val labelPassword = findViewById<TextView>(R.id.labelPassword)
        val labelSex = findViewById<TextView>(R.id.labelSex)

        // Obtener los datos del Intent
        intent.extras?.let {
            if (it.containsKey("EXTRA_NAME_KEY")) {
                val name = it.getString("EXTRA_NAME_KEY", "")
                labelNombres.text = name
            }
            if (it.containsKey("EXTRA_LASTNAME_KEY")) {
                val apellido = it.getString("EXTRA_LASTNAME_KEY", "")
                labelApellido.text = apellido
            }
            if (it.containsKey("EXTRA_EMAIL_KEY")) {
                val email = it.getString("EXTRA_EMAIL_KEY", "")
                labelEmail.text = email
            }
            if (it.containsKey("EXTRA_PASSWORD_KEY")) {
                val password = it.getString("EXTRA_PASSWORD_KEY", "")
                labelPassword.text = password
            }
            if (it.containsKey("EXTRA_GENDER_KEY")) {
                val sex = it.getString("EXTRA_GENDER_KEY", "")
                labelSex.text = sex
            }
        }

        val btnSendActivity = findViewById<Button>(R.id.btMenu)
        val btnSendActivity2 = findViewById<Button>(R.id.btRegresar)

        btnSendActivity.setOnClickListener {
            val intent = Intent(this, MenuTareasActivity::class.java).apply {
            }
            startActivity(intent)
        }
        btnSendActivity2.setOnClickListener {
            val intent = Intent(this, EmilioTareaActivity::class.java).apply {
            }
            startActivity(intent)
        }
    }
}
