package com.erha.androidbasic12.actividadfinal

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.erha.androidbasic12.databinding.ActivityLoggedInBinding

//azul
class LoggedInActivity : AppCompatActivity() {
    private lateinit var binding : ActivityLoggedInBinding
    // For the fragment-turned-activity


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoggedInBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //Requiere nombre del parametro del que se manda información

        intent.extras?.let {
            if (it.containsKey("EXTRA_NAME_KEY")) {
                binding.tvName.text = it.getString("EXTRA_NAME_KEY", "")
                binding.tvName.visibility = View.VISIBLE
            }else
                binding.tvName.visibility = View.GONE

            if (it.containsKey("EXTRA_LASTNAME_KEY")) {
                binding.tvLastName.text = it.getString("EXTRA_LASTNAME_KEY", "")
                binding.tvLastName.visibility = View.VISIBLE
            }else
                binding.tvLastName.visibility = View.GONE

            if (it.containsKey("EXTRA_EMAIL_KEY"))
                binding.tvEmail.text = it.getString("EXTRA_EMAIL_KEY", "")

            if (it.containsKey("EXTRA_GENDER_KEY")) {
                binding.tvGender.text = it.getString("EXTRA_GENDER_KEY", "")
                binding.tvGender.visibility = View.VISIBLE
            }else
                binding.tvGender.visibility = View.GONE

            if (it.containsKey("EXTRA_PASSWORD_KEY"))
                binding.tvPassword.text = it.getString("EXTRA_PASSWORD_KEY", "")
        }

        //Toast.makeText(this,"el email es $email", Toast.LENGTH_SHORT).show()
        binding.btRegresar.setOnClickListener {
            finish()
        }

    }
}