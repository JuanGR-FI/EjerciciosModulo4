package com.jacgr.ejerciciosmodulo4.Ejercicio3.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.jacgr.ejerciciosmodulo4.R
import com.jacgr.ejerciciosmodulo4.databinding.FragmentFirstBinding

class FirstFragment : Fragment(R.layout.fragment_first) {

    private lateinit var binding : FragmentFirstBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentFirstBinding.bind(view)

        binding.btnNextFragment.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.fgContainerView, SecondFragment.newInstance())
                .addToBackStack("SecondFragment")
                .commit()
        }

    }

    companion object {

        @JvmStatic
        fun newInstance() = FirstFragment()
    }
}