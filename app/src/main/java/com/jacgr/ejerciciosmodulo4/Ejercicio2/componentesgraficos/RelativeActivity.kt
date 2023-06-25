package com.jacgr.ejerciciosmodulo4.Ejercicio2.componentesgraficos

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.jacgr.ejerciciosmodulo4.R

class RelativeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_relative)

        val btnConstraintLayout = findViewById<Button>(R.id.btnConstraintLayout)

        btnConstraintLayout.setOnClickListener {
            val intent = Intent(this, ConstraintActivity::class.java)
            startActivity(intent)
        }

    }
}