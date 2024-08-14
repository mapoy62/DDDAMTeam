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
            var selectedSex = ""

            var sex = binding.rgSex
            //RADIOGROUP
            sex.setOnCheckedChangeListener{_, id ->
                selectedSex = when(id){
                    R.id.rbWoman -> "Woman"
                    R.id.rbMan -> "Man"
                    else -> "Other / PreferNotSay"
                }
            }

            //Validando la info



        }
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            SignUpFragment().apply {}
    }
}