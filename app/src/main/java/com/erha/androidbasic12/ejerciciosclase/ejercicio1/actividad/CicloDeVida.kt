package com.erha.androidbasic12.ejerciciosclase.ejercicio1.actividad

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.erha.androidbasic12.R

class CicloDeVida : AppCompatActivity() {
    private val register = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){ }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_ejercicio1)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btnSendActivity = findViewById<Button>(R.id.btnSendActivity2)


        btnSendActivity.setOnClickListener {
            val intent = Intent(this, IntentWeb::class.java).apply {
            }

            register.launch(intent)
//            startActivity(intent)
        }

        val btnSendActivity3 = findViewById<Button>(R.id.btnSendActivity3)


        btnSendActivity3.setOnClickListener {
            val intent = Intent(this, Actividad1::class.java).apply {
            }

            register.launch(intent)
//            startActivity(intent)
        }

        Log.e("LifeCycle","onCreate")
        Toast.makeText(this,"onCreate", Toast.LENGTH_LONG).show()
    }

    override fun onStart() {
        super.onStart()
        Log.e("LifeCycle","onStart")
        Toast.makeText(this,"onStart", Toast.LENGTH_LONG).show()
    }

    override fun onResume() {
        super.onResume()
        Log.e("LifeCycle","onResume")
        Toast.makeText(this,"onResume", Toast.LENGTH_LONG).show()
    }

    override fun onPause() {
        super.onPause()
        Log.e("LifeCycle","onPause")
        Toast.makeText(this,"onPause", Toast.LENGTH_LONG).show()
    }

    override fun onStop() {
        super.onStop()
        Log.e("LifeCycle","onStop")
        Toast.makeText(this,"onStop", Toast.LENGTH_LONG).show()
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e("LifeCycle","onDestroy")
        Toast.makeText(this,"onDestroy", Toast.LENGTH_LONG).show()
    }

    override fun onRestart() {
        super.onRestart()
        Log.e("LifeCycle","onRestart")
        Toast.makeText(this,"onRestart", Toast.LENGTH_LONG).show()
    }



}





