package com.example.cadastrodeusuario

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.cadastrodeusuario.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {

    private lateinit var binding: FragmentLoginBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setListener()
    }

    private fun setListener() {
        binding.apply {
            buttonRegisterLogin.setOnClickListener {
                binding.run {
                    if (validationFieldsLogin()) {
                        findNavController().navigate(
                            LoginFragmentDirections.actionLoginFragmentToUserInformationFragment()
                        )
                    } else {
                        Toast.makeText(context, "Digite email e senha", Toast.LENGTH_SHORT).show()
                    }
                }

            }

            imageViewArrowBackLogin.setOnClickListener {
                findNavController().navigate(
                    LoginFragmentDirections.actionLoginFragmentToHomeFragment()
                )
            }
        }
    }

    private fun validationFieldsLogin(): Boolean {
        return (binding.editTextEmailLogin.text.isNotEmpty() && binding.editTextPasswordLogin.text.isNotEmpty())
    }
}