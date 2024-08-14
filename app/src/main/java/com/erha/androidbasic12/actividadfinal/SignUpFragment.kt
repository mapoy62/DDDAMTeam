package com.erha.androidbasic12.actividadfinal

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.erha.androidbasic12.R
import com.erha.androidbasic12.databinding.ActivityPrincipalBinding
import com.erha.androidbasic12.databinding.FragmentSignUpBinding
import com.erha.androidbasic12.tarea.TOliviaYuyuMaceda.RegisterIntentActivityOYMP

//PROBLEMAS CON LA PARTE DE GENDER

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [SignUpFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SignUpFragment : Fragment() {

    private lateinit var binding: FragmentSignUpBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentSignUpBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btRegistrar.setOnClickListener {
            val name = binding.etName.text.toString()
            val lastName = binding.etLastName.text.toString()
            val email = binding.etEmail.text.toString()
            val pass = binding.etPassword.text.toString()
            var sex = binding.rgSex
            var selectedSex = ""


            //RADIOGROUP
            sex.setOnCheckedChangeListener{_, id ->
                selectedSex = when(id){
                    R.id.rbWoman -> "Woman"
                    R.id.rbMan -> "Man"
                    else -> "Other / PreferNotSay"
                }
            }

            //CHECAR COMO MANDAR WARNING DE UNSELECTED GENDER
            //Validando la info
            binding.btRegistrar.setOnClickListener {
                if (binding.etName.text.toString().isEmpty() || binding.etLastName.text.toString().isEmpty() ||
                    binding.etEmail.text.toString().isEmpty() || binding.etPassword.text.toString().isEmpty()) {

                    when {
                        binding.etName.text.toString().isEmpty() -> Toast.makeText(activity, "Please write a name", Toast.LENGTH_SHORT).show()
                        binding.etLastName.text.toString().isEmpty() -> Toast.makeText(activity, "Please write a last name", Toast.LENGTH_SHORT).show()
                        binding.etEmail.text.toString().isEmpty() -> Toast.makeText(activity, "Please write an email", Toast.LENGTH_SHORT).show()
                        binding.etPassword.text.toString().isEmpty() -> Toast.makeText(activity, "Please write a password", Toast.LENGTH_SHORT).show()
                    }
                } else if (sex.checkedRadioButtonId == -1) {  // Verifica si ningún botón está seleccionado
                    Toast.makeText(activity, "Please select a gender", Toast.LENGTH_SHORT).show()
                } else {
                    // Envío de datos al activity
                    val intent = Intent(activity, LoggedInActivity::class.java).apply {
                        putExtra("EXTRA_NAME_KEY", binding.etName.text.toString())
                        putExtra("EXTRA_LASTNAME_KEY", binding.etLastName.text.toString())
                        putExtra("EXTRA_EMAIL_KEY", binding.etEmail.text.toString())
                        putExtra("EXTRA_PASSWORD_KEY", binding.etPassword.text.toString())
                        putExtra("EXTRA_GENDER_KEY", selectedSex)
                    }
                    startActivity(intent)
                }
            }


        }
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            SignUpFragment().apply {}
    }
}