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
        var sex = binding.rgSex
        var selectedSex = ""

        //RADIOGROUP
        sex.setOnCheckedChangeListener{_, id ->
            selectedSex = when(id){
                R.id.rbWoman -> getString(R.string.rgOption1)
                R.id.rbMan -> getString(R.string.rgOption2)
                else -> getString(R.string.rgOption3)
            }
        }

        binding.btRegistrar.setOnClickListener {
            //Validando la info
                if (binding.etName.text.toString().isEmpty() || binding.etLastName.text.toString().isEmpty() ||
                    binding.etEmail.text.toString().isEmpty() || binding.etPassword.text.toString().isEmpty()) {

                    when {
                        binding.etName.text.toString().isEmpty() -> Toast.makeText(activity, getString(R.string.toast_name), Toast.LENGTH_SHORT).show()
                        binding.etLastName.text.toString().isEmpty() -> Toast.makeText(activity, getString(R.string.toast_lastName), Toast.LENGTH_SHORT).show()
                        binding.etEmail.text.toString().isEmpty() -> Toast.makeText(activity, getString(R.string.toast_email), Toast.LENGTH_SHORT).show()
                        binding.etPassword.text.toString().isEmpty() -> Toast.makeText(activity, getString(R.string.toast_password) , Toast.LENGTH_SHORT).show()
                    }
                } else if (sex.checkedRadioButtonId == -1 || selectedSex.isEmpty()) {  // Verifica si ningún botón está seleccionado
                    Toast.makeText(activity, getString(R.string.toast_gender), Toast.LENGTH_SHORT).show()
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

    companion object {
        @JvmStatic
        fun newInstance() =
            SignUpFragment().apply {}
    }
}