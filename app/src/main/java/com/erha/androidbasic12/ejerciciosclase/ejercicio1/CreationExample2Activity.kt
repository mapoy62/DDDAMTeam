package com.erha.androidbasic12.ejerciciosclase.ejercicio1

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.erha.androidbasic12.R

class CreationExample2Activity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_creation_example_2)    //Hacemos referencia al id de los layouts para la interface con la clase R
    }
}