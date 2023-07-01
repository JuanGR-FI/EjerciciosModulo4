package com.jacgr.ejerciciosmodulo4.Ejercicio3.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.jacgr.ejerciciosmodulo4.Ejercicio2.models.Game
import com.jacgr.ejerciciosmodulo4.R
import com.jacgr.ejerciciosmodulo4.databinding.FragmentSendParamsBinding

class SendParamsFragment : Fragment(R.layout.fragment_send_params) {
    private lateinit var binding : FragmentSendParamsBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentSendParamsBinding.bind(view)

        binding.btnSend.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.fgContainerView, ReceiveParamsFragment.newInstance("Juan Cervantes", Game("Halo", 1499f, "Disparos")))
                .addToBackStack("ReceiverFragment")
                .commit()
        }

    }

    companion object {
        @JvmStatic
        fun newInstance() = SendParamsFragment()
    }
}