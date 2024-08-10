package com.erha.androidbasic12.tarea

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.erha.androidbasic12.R
import com.erha.androidbasic12.tarea.TAzulAlfaroFernandez.AzulTareaRegisterActivity
import com.erha.androidbasic12.tarea.TEmilioHerrera.EmilioTareaActivity
import com.erha.androidbasic12.tarea.TOliviaYuyuMaceda.RegisterActivityOYMP

class MenuTareasActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_tareas)


        val btnSendActivity = findViewById<Button>(R.id.btnEmilio)
        val btnSendActivityAzul = findViewById<Button>(R.id.btnAzul)
        val btnSendActivityOlivia = findViewById<Button>(R.id.btnOlivia)

        //Actividad Emilio
        btnSendActivity.setOnClickListener {
            val intent = Intent(this, EmilioTareaActivity::class.java).apply {
            }
            startActivity(intent)
        }

        //Actividad de Azul
        btnSendActivityAzul.setOnClickListener {
            val intent = Intent(this, AzulTareaRegisterActivity::class.java).apply {
            }
            startActivity(intent)
        }

        //Actividad Olivia
        btnSendActivityOlivia.setOnClickListener {
            val intent = Intent(this, RegisterActivityOYMP::class.java).apply {
            }
            startActivity(intent)
        }
    }
}