package com.jacgr.ejerciciosmodulo4.practicafinal.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.jacgr.ejerciciosmodulo4.R
import com.jacgr.ejerciciosmodulo4.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
    private lateinit var binding : ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val name = intent?.getStringExtra("EXTRA_NAME")
        val lastName = intent?.getStringExtra("EXTRA_LAST_NAME")
        val email = intent?.getStringExtra("EXTRA_EMAIL")
        val password = intent?.getStringExtra("EXTRA_PASSWORD")

        binding.tvEmail.text = getString(R.string.email_text_view, email)
        binding.tvPassword.text = getString(R.string.password_text_view, password)

        if(name != null && lastName != null){
            binding.tvName.visibility = View.VISIBLE
            binding.tvLastName.visibility = View.VISIBLE

            binding.tvName.text = getString(R.string.name_text_view, name)
            binding.tvLastName.text = getString(R.string.last_name_text_view, lastName)
        }

    }
}