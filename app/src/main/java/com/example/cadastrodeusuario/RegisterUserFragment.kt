package com.example.cadastrodeusuario

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.cadastrodeusuario.databinding.FragmentRegisterUserBinding
import kotlinx.android.synthetic.main.fragment_register_user.*

class RegisterUserFragment : Fragment() {
    private lateinit var binding: FragmentRegisterUserBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRegisterUserBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        registerUser()
    }

    private fun registerUser() {
        binding.apply {
            buttonRegisterUser.setOnClickListener {
                if(validateFildsRegisterUser()) {
                    findNavController().navigate(
                        RegisterUserFragmentDirections.actionRegisterUserFragmentToUserInformationFragment()
                    )
                }else {
                    Toast.makeText(context, "Digite todos os campos", Toast.LENGTH_SHORT).show()
                }
            }

            imageButtonArrowBackRegisterUser.setOnClickListener {
                findNavController().navigate(
                    RegisterUserFragmentDirections.actionRegisterUserFragmentToHomeFragment()
                )
            }
        }
    }

    private fun validateFildsRegisterUser(): Boolean {
        return (editTextName.text.isNotEmpty() && editTextEmail.text.isNotEmpty() && editTextPassword.text.isNotEmpty() && editTextCity.text.isNotEmpty() && editTextCountry.text.isNotEmpty())
    }
}