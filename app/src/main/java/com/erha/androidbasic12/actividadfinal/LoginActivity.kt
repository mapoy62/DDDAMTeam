package com.erha.androidbasic12.actividadfinal

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.erha.androidbasic12.R
import com.erha.androidbasic12.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private lateinit var binding : ActivityLoginBinding
    // For the fragment-turned-activity


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //Requiere nombre del parametro del que se manda información
        //supportFragmentManager.beginTransaction().add()(R.id.fragmentLoginReceiver, xx.newInstance()).commit()


    }
}