package com.erha.androidbasic12.actividadfinal

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.erha.androidbasic12.R
import com.erha.androidbasic12.databinding.FragmentReceiverLoginBinding


class ReceiverLoginFragment : Fragment() {

    private lateinit var  binding : FragmentReceiverLoginBinding
    private var name : String? = ""
    private var lastname : String? = ""
    private var email : String? = ""
    private var password : String? = ""
    private var gender : String? = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            name = it.getString("ARG_NAME")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding =  FragmentReceiverLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ReceiverLoginFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}