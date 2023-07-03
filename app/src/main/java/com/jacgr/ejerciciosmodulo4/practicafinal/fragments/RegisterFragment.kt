package com.jacgr.ejerciciosmodulo4.practicafinal.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.util.PatternsCompat
import androidx.core.widget.doOnTextChanged
import com.jacgr.ejerciciosmodulo4.R
import com.jacgr.ejerciciosmodulo4.databinding.FragmentRegisterBinding
import com.jacgr.ejerciciosmodulo4.practicafinal.activities.HomeActivity


class RegisterFragment : Fragment(R.layout.fragment_register) {

    private lateinit var binding : FragmentRegisterBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentRegisterBinding.bind(view)

        prepareUI()
    }

    private fun prepareUI(){

        //Name Input
        binding.etRegisterName.doOnTextChanged { text, _, _, _ ->
            if(text!!.isNotEmpty()) binding.ilRegisterName.error = null
        }

        //Last Name Input
        binding.etRegisterLastName.doOnTextChanged { text, _, _, _ ->
            if(text!!.isNotEmpty()) binding.ilRegisterLastName.error = null
        }

        //Email Input
        binding.etRegisterEmail.doOnTextChanged { text, _, _, _ ->
            if(text!!.isNotEmpty()) binding.ilRegisterEmail.error = null
        }

        //Password Input
        binding.etRegisterPassword.doOnTextChanged { text, _, _, _ ->
            if(text!!.isNotEmpty()) binding.ilRegisterPassword.error = null
        }

        //Login Button
        binding.btnRegister.setOnClickListener {
            validateForm()
        }

    }

    private fun validateForm() {
        var flag = true

        val name = binding.etRegisterName.text.toString()
        val lastName = binding.etRegisterLastName.text.toString()
        val email = binding.etRegisterEmail.text.toString()
        val password = binding.etRegisterPassword.text.toString()

        if(name.isEmpty()){
            binding.ilRegisterName.error = getString(R.string.enter_name)
            flag = false
        }

        if(lastName.isEmpty()){
            binding.ilRegisterLastName.error = getString(R.string.enter_last_name)
            flag = false
        }

        if(email.isNotEmpty()){
            if(!PatternsCompat.EMAIL_ADDRESS.matcher(email).matches()){
                binding.ilRegisterEmail.error = getString(R.string.invalid_email)
                flag = false
            }

        }else{
            binding.ilRegisterEmail.error = getString(R.string.enter_email)
            flag = false
        }

        if(password.isEmpty()){
            binding.ilRegisterPassword.error = getString(R.string.enter_password)
            flag = false
        }

        if(flag){
            val homeIntent = Intent(requireContext(), HomeActivity::class.java).apply {
                putExtra("EXTRA_NAME", name)
                putExtra("EXTRA_LAST_NAME", lastName)
                putExtra("EXTRA_EMAIL", email)
                putExtra("EXTRA_PASSWORD", password)
            }
            startActivity(homeIntent)
            activity?.finish()
        }
    }

    companion object {

        @JvmStatic
        fun newInstance() = RegisterFragment()
    }
}