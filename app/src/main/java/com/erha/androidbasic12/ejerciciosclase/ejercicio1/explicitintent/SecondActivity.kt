package com.erha.androidbasic12.ejerciciosclase.ejercicio1.explicitintent

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.erha.androidbasic12.R

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        supportActionBar?.setDisplayShowTitleEnabled(false)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)


        val labelName = findViewById<TextView>(R.id.labelName)
        val btnReturn = findViewById<Button>(R.id.btnReturn)

        intent.extras?.let {
            if (it.containsKey("EXTRA_NAME_KEY")) {
                val name = it.getString("EXTRA_NAME_KEY", "")
                labelName.text = name
                //Toast.makeText(this, "Mi nombre es: $name", Toast.LENGTH_SHORT).show()
            }
            if (it.containsKey("EXTRA_AGE_KEY")) {
                val age = it.getInt("EXTRA_AGE_KEY", 0)
                Toast.makeText(this, "Mi edad es: $age", Toast.LENGTH_LONG).show()
            }
//            Toast.makeText(this, "Mi edad es: $age, mi apellido es: $surname", Toast.LENGTH_LONG).show()
        }
            btnReturn.setOnClickListener {
                val resultIntent = Intent().apply {
                    putExtra("EXTRA_IS_CORRECT_KEY", true)
                }

                setResult(RESULT_OK, resultIntent)
                finish()
            }
        }

    //Este codigo es para hacer la funcion de regresar al icono dentro del home podemos definir que hace el icono al dar click
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            android.R.id.home -> {
                onBackPressedDispatcher.onBackPressed()
                //Toast.makeText("EXTRA_IS_CORRECT", )
            }
        }

        return super.onOptionsItemSelected(item)
    }
    }

