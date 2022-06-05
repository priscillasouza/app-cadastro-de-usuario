package com.example.cadastrodeusuario

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.cadastrodeusuario.databinding.FragmentListInformationBinding

class ListInformationFragment : Fragment() {

    private lateinit var binding: FragmentListInformationBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentListInformationBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setListener()
    }

    private fun setListener() {
        binding.apply {
            imageViewArrowBackUserInformation.setOnClickListener {
                findNavController().navigate(
                    ListInformationFragmentDirections.actionUserInformationFragmentToHomeFragment()
                )
            }
        }
    }
}