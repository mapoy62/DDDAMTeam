package com.erha.androidbasic12.actividadfinal

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.erha.androidbasic12.R
import com.erha.androidbasic12.databinding.FragmentLoginBinding

/**
 * A simple [Fragment] subclass.
 * Use the [LoginFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class LoginFragment : Fragment() {
    private lateinit var binding: FragmentLoginBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoginBinding.inflate(layoutInflater, container, false)

        val email = binding.etEmail.text.toString()
        val password = binding.etPassword.text.toString()
        val btLogin = binding.btLogin

        btLogin.setOnClickListener {
            if(email.isEmpty() || password.isEmpty()){
                when{
                    email.isEmpty() -> Toast.makeText(activity,"Please write your email address", Toast.LENGTH_SHORT).show()
                    password.isEmpty()-> Toast.makeText(activity,"Please write your password",Toast.LENGTH_SHORT).show()
                }
            }else{
                //Envío de datos al Activity que mostrará la info
                val intent = Intent(activity, ::class.java).apply{
                    putExtra("EXTRA_NAME_KEY", email)
                    putExtra("EXTRA_PASSWORD_KEY", password)
                }
               startActivity(intent)
            }
        }
        return binding.root
    }

    //Referencia al "No tengo cuenta"
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        //Llamado al fragment de Register

    }

    companion object{
        @JvmStatic
        fun newInstance() = LoginFragment()
    }
}




