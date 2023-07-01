package com.jacgr.ejerciciosmodulo4.Ejercicio3.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.jacgr.ejerciciosmodulo4.Ejercicio1.FirstActivity
import com.jacgr.ejerciciosmodulo4.Ejercicio1.SecondActivity
import com.jacgr.ejerciciosmodulo4.Ejercicio2.models.Game
import com.jacgr.ejerciciosmodulo4.R
import com.jacgr.ejerciciosmodulo4.databinding.FragmentReceiveParamsBinding

class ReceiveParamsFragment : Fragment(R.layout.fragment_receive_params) {

    private lateinit var binding : FragmentReceiveParamsBinding
    private var name : String? = ""
    private var game: Game? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            name = it.getString("ARG_NAME")
            game = it.getSerializable("ARG_GAME") as Game
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentReceiveParamsBinding.bind(view)

        binding.tvName.text = name
        binding.tvGameName.text = game?.name

        binding.btnSendActivity.setOnClickListener {
            val intent = Intent(requireContext(), FirstActivity::class.java)
            intent.apply {
                putExtra("EXTRA_NAME", name)
            }

            startActivity(intent)
        }

    }

    companion object {

        @JvmStatic
        fun newInstance(name: String, game: Game) =
            ReceiveParamsFragment().apply {
                arguments = Bundle().apply {
                    putString("ARG_NAME", name)
                    putSerializable("ARG_GAME", game)
                }
            }
    }
}