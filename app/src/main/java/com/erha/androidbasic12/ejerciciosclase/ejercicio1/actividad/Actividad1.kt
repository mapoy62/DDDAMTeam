package com.erha.androidbasic12.ejerciciosclase.ejercicio1.actividad

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.erha.androidbasic12.R
import com.erha.androidbasic12.ejerciciosclase.ejercicio1.explicitintent.SecondActivity

class Actividad1 : AppCompatActivity() {

    private val register = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){ result ->
        if (result.resultCode == RESULT_OK){
            val isCorrect = result.data?.getBooleanExtra("EXTRA_IS_CORRECT_KEY", false)
            if (isCorrect == true){
                onBackPressedDispatcher.onBackPressed()
            }else{
                Toast.makeText(this, "resultExtra= $isCorrect", Toast.LENGTH_SHORT).show()
            }
        }else{
            Toast.makeText(this, "CANCELLED", Toast.LENGTH_SHORT).show()
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_actividad1)

        val btnSendActivity = findViewById<Button>(R.id.btnSendActivity)


        btnSendActivity.setOnClickListener {
            val intent = Intent(this, Actividad2::class.java).apply {
                putExtra("EXTRA_NAME_KEY","Equipo: Unia De Perro")
                putExtra("EXTRA_MEMBERS_KEY", "Azul, Olivia, Emilio")
                putExtra("EXTRA_EDADES_KEY", "23, 26, 23")
            }

            register.launch(intent)
//            startActivity(intent)
        }

    }
}