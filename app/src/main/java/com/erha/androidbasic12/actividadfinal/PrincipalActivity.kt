package com.erha.androidbasic12.actividadfinal

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.erha.androidbasic12.R
import com.erha.androidbasic12.databinding.ActivityPrincipalBinding

class PrincipalActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPrincipalBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityPrincipalBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Llamamos al fragment con el que inicia - Login
        supportFragmentManager
            .beginTransaction()
            .add(R.id.fragmentPrincipal, LoginFragment.newInstance())
           // .add(R.id.fragmentPrincipal, SignUpFragment.newInstance())
            .commit()
    }
}