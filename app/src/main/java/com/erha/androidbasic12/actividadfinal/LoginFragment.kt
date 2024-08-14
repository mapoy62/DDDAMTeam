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

//POBLEMAS DE VERIFICACION (CORREGIDOS)
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
            if(binding.etEmail.text.toString().isEmpty() || binding.etPassword.text.toString().isEmpty()){
                when{
                    binding.etEmail.text.toString().isEmpty() -> Toast.makeText(activity,"Please write your email address", Toast.LENGTH_SHORT).show()
                    binding.etPassword.text.toString().isEmpty()-> Toast.makeText(activity,"Please write your password",Toast.LENGTH_SHORT).show()
                }
            }else{
                //Envío de datos al Activity que mostrará la info
                val intent = Intent(activity, LoggedInActivity::class.java).apply{
                    putExtra("EXTRA_EMAIL_KEY", binding.etEmail.text.toString())
                    putExtra("EXTRA_PASSWORD_KEY", binding.etPassword.text.toString())
                    //Toast.makeText(activity,"el email es ${binding.etEmail.text.toString()}", Toast.LENGTH_SHORT).show()
                }
               startActivity(intent)
            }
        }

        binding.btToRegister.setOnClickListener {
           parentFragmentManager.beginTransaction().replace(R.id.fragmentPrincipal,SignUpFragment.newInstance()).commit()
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




