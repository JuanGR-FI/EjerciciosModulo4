package com.jacgr.ejerciciosmodulo4.tarearegistro

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.jacgr.ejerciciosmodulo4.R

class InfoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info)

        val tvName = findViewById<TextView>(R.id.tvNameData)
        val tvLastName = findViewById<TextView>(R.id.tvLastNameData)
        val tvEmail = findViewById<TextView>(R.id.tvEmailData)
        val tvGender = findViewById<TextView>(R.id.tvGenderData)
        val tvPassword = findViewById<TextView>(R.id.tvPasswordData)

        tvName.text = intent.getStringExtra("EXTRA_NAME")
        tvLastName.text = intent.getStringExtra("EXTRA_LAST_NAME")
        tvEmail.text = intent.getStringExtra("EXTRA_EMAIL")
        tvGender.text = intent.getStringExtra("EXTRA_GENDER")
        tvPassword.text = intent.getStringExtra("EXTRA_PASSWORD")

    }
}