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
import com.jacgr.ejerciciosmodulo4.databinding.FragmentLoginBinding
import com.jacgr.ejerciciosmodulo4.practicafinal.activities.HomeActivity


class LoginFragment : Fragment(R.layout.fragment_login) {

    private lateinit var binding : FragmentLoginBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentLoginBinding.bind(view)

        prepareUI()
    }

    private fun prepareUI(){
        //Email Input
        binding.etLoginEmail.doOnTextChanged { text, _, _, _ ->
            if(text!!.isNotEmpty()) binding.ilLoginEmail.error = null
        }

        //Password Input
        binding.etLoginPassword.doOnTextChanged { text, _, _, _ ->
            if(text!!.isNotEmpty()) binding.ilLoginPassword.error = null
        }

        //Login Button
        binding.btnLogin.setOnClickListener {
            validateForm()
        }

        //Register Layout - reemplazo de fragment
        binding.llRegister.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.fgLoginContainerView, RegisterFragment.newInstance())
                .addToBackStack("RegisterFragment")
                .commit()
        }
    }

    private fun validateForm(){
        var flag = true

        val email = binding.etLoginEmail.text.toString()
        val password = binding.etLoginPassword.text.toString()

        if(email.isNotEmpty()){
            Toast.makeText(requireContext(), email, Toast.LENGTH_SHORT).show()

            if(!PatternsCompat.EMAIL_ADDRESS.matcher(email).matches()){
                binding.ilLoginEmail.error = getString(R.string.invalid_email)
                flag = false
            }

        }else{
            binding.ilLoginEmail.error = getString(R.string.enter_email)
            flag = false
        }

        if(password.isNotEmpty()){
            Toast.makeText(requireContext(), password, Toast.LENGTH_SHORT).show()
        }else{
            binding.ilLoginPassword.error = getString(R.string.enter_password)
            flag = false
        }

        if(flag){
            //Toast.makeText(requireContext(), "Formulario valido", Toast.LENGTH_SHORT).show()

            val homeIntent = Intent(requireContext(), HomeActivity::class.java).apply {
                putExtra("EXTRA_EMAIL", email)
                putExtra("EXTRA_PASSWORD", password)
            }
            startActivity(homeIntent)
            activity?.finish()
        }

    }

    companion object {

        @JvmStatic
        fun newInstance() = LoginFragment()
    }
}