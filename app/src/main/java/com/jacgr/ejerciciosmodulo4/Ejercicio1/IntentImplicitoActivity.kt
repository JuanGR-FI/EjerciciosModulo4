package com.jacgr.ejerciciosmodulo4.Ejercicio1

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.jacgr.ejerciciosmodulo4.R

class IntentImplicitoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent_implicito)

        val btnSend = findViewById<Button>(R.id.btnSend)
        val btnUrl = findViewById<Button>(R.id.btnUrl)

        btnSend.setOnClickListener {
            val emailIntent = Intent(Intent.ACTION_SENDTO).apply {
                data = Uri.parse("mailto:")
                //putExtra(Intent.EXTRA_EMAIL, arrayOf("juan60430@hotmail.com"))
                putExtra(Intent.EXTRA_SUBJECT, "Aviso urgente")
                putExtra(Intent.EXTRA_TEXT, "Esto es una prueba para enviar correo mediante un intent implicito")
            }
            startActivity(Intent.createChooser(emailIntent, "Send email using..."))
        }

        btnUrl.setOnClickListener {
            val urlIntent = Intent(Intent.ACTION_VIEW, Uri.parse("http://www.google.com"))
            startActivity(urlIntent)
        }

    }
}