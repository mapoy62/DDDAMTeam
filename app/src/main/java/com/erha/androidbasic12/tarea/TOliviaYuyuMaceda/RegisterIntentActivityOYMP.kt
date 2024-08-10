package com.erha.androidbasic12.tarea.TOliviaYuyuMaceda

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.erha.androidbasic12.R
import com.erha.androidbasic12.tarea.MenuTareasActivity

class RegisterIntentActivityOYMP : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_intent_oymp)


        //Se hace referencia ahora al layout del intent
        val labelName = findViewById<TextView>(R.id.tvName)
        val labelLastName = findViewById<TextView>(R.id.tvLastName)
        val labelEmail = findViewById<TextView>(R.id.tvEmail)
        val labelSex= findViewById<TextView>(R.id.tvSex)
        val labelCountry = findViewById<TextView>(R.id.tvCountry)
        val ivWelcome = findViewById<ImageView>(R.id.ivWelcome)
        val tvName = findViewById<TextView>(R.id.Name)
        ivWelcome.setImageResource(R.drawable.img_welcome_oymp)

        val btnSendHome = findViewById<Button>(R.id.btnHome)
        val btnSendActivityRegister = findViewById<Button>(R.id.btnRegisterOYMP)

        //Recuperando la información que nos llegó al activityIntent
        intent.extras?.let {
            if(it.containsKey("EXTRA_NAME_KEY")){
                val name = it.getString("EXTRA_NAME_KEY", "")
                labelName.text = name
                tvName.text = name
            }
            if(it.containsKey("EXTRA_LAST_NAME_KEY")){
                val lastName = it.getString("EXTRA_LAST_NAME_KEY", "")
                labelLastName.text = lastName
            }
            if(it.containsKey("EXTRA_EMAIL_KEY")){
                val email = it.getString("EXTRA_EMAIL_KEY", "")
                labelEmail.text = email
            }
            if(it.containsKey("EXTRA_SEX_KEY")){
                val sex = it.getString("EXTRA_SEX_KEY", "")
                labelSex.text = sex
            }
            if(it.containsKey("EXTRA_COUNTRY_KEY")){
                val country = it.getString("EXTRA_COUNTRY_KEY", "")
                labelCountry.text = country
            }
        }

        btnSendHome.setOnClickListener {
            val homeIntent = Intent(this, MenuTareasActivity::class.java).apply {}
            startActivity(homeIntent)
        }
        btnSendActivityRegister.setOnClickListener {
            val registerIntentOYMP = Intent(this, RegisterActivityOYMP::class.java).apply {}
            startActivity(registerIntentOYMP)
            finish()
        }
    }
}
